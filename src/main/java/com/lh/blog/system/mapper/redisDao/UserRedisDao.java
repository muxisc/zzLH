package com.lh.blog.system.mapper.redisDao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.lh.blog.system.model.SysUser;

/**
 * Redis操作类
 * 使用RedisTemplate操作Redis数据库
 * redis支持5种类型   String  Set  ZSet  List  Hash：Map<Object,Object>
 * @author admin
 *
 */
@Repository
public class UserRedisDao {
	
	//key的值
	private static final String KEY_CACHE_USER_LIST="user_list";
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;

	
	//1.redis的hash类型：基本增删改查操作opsForHash()
	/**
	 * 保存用户到redis
	 * @param sysUser
	 */
    public void save(SysUser sysUser) {
    	//hash类型   第一个参数：redis的key值，第二和三参数：Map<Object,Object>
        this.redisTemplate.opsForHash().put(KEY_CACHE_USER_LIST, sysUser.getUid(), sysUser);
    }
    
    /**
     * 通过主键查询redis中用户
     * @param id
     * @return
     */
    public SysUser find(String id) {
        return (SysUser) this.redisTemplate.opsForHash().get(KEY_CACHE_USER_LIST, id);
    }

    /**
     * 查询redis中所有用户
     * @return
     */
    public Map<Object, Object> findAll() {
        return this.redisTemplate.opsForHash().entries(KEY_CACHE_USER_LIST);
    }
    
    /**
     * 删除redis中指定用户
     * @param id
     */
    public void delete(String id) {
        this.redisTemplate.opsForHash().delete(KEY_CACHE_USER_LIST, id);
    }

}
