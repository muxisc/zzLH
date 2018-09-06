/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.lh.blog.search.controller;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.lh.blog.search.model.GoodClassInfo;
import com.lh.blog.search.model.GoodInfo;
import com.lh.blog.search.service.IGoodClassInfoService;
import com.lh.blog.search.service.IGoodInfoService;
import com.lh.blog.system.controller.SysPermisionController;
import com.lh.blog.system.dto.SysUserDto;
import com.lh.blog.system.model.SysRole;
import com.lh.blog.system.model.SysUser;
import com.lh.blog.system.model.SysUserRole;

/**
 * 描述:    goodinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2018年04月27日
 */
@Controller
@RequestMapping("/goodInfo/")
public class GoodInfoController extends BaseController {
	private static final Logger logger=LoggerFactory.getLogger(SysPermisionController.class);
	
	
	@Autowired
	private IGoodInfoService goodInfoService;
	
	
	@Autowired
	private IGoodClassInfoService goodClassInfoService;
	
	
	@RequestMapping("list")
	public String sysUserList() {
		return "search/goodInfo";
	} 
	
	
	
	@RequestMapping("showUsers")
	@ResponseBody
	public PageResponse<GoodInfo> showUsers(PageRequest request) throws Exception{
		List<GoodInfo> data=goodInfoService.selectAllUsers(request);
		return new PageResponse<GoodInfo>(data);
	}
	
	
	
	
	@RequestMapping("showAddAndEdit")
	public ModelAndView showAddAndEdit(String uid) {
		ModelAndView model=new ModelAndView("search/goodinfo_addAndEdit");
		//获取所有角色信息
		List<GoodClassInfo> allRoles=goodClassInfoService.selectAllPermisions();
		if(allRoles.size()>0) {
			model.addObject("allRoles", allRoles);
		}
		
		return model;
	} 
}