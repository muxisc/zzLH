package com.lh.blog.search.service;


import java.util.List;
import java.util.Map;

import com.icinfo.framework.core.service.BaseService;
import com.lh.blog.search.model.LhBook;
import com.lh.blog.util.pagination.PageRequest;

/**
 * 描述:    lh_book 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2018年01月19日
 */
public interface ILhBookService extends BaseService {
	/**
	 * 分页查询列表
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<LhBook> getPageList(PageRequest request)throws Exception;
	
	/**
	 * 获取查询结果总数
	 * @param qryMap
	 * @return
	 */
	public int getListTotal(Map<String,Object> qryMap);
	
	/**
	 * 通过uid获取书籍
	 * @param uid
	 * @return
	 */
	public LhBook getOneByUid(String uid);
}