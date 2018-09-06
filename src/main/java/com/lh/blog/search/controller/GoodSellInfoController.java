/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.lh.blog.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.lh.blog.search.model.GoodBuyInfo;
import com.lh.blog.search.model.GoodSellInfo;
import com.lh.blog.search.service.IGoodBuyInfoService;
import com.lh.blog.search.service.IGoodSellInfoService;

/**
 * 描述:    goodsellinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2018年04月27日
 */
@Controller
@RequestMapping("/sell/")
public class GoodSellInfoController extends BaseController {
	
	
	@Autowired
	private IGoodSellInfoService goodSellInfoService;
	
	
	
	@RequestMapping("list")
	public String sysUserList() {
		return "search/sell";
	}
	
	
	@RequestMapping("showUsers")
	@ResponseBody
	public PageResponse<GoodSellInfo> showUsers(PageRequest request) throws Exception{
		List<GoodSellInfo> data=goodSellInfoService.selectAllUsers(request);
		return new PageResponse<GoodSellInfo>(data);
	}
}