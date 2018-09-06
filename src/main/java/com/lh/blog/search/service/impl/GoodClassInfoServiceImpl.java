/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.lh.blog.search.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.lh.blog.search.mapper.GoodClassInfoMapper;
import com.lh.blog.search.model.GoodClassInfo;
import com.lh.blog.search.service.IGoodClassInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    goodClassInfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2018年04月27日
 */
@Service
public class GoodClassInfoServiceImpl extends MyBatisServiceSupport implements IGoodClassInfoService {

	
	@Autowired
	private GoodClassInfoMapper goodClassInfoMapper;
	
	@Override
	public List<GoodClassInfo> selectAllPermisions() {
		// TODO Auto-generated method stub
		return goodClassInfoMapper.selectAllPermisions();
	}

	@Override
	public GoodClassInfo selectByUid(String uid) {
		// TODO Auto-generated method stub
		return goodClassInfoMapper.selectByPrimaryKey(uid);
	}
}