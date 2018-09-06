package com.lh.blog.system.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.lh.blog.system.dto.SysUserDto;
import com.lh.blog.system.model.SysUser;
import com.lh.blog.system.model.SysUserRole;

/**
 * 描述:    sys_user 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public interface ISysUserService extends BaseService {
	
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public SysUserDto selectByUsername(String username) throws Exception;
	
	/**
	 * 查询所有用户
	 * @return
	 * @throws Exception
	 */
	public List<SysUserDto>  selectAllUsers(PageRequest request) throws Exception;
	
	/**
	 * 通过用户名更新用户
	 * @param sysUser
	 * @return
	 */
	public int updateByUsername(SysUser sysUser);
	
	/**
	 * 新增用户
	 * @param sysUser
	 * @param roles
	 * @return
	 */
	public int insertUser(SysUser sysUser,String[] roles) throws Exception;
	
	/**
	 * 通过uid加载指定用户信息
	 * @param uid
	 * @return
	 */
	public SysUser selectByUid(String uid);
	
	/**
	 * 修改用户并添加用户角色关系
	 * @return
	 */
	public int updateUser(SysUser sysUser,String[] roleIds) throws Exception;
	
	/**
	 * 删除单个用户
	 * @param uid
	 * @return
	 */
	public int deleteUser(String uid);
	
}