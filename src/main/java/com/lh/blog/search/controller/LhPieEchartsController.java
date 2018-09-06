package com.lh.blog.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.lh.blog.search.service.ILhPieEchartsService;


/**
 * 描述:    lh_pie_echarts 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2018年03月01日
 */
@Controller
@RequestMapping("/lh/Echarts/")
public class LhPieEchartsController extends BaseController {
	private static final Logger logger=LoggerFactory.getLogger(LhPieEchartsController.class);
	
	@Autowired
	private ILhPieEchartsService lhPieEchartsService;
	
	/**
	 * 进入Echarts页面
	 * @return
	 */
	@RequestMapping("showEchartsPage")
	public String showEchartsPage() {
		return "echarts/pie_echarts";
	}
	
	
	/**
	 * 获取pieEcharts的数据
	 * @return
	 */
	@RequestMapping("getPieData")
	@ResponseBody
	public AjaxResult getPieData() {
		//JSONObject respObject=new JSONObject();
		JSONObject pieDataObject=lhPieEchartsService.getPieData();
		
		//put()：{pieDataMap:pieDataObject.get("pieDataMap")} 名字:值
		//get(name)  return value：[{},{}] 返回pieDataObject名字为pieDataMap的值
		//respObject.put("pieDataMap", pieDataObject.get("pieDataMap"));
		return AjaxResult.success("获取成功", pieDataObject);
		
		/*
		 * 1.JSONObject   {}   
		 * {name1:value1,name2:value2}
		 * put(name,value)
		 * get(name) 得value
		 * 
		 * 2.JSONArray  []
		 * [{},{}]    ["",""]
		 * add(object)
		 * get(index)
		 */
	}
	
	
	
	
	
	
	
	
	
}