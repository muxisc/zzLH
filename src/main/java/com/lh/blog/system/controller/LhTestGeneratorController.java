package com.lh.blog.system.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.lh.blog.system.model.LhTestGenerator;
import com.lh.blog.system.service.ILhTestGeneratorService;

/**
 * 描述:    lh_test_generator 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年10月16日
 */
@Controller
@RequestMapping("/generator/")
public class LhTestGeneratorController extends BaseController {
	
	/**
	 * 日志记录器
	 */
	private static final Logger logger=LoggerFactory.getLogger(LhTestGeneratorController.class);
	
	
	@Autowired
	private ILhTestGeneratorService lhTestGeneratorService;
	
	
	@RequestMapping("insertGen")
	public ModelAndView insertGen(HttpServletRequest request) {
		ModelAndView model=new ModelAndView("hh");
		String testname=request.getParameter("testname");
		String testcontent=request.getParameter("testcontent");
		BigDecimal testmoney=new BigDecimal(request.getParameter("testmoney"));
		LhTestGenerator gen=new LhTestGenerator();
		gen.setTestname(testname);
		gen.setTestcontent(testcontent);
		gen.setTestmoney(testmoney);
		model.addObject("msg", "测试增加成功");
		lhTestGeneratorService.insertGen(gen);
		return model;
	}
	@RequestMapping("en")
	public String en() {
		System.out.println("jjjjjj");
		return null;
	}
	
}