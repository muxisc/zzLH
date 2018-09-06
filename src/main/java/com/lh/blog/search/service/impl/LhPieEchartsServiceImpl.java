package com.lh.blog.search.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.lh.blog.search.mapper.LhPieEchartsMapper;
import com.lh.blog.search.model.LhPieEcharts;
import com.lh.blog.search.service.ILhPieEchartsService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    lh_pie_echarts 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2018年03月01日
 */
@Service
public class LhPieEchartsServiceImpl extends MyBatisServiceSupport implements ILhPieEchartsService {

	@Autowired
	private LhPieEchartsMapper lhPieEchartsMapper;
	
	/**
	 * 获取pieEcharts的数据
	 */
	@Override
	public JSONObject getPieData() {
		List<LhPieEcharts> pieDatas=lhPieEchartsMapper.getPieEcharts();
		
		JSONObject jsonObject=new JSONObject();
		JSONArray array1=new JSONArray();   //[{"name":"武侠小说","value":"100"},{"name":"青春校园","value":"300"}]
		
		for(LhPieEcharts lhPieEchart:pieDatas) {
			//{"name":"武侠小说","value":"100"}
			JSONObject object=new JSONObject();
			object.put("name", lhPieEchart.getPieBookType());
			object.put("value", lhPieEchart.getPieTypeAmount());
			
			array1.add(object);
		}
		//{"pieDataMap":[{},{}]}
		jsonObject.put("pieDataMap",array1);
		return jsonObject;
	}
	
	
	
	
	
	
}