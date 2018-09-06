package com.lh.blog.system.controller;


import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.lh.blog.system.dto.SysRoleDto;
import com.lh.blog.system.model.SysRole;
import com.lh.blog.system.model.SysRolePermision;
import com.lh.blog.system.service.ISysRolePermisionService;
import com.lh.blog.system.service.ISysRoleService;

/**
 * 描述:    sys_role 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
@Controller
@RequestMapping("/admin/system/sysrole/")
public class SysRoleController extends BaseController {
	private static final Logger logger=LoggerFactory.getLogger(SysRoleController.class);
	
	@Autowired
	private ISysRoleService sysRoleService;
	@Autowired
	private ISysRolePermisionService sysRolePermisionService;
	
	
	/**
	 * 进入角色列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String sysRoleList() {
		return "system/sysrole/role_list";
	}
	
	/**
	 * 展示角色列表
	 * @param request
	 * @return
	 */
	@RequestMapping("showRoles")
	@ResponseBody
	public PageResponse<SysRole> showRoles(PageRequest request){
		System.out.println("角色管理");
		List<SysRole> sysRoleList=sysRoleService.getPageRoles(request);
		return new PageResponse<SysRole>(sysRoleList);
	}
	
	/**
	 * 进入新增角色页面
	 * @return
	 */
	@RequestMapping("showAddAndEdit")
	public ModelAndView showAddAndEdit(String uid) {
		ModelAndView model=new ModelAndView("system/sysrole/role_addAndEdit");
		if(isNotEmpty(uid)) {   //进行编辑角色操作
			SysRole sysRole=sysRoleService.getRoleByUid(uid);
			if(sysRole!=null) {
				model.addObject("sysRole", sysRole);
			}
		}
		return model;
	}
	
	/**
	 * 新增-编辑角色
	 * @return
	 */
	@RequestMapping(value="saveRole",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveRole(@RequestBody SysRoleDto sysRole)throws Exception{
		Map<String,Object> qryMap=new HashMap<String,Object>();
		if(isNotEmpty(sysRole.getUid())) {    //编辑角色  角色名不能与其他角色重复
			qryMap.put("uid", sysRole.getUid());
			qryMap.put("role_name", sysRole.getRole_name());
			if(sysRoleService.getRoleByName(qryMap).size()<=0) {
				if(sysRoleService.updateByUid(sysRole,sysRole.getPermisions())>0) {
					return AjaxResult.success("编辑角色成功");
				}
				return AjaxResult.error("编辑角色失败");
			}
			return AjaxResult.error("编辑失败，角色名已经存在");
		}
		//新增角色     角色名不能重复
		qryMap.clear();     //从Map集合中移除所有映射关系
		qryMap.put("role_name", sysRole.getRole_name());
		if(sysRoleService.getRoleByName(qryMap).size()<=0) {
			if(sysRoleService.insertRolePer(sysRole, sysRole.getPermisions())>0) {
				return AjaxResult.success("新增角色成功");
			}
			return AjaxResult.error("新增角色失败");
		}
		return AjaxResult.error("新增失败，角色名已经存在");
		
		/*String uid=sysRole.getUid();
		if(isNotEmpty(uid)) {     //编辑角色
			if(sysRoleService.updateByUid(sysRole)>0) {
			  return AjaxResult.success("修改角色成功");	
			}
		}
		if(sysRoleService.insertRole(sysRole)>0) {
			return AjaxResult.success("增加角色成功");
		}
		return AjaxResult.error("增加或修改角色失败");*/
	}
	
	/**
	 * 获取该角色的所有权限
	 * @param roleId
	 * @return
	 */
	@RequestMapping("getPermisions")
	@ResponseBody
	public AjaxResult getPermisions(String roleId) {
		if(isNotEmpty(roleId)) {
			List<SysRolePermision> permisionList=sysRolePermisionService.getByRoleId(roleId);
		    if(permisionList.size()>0) {
		    	return AjaxResult.success("获取该角色所有权限成功", permisionList);
		    }
		}
		return AjaxResult.error("获取该角色所有权限失败");
	}
	
	
	/**
	 * 删除角色
	 * @param uid
	 * @return
	 */
	@RequestMapping("deleteRole")
	@ResponseBody
	public AjaxResult deleteRole(String uid) {
		if(isNotEmpty(uid)) {
			if(sysRoleService.deleteByUid(uid)>0) {
				return AjaxResult.success("删除角色成功");
			}
		}
		return AjaxResult.error("删除角色失败");
	}
			
			
}