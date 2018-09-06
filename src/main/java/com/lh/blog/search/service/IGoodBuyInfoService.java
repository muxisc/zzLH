/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.lh.blog.search.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.lh.blog.search.model.GoodBuyInfo;

/**
 * 描述:    goodbuyinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2018年04月27日
 */
public interface IGoodBuyInfoService extends BaseService {
	public List<GoodBuyInfo>  selectAllUsers(PageRequest request) throws Exception;
}