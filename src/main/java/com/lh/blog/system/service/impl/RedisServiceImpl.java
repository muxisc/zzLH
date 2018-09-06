package com.lh.blog.system.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.blog.system.controller.SysUserController;
import com.lh.blog.system.mapper.SysUserMapper;
import com.lh.blog.system.mapper.redisDao.UserRedisDao;
import com.lh.blog.system.model.SysUser;
import com.lh.blog.system.service.IRedisService;
import com.lh.blog.util.UUIDUtils;

@Service
public class RedisServiceImpl implements IRedisService {
	
	private static final Logger logger=LoggerFactory.getLogger(SysUserController.class);
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private UserRedisDao userRedisDao;
	
    /**
     * Redis的应用场景：
     * 1.读取数据
     */
	@Override
	public Map<Object,Object> getAllFirstRedis() {
		//先去缓存中查询所有用户数据
		Map<Object,Object> allMap=userRedisDao.findAll();
		
		if(allMap.size()>0) {
			//如果有该所有用户缓存数据，则把Redis中的数据返回，就不用去访问数据库了。
			return allMap;
		}else {
			//如果缓存中无所有用户数据，则去数据库中获取，然后把数据返回
			List<SysUser> userListDb=sysUserMapper.selectAll();
			//并把这所有用户数据缓存到Redis中
			for(SysUser sysUser:userListDb) {
				userRedisDao.save(sysUser);
			}
			allMap=userRedisDao.findAll();
			return allMap;
		}
	}


	/**
     * Redis的应用场景：
     * 2.更新数据
     * 写操作有两种情况：
     * (1).直接写mysql中，成功后再写入redis中
     * (2).写入redis后直接返回，然后定期写入mysql              
     */
	@Override
	public Map<Object, Object> insertUser() {
		SysUser sysUser=new SysUser();
		sysUser.setUid(UUIDUtils.randomUUID());
		sysUser.setUser_username("测试更新缓存");
		
		//1.先去redis中查询是否存在该key值
		Map<Object,Object> allMap=userRedisDao.findAll();
		if(allMap.size()>0) {
			//2.redis中存在该key值，则更新该key对应的值 (2)
			userRedisDao.save(sysUser);
			//然后把redis中更新后的数据返回    (2)
			allMap=userRedisDao.findAll();
			
			//然后定期更新数据库   (2)
			//定时把redis中更新的数据（可以记录下更新的key）保存到数据库中
			
			return allMap;
		}else {
			//2.redis中不存在该key值，则去更新数据库的数据
			sysUserMapper.insert(sysUser);
			//然后把数据库中更新后的数据缓存到redis
			List<SysUser> allList=sysUserMapper.selectAll();
			for(SysUser one:allList) {
				userRedisDao.save(one);
			}
			allMap=userRedisDao.findAll();
			return allMap;
		}
	}
	
	

	/*@Override
	public String getAllRedisString() {
		//先去缓存中去查询所有用户数据
		Jedis jedis=new Jedis("localhost");
		String userListValue=jedis.get(KEY_CACHE_USER_LIST);
		
		if(!StringUtils.isEmpty(userListValue)) {
		//如果有该所有用户缓存数据，则把Redis中的数据返回，就不用去访问数据库了。
		return userListValue;
	}else {
		//如果缓存中无所有用户数据，则去数据库中获取
		List<SysUser> userListDb=sysUserMapper.selectAll();
		//然后把这所有用户数据缓存到Redis中
		String userListRedis=JSON.toJSONString(userListDb);
		jedis.set(KEY_CACHE_USER_LIST, userListRedis);
		//jedis.expire(KEY_CACHE_USER_LIST, 60);   //设置其1分钟的过期时间
		return userListRedis;
	}
	*/
	
	

	
}
