package com.lh.blog.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.security.shiro.UserProfile;


@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController {
	
	
	
	/**
	 * 登陆成功，进入后台管理中心
	 * @param session
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session) {
		ModelAndView model=new ModelAndView("system/index");
		UserProfile userProfile=(UserProfile)session.getAttribute("sysUserKey");
		if(userProfile!=null) {
			//用户显示菜单
			model.addObject("userProfile", userProfile);
			model.addObject("menus", userProfile.getMenus());
		}
		
		return model;
	}
	
	
	/**
	 * 后台管理中心首页
	 * @return
	 */
	@RequestMapping("/homePage")
	public String homePage() {
		return "system/homePage";
	}

}
