/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.lh.blog.search.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.lh.blog.search.mapper.GoodInfoMapper;
import com.lh.blog.search.model.GoodInfo;
import com.lh.blog.search.service.IGoodInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    goodinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2018年04月27日
 */
@Service
public class GoodInfoServiceImpl extends MyBatisServiceSupport implements IGoodInfoService {

	
	@Autowired
	private GoodInfoMapper goodInfoMapper;
	
	
	@Override
	public List<GoodInfo> selectAllUsers(PageRequest request) throws Exception {
PageHelper.startPage(request.getPageNum(),request.getLength());
		
		return goodInfoMapper.selectAllUsers(request.getParams());
	}
}