package com.lh.blog.search.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.lh.blog.search.mapper.LhBookMapper;
import com.lh.blog.search.model.LhBook;
import com.lh.blog.search.service.ILhBookService;
import com.lh.blog.util.pagination.PageRequest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    lh_book 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2018年01月19日
 */
@Service
public class LhBookServiceImpl extends MyBatisServiceSupport implements ILhBookService {

	
	@Autowired
	private LhBookMapper lhBookMapper;
	
	/**
	 * 分页查询列表
	 */
	@Override
	public List<LhBook> getPageList(PageRequest request) throws Exception {
		//MyBatis分页插件  适用于datatable和pagination 第一个参数：分页页码（从1开始）
		PageHelper.startPage(request.getPageNum(),request.getPageSize());
		return lhBookMapper.getPageList(request.getParams());
	}

	/**
	 * 获取查询结果总数
	 */
	@Override
	public int getListTotal(Map<String, Object> qryMap) {
		return lhBookMapper.getListTotal(qryMap);
	}

	@Override
	public LhBook getOneByUid(String uid) {
		return lhBookMapper.selectByPrimaryKey(uid);
	}

	
}