package com.lh.blog.system.controller;


import java.util.Map;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.core.web.BaseController;
import com.lh.blog.system.model.SysUser;
import com.lh.blog.system.service.IRedisService;



@Controller
@RequestMapping("/admin/system/redis/")
public class RedisController extends BaseController {

	private static final Logger logger=LoggerFactory.getLogger(SysUserController.class);
	
	@Autowired
	private IRedisService redisService;
	
	
	@RequestMapping("list")
	public String sysUserList() {
		return "system/redis/redis_list";
	} 

	
	@RequestMapping("getAllFirstRedis")
	@ResponseBody
	
	public /*String*/Map<Object,Object> getAllFirstRedis(){
		return redisService.getAllFirstRedis();
	}
	
	
	/*@RequestMapping("getAllByDb")
	@ResponseBody
	public List<SysUser> getAllByDb(){
		//直接去数据库中查询
		List<SysUser> dbSj=sysUserService.getAllByDb();
		return dbSj;
	}*/
	
	
	//使用RedisTemplate操作Redis数据库
	/*@RequestMapping("testRedis")
	public void testRedis(){
		//查询Redis中所有用户数据
		Map<Object,Object> sysUserMap=redisService.findAll();
		System.out.println("@@当前Redis存储的所有用户：" + sysUserMap);
		
		SysUser sysUser1=new SysUser();
		sysUser1.setUid("888");
		sysUser1.setUser_identity("110");
		SysUser sysUser2=new SysUser();
		sysUser2.setUid("666");
		sysUser2.setUser_identity("111");
		SysUser sysUser3=new SysUser();
		sysUser3.setUid(UuidUtil.UUID_SEQUENCE);
		sysUser3.setUser_identity("112");
		//存入三个用户
		redisService.save(sysUser1);
		redisService.save(sysUser2);
		redisService.save(sysUser3);
		
		//通过uid查询指定用户
		SysUser sysUser=redisService.find("888");
		System.out.println("查找uid为888的用户 : " + sysUser);
		
		//再去查询redis中所有用户数据
		sysUserMap=redisService.findAll();
		System.out.println("当前Redis存储的所有用户： : " + sysUserMap);
		
		redisService.delete("666");
		sysUserMap=redisService.findAll();
		System.out.println("删除666用户后的当前Redis存储的所有用户： : " + sysUserMap);
		
	}*/
	
	@RequestMapping("insertUser")
	@ResponseBody
	public Map<Object,Object>  insertUser(){
		return redisService.insertUser();
	}
	
	
}
