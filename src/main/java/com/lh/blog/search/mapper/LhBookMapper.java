package com.lh.blog.search.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.lh.blog.search.model.LhBook;

/**
 * 描述:    lh_book 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2018年01月19日
 */
public interface LhBookMapper extends Mapper<LhBook> {
	/**
	 * 分页查询列表
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<LhBook> getPageList(Map<String,Object> qryMap)throws Exception;
	
	/**
	 * 获取查询结果总数
	 * @param qryMap
	 * @return
	 */
	public int getListTotal(Map<String,Object> qryMap);
}