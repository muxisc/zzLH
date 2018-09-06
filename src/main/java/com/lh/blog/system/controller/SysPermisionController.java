package com.lh.blog.system.controller;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.security.shiro.ShiroChainReloadService;
import com.lh.blog.system.dto.PermisionTreeNode;
import com.lh.blog.system.dto.SysPermisionDto;
import com.lh.blog.system.model.SysPermision;
import com.lh.blog.system.service.ISysPermisionService;

/**
 * 描述:    sys_permision 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
@Controller
@RequestMapping("/admin/system/syspermision/")
public class SysPermisionController extends BaseController {
	private static final Logger logger=LoggerFactory.getLogger(SysPermisionController.class);
	
	@Autowired
	private ISysPermisionService sysPermisionService;
	
	@Autowired
	private ShiroChainReloadService shiroChainReloadService;
	
	/**
	 * 进入权限列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String sysPermisionList() {
		System.out.println("权限管理");
		return "system/syspermision/permision_list";
	}
	
	/**
	 * 展示权限资源树
	 * @return
	 */
	@RequestMapping(value="showPermisionTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult showPermisionTree() {
		//查询所有权限资源
		List<SysPermision> allPermisions=sysPermisionService.selectAllPermisions();
		//构造permisionTree权限树的节点数据
		List<PermisionTreeNode> nodes=new ArrayList<PermisionTreeNode>();
		for(SysPermision permision:allPermisions) {
			PermisionTreeNode node=new PermisionTreeNode();
			node.setId(permision.getUid());
			node.setName(permision.getPermision_name());
			String parentId=permision.getPermision_parent_id();
			if(isNotBlank(parentId)) {  //二级  有父节点
				node.setpId(parentId);
			}else {
				node.setpId("0");
			}
			nodes.add(node);
		}
		
		return AjaxResult.success("加载权限数据成功", nodes);
	}
	
	/**
	 * 获取某个权限数据
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="selectByUid",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult selectByUid(String uid) {
		if(isBlank(uid)) {
			return AjaxResult.error("该权限不存在");
		}
		SysPermision sysPermision=sysPermisionService.selectByUid(uid);
		if(sysPermision!=null) {
			return AjaxResult.success("加载该权限成功",sysPermision);
		}else {
			return AjaxResult.error("该权限不存在");
		}
	}
	
	/**
	 * 进入新增权限-编辑权限页面
	 * @param id 需要修改的权限Id
	 * @param sid  权限树选中的权限Id
	 * @return
	 */
	@RequestMapping("showAddAndEdit")
	public ModelAndView showAddAndEdit(String sid,String id) {
		ModelAndView model=new ModelAndView("system/syspermision/permision_addAndEdit");
		SysPermision sysPermision=null;
		if(isNotBlank(id)) {
			//修改权限 需加载原权限信息
			sysPermision=sysPermisionService.selectByUid(id);
			if(sysPermision!=null) {
				model.addObject("sysPermision", sysPermision);
				String parentId=sysPermision.getPermision_parent_id();
				if(isNotBlank(parentId)) {
					SysPermision parentPermision=sysPermisionService.selectByUid(parentId);
					if(parentPermision!=null) {
						model.addObject("parentName", parentPermision.getPermision_name());
					}
				}
			}
		}
		if(sysPermision==null) {
			//新增权限
			if(isNotBlank(sid)) {
				SysPermision _temp=sysPermisionService.selectByUid(sid);
				if(_temp!=null) {
					model.addObject("parentIdForTj", _temp.getPermision_parent_id());
					model.addObject("parentIdForZj", _temp.getUid());
				}
				
			}
			
		}
		return model;
	}
	
	
	/**
	 * 新增权限--编辑权限
	 * @return
	 */
	@RequestMapping(value="doAddAndEdit",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAddAndEdit(@Valid SysPermisionDto sysPermision,BindingResult result) {
		if(result.hasErrors()) {
			AjaxResult error=AjaxResult.error("后台参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		if(isNotBlank(sysPermision.getUid())) {
			//修改权限
			if(sysPermisionService.updatePermision(sysPermision)>0) {
				return AjaxResult.success("修改权限成功");
			}else {
				return AjaxResult.error("修改权限失败");
			}
		}
		if(sysPermisionService.insertPermision(sysPermision)>0) {
			return AjaxResult.success("新增权限成功");
		}else {
			return AjaxResult.error("新增权限失败");
		}
		
	} 
	
	/**
	 * 删除权限
	 * @param uid
	 * @return
	 */
	@RequestMapping("deletePermision")
	@ResponseBody
	public AjaxResult deletePermision(String uid) throws Exception{
		if(isBlank(uid)) {
			return AjaxResult.error("删除的权限不存在");
		}
		if(sysPermisionService.isHasSub(uid)) {
			return AjaxResult.error("该权限下存在子权限不可删除");
		}
		if(sysPermisionService.deletePermision(uid)>0) {
			return AjaxResult.success("删除权限成功");
		}
		return AjaxResult.error("删除权限失败");
	}
	
	
	@RequestMapping("reload")
	@ResponseBody
	public AjaxResult reload()throws Exception{
		shiroChainReloadService.reloadChainDefinitions();
		return AjaxResult.success("系统权限定义刷新成功");
	}
	
	
}