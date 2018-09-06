package com.lh.blog.search.service;


import com.alibaba.fastjson.JSONObject;
import com.icinfo.framework.core.service.BaseService;


/**
 * 描述:    lh_pie_echarts 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2018年03月01日
 */
public interface ILhPieEchartsService extends BaseService {
	/**
	 * 获取pieEcharts的数据
	 * @return
	 */
	public JSONObject getPieData();
}