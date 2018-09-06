package com.lh.blog.search.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.lh.blog.search.model.LhCourseInfo;

/**
 * 描述:    lh_course_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2018年02月06日
 */
public interface LhCourseInfoMapper extends Mapper<LhCourseInfo> {
	
	/**
	 * 获取课件分页列表
	 * @return
	 * @throws Exception
	 */
	public List<LhCourseInfo> doGetLoadPage(Map<String,Object> qryMap)throws Exception;
}