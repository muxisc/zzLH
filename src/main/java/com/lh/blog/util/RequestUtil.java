package com.lh.blog.util;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lh.blog.util.pagination.PageRequest;


/**
 * Request 工具类
 * @author icinfo
 */
public class RequestUtil {
	
	
	/**
	 * 获取 request 中所有参数
	 * @param request
	 * @return
	 */
	public static PageRequest getMyPageParam(Map<String,Object> qryMap) {
		//自定义分页的请求对象
		PageRequest pageRequest = new PageRequest();
		int pageSize = Integer.parseInt(qryMap.get("length").toString());
		int skipResult = Integer.parseInt(qryMap.get("start").toString());
		qryMap.put("pageSize", pageSize);
		qryMap.put("skipResult", skipResult);
		pageRequest.setParams(qryMap);
		pageRequest.setDraw(Integer.parseInt(qryMap.get("draw").toString()));
		pageRequest.setPageSize(pageSize);
		pageRequest.setSkipResult(skipResult);
		return pageRequest;
	}
	
	/**
	 * 获取http request对象
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

}
