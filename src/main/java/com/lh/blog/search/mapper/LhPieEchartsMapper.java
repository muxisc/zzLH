/**
 * @author framework generator
 * @date 2018年03月01日
 * @version 2.0
 */
package com.lh.blog.search.mapper;

import java.util.List;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.lh.blog.search.model.LhPieEcharts;

/**
 * 描述:    lh_pie_echarts 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2018年03月01日
 */
public interface LhPieEchartsMapper extends Mapper<LhPieEcharts> {
	/**
	 * 获取pieEcharts的数据
	 * @return
	 */
	public List<LhPieEcharts> getPieEcharts();
}