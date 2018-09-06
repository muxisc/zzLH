package com.lh.blog.system.controller;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.lh.blog.system.dto.SysUserDto;
import com.lh.blog.system.model.SysRole;
import com.lh.blog.system.model.SysUser;
import com.lh.blog.system.model.SysUserRole;
import com.lh.blog.system.service.ISysRoleService;
import com.lh.blog.system.service.ISysUserRoleService;
import com.lh.blog.system.service.ISysUserService;

/**
 * 描述:    sys_user 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
@Controller
@RequestMapping("/admin/system/sysuser/")
public class SysUserController extends BaseController {
	
	private static final Logger logger=LoggerFactory.getLogger(SysUserController.class);
	
	
	@Autowired
	private ISysUserService sysUserService;
	
	@Autowired
	private ISysRoleService sysRoleService;
	
	@Autowired
	private ISysUserRoleService sysUserRoleService;
	
	/**
	 * 进入用户管理页面
	 * @return
	 */
	@RequestMapping("list")
	public String sysUserList() {
		return "system/sysuser/user_list";
	} 
	
	
	/**
	 * 查询所有用户列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("showUsers")
	@ResponseBody
	public PageResponse<SysUserDto> showUsers(PageRequest request) throws Exception{
		System.out.println("用户管理");
		//mybatis分页插件pagehelper   需要在mybatis.xml中配置
		//PageResponse  分页结果对象                PageRequest 分页请求对象
		List<SysUserDto> data=sysUserService.selectAllUsers(request);
		return new PageResponse<SysUserDto>(data);
	}
	
	
	/**
	 * 进入新增-编辑页面
	 * @return
	 */
	@RequestMapping("showAddAndEdit")
	public ModelAndView showAddAndEdit(String uid) {
		ModelAndView model=new ModelAndView("system/sysuser/user_addAndEdit");
		//获取所有角色信息
		List<SysRole> allRoles=sysRoleService.getAllRoles();
		if(allRoles.size()>0) {
			model.addObject("allRoles", allRoles);
		}
		//uid不为空，即进行编辑
		if(isNotEmpty(uid)) {
			//获取当前用户的信息
			SysUser sysUser=sysUserService.selectByUid(uid);
			if(sysUser!=null) {
				model.addObject("sysUserEdit", sysUser);
				//获取当前用户的角色信息
				List<SysUserRole> sysUserRoleList=sysUserRoleService.selectByUserId(sysUser.getUid());
				Map<String,SysUserRole> sysUserRoleMap=new HashMap<String,SysUserRole>();
				for(SysUserRole sysUserRole:sysUserRoleList ) {
					sysUserRoleMap.put(sysUserRole.getUr_role_id(), sysUserRole);
				}
				model.addObject("sysUserRoleMap", sysUserRoleMap);
			}
		}
		return model;
	} 
	
	
	/**
	 * 表单验证       新增用户-编辑用户
	 * @param sysUsrdto
	 * @param result
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="saveUser",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveUser(@Valid @RequestBody SysUserDto sysUser,BindingResult result) throws Exception {
		//@Valid+@RequestBody  接收json的验证
		if(result.hasErrors()) {
			AjaxResult error=AjaxResult.error("后台参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		//修改用户并删除旧再添加新用户-角色关系
		String uid=sysUser.getUid();
		if(isNotEmpty(uid)) {
			//修改用户并修改用户-角色关系
			if(sysUserService.updateUser(sysUser, sysUser.getRoles())>0) {
				return AjaxResult.success("修改用户信息成功");
			}
			return AjaxResult.error("修改用户信息失败");
		}
		//新增用户并添加用户-角色关系
		try {
			sysUserService.insertUser(sysUser, sysUser.getRoles());
			return AjaxResult.success("新增用户成功");
		} catch (BusinessException e) {
			return AjaxResult.error(e.getMessage());
		}
	}
	
	/**
	 * 删除单个用户
	 * @param uid
	 * @return
	 */
	@RequestMapping("deleteUser")
	@ResponseBody
	public AjaxResult deleteUser(String uid) {
		if(isBlank(uid)) {
			return AjaxResult.error("未选择删除的用户");
		}
		if(sysUserService.deleteUser(uid)>0) {
			return AjaxResult.success("删除用户成功");
		}
		return AjaxResult.error("删除用户失败");
	}
	
	
	
}