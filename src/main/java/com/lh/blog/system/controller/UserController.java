package com.lh.blog.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lh.blog.system.model.User;
import com.lh.blog.system.service.impl.UserServiceImpl;


@Controller
public class UserController{
	
	@Resource  
    private UserServiceImpl userServiceImpl;  
	
	
    @RequestMapping("test.do")  
    public ModelAndView  testCon(HttpServletRequest request,Model model){  
        System.out.println("hello");  
        System.out.println(request.getParameter("id"));  
        User u=userServiceImpl.getUserById(new Integer(request.getParameter("id")));  
        System.out.println(u.getUserName());  
        ModelAndView mod=new ModelAndView();  
        mod.setViewName("success");  
        return mod;  
    }  
    /** 
     * @deprecated 
     * 根据前台封装的javaBean属性进行封装  这里是进行User对象的封装 
     * 测试后台是否能正常能拿到数据        
     * @param user 获取前台穿过来的对象 
     * @param request 
     * @return 
     */  
    @RequestMapping("submit.do")  
    public String testBean(User user,HttpServletRequest request){  
        System.out.println("========+"+user.getUserName()+"..."+user.getPassword());  
        return "success";  
          
    }  
    public UserServiceImpl getUserService() {  
        return userServiceImpl;  
    }  
    public void setUserService(UserServiceImpl userServiceImpl) {  
        this.userServiceImpl = userServiceImpl;  
    }  

    
    
}
