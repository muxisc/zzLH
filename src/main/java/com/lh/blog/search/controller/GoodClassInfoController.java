/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.lh.blog.search.controller;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.lh.blog.search.model.GoodClassInfo;
import com.lh.blog.search.service.IGoodClassInfoService;
import com.lh.blog.system.controller.SysPermisionController;
import com.lh.blog.system.dto.PermisionTreeNode;
import com.lh.blog.system.model.SysPermision;

/**
 * 描述:    goodClassInfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2018年04月27日
 */
@Controller
@RequestMapping("/goodClassInfo/")
public class GoodClassInfoController extends BaseController {
    private static final Logger logger=LoggerFactory.getLogger(SysPermisionController.class);
	
	@Autowired
	private IGoodClassInfoService goodClassInfoService;
	
	@RequestMapping("list")
	public String sysPermisionList() {
		return "search/goodClassList";
	}
	
	
	/**
	 * 展示权限资源树
	 * @return
	 */
	@RequestMapping(value="showGoodClassTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult showPermisionTree() {
		//查询所有权限资源
		List<GoodClassInfo> allPermisions=goodClassInfoService.selectAllPermisions();
		//构造permisionTree权限树的节点数据
		List<PermisionTreeNode> nodes=new ArrayList<PermisionTreeNode>();
		for(GoodClassInfo permision:allPermisions) {
			PermisionTreeNode node=new PermisionTreeNode();
			node.setId(permision.getUid());
			node.setName(permision.getGoodName());
			String parentId=permision.getGood_parent_id();
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
		GoodClassInfo sysPermision=goodClassInfoService.selectByUid(uid);
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
		ModelAndView model=new ModelAndView("search/goodClass_addAndEdit");
		GoodClassInfo sysPermision=null;
		
		if(sysPermision==null) {
			//新增权限
			if(isNotBlank(sid)) {
				GoodClassInfo _temp=goodClassInfoService.selectByUid(sid);
				if(_temp!=null) {
					model.addObject("parentIdForZj", _temp.getUid());
				}
				
			}
			
		}
		return model;
	}
	
	
	
}