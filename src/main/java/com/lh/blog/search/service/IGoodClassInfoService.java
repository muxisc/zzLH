/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.lh.blog.search.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.lh.blog.search.model.GoodClassInfo;
import com.lh.blog.system.model.SysPermision;

/**
 * 描述:    goodClassInfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2018年04月27日
 */
public interface IGoodClassInfoService extends BaseService {
	
	
	public List<GoodClassInfo> selectAllPermisions();
	
	
	public GoodClassInfo selectByUid(String uid);
	
}