/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.lh.blog.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.lh.blog.search.model.EmployeeInfo;
import com.lh.blog.search.model.GoodBuyInfo;
import com.lh.blog.search.service.IEmployeeInfoService;
import com.lh.blog.search.service.IGoodBuyInfoService;

/**
 * 描述:    goodbuyinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2018年04月27日
 */
@Controller
@RequestMapping("/buy/")
public class GoodBuyInfoController extends BaseController {
	
	
	@Autowired
	private IGoodBuyInfoService goodBuyInfoService;
	
	
	
	
	@RequestMapping("list")
	public String sysUserList() {
		return "search/buy";
	}
	
	
	
	@RequestMapping("showUsers")
	@ResponseBody
	public PageResponse<GoodBuyInfo> showUsers(PageRequest request) throws Exception{
		List<GoodBuyInfo> data=goodBuyInfoService.selectAllUsers(request);
		return new PageResponse<GoodBuyInfo>(data);
	}
	
	
	
	@RequestMapping("showAddAndEdit")
	public ModelAndView showAddAndEdit(String uid) {
		ModelAndView model=new ModelAndView("search/buyadd");
		
		
		return model;
	} 
	
}