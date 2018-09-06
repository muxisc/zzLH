package com.lh.blog.system.service;

import java.util.Map;

import com.lh.blog.system.model.SysUser;

public interface IRedisService {
	
	public Map<Object,Object> getAllFirstRedis();
	
	
	public Map<Object,Object> insertUser();
	
}
