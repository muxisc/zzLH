package com.lh.blog.system.service.impl;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.lh.blog.system.mapper.UserMapper;
import com.lh.blog.system.model.User;
import com.lh.blog.system.service.IUserService;


/**
 * 测试MVC框架通不通
 * @author hzhb
 *
 */
@Service
public class UserServiceImpl implements IUserService{
	
	@Resource  
    private UserMapper userMapper;  
    @Override  
    public User getUserById(int userId) {  
        return this.userMapper.selectByPrimaryKey(userId);  
    }  
    public static void main(String[] args) {
    	System.out.println("1111111111111111111111111");
       ApplicationContext ca= new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
       System.out.println("2222222222222222");
       UserServiceImpl u=(UserServiceImpl) ca.getBean("userServiceImpl");
       System.out.println("333333333333333333333");
       User ue= u.getUserById(1);
       System.out.println("44444444444444444444");
       System.out.println("555555555555555555555");
       System.out.println("用户名:"+ue.getUserName());  
       System.out.println("用户密码:"+ue.getPassword());  
	}  
	public UserMapper getUserMapper() {  
	    return userMapper;  
	}  
	public void setUserDao(UserMapper userMapper) {  
	    this.userMapper = userMapper;  
	}  
     
}


