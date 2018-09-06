package com.lh.blog.system.service.impl;


import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import com.lh.blog.system.dto.SysUserDto;
import com.lh.blog.system.mapper.SysUserMapper;
import com.lh.blog.system.model.SysUser;
import com.lh.blog.system.model.SysUserRole;
import com.lh.blog.system.service.ISysUserRoleService;
import com.lh.blog.system.service.ISysUserService;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    sys_user 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
@Service
public class SysUserServiceImpl extends MyBatisServiceSupport implements ISysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private ISysUserRoleService sysUserRoleService;
	
	
	/**
	 * 验证用户名是否存在
	 * @throws Exception 
	 */
	private Boolean exists(String username) throws Exception {
		return selectByUsername(username)!=null;
	}


	/**
	 * 参数转换
	 */
	private List<SysUserRole> parseConvert(String userId, String[] roleIds) {
		List<SysUserRole> userRoleList=new ArrayList<SysUserRole>();
		for(String roleId:roleIds) {
			SysUserRole sysUserRole=new SysUserRole();
			sysUserRole.setUr_user_id(userId);
			sysUserRole.setUr_role_id(roleId);
			userRoleList.add(sysUserRole);
		}
		return userRoleList;
	}
	
	
	/**
	 * 加载指定用户名的用户信息
	 */
	@Override
	public SysUserDto selectByUsername(String username) throws Exception{
//import static org.apache.commons.lang3.StringUtils.isEmpty;
//Window->Preferences->Java->Editor->Content Assist->Favorites
		if(isEmpty(username)) {
			return null;
		}
		Map<String,Object> map=new HashMap<String,Object>(); 
		map.put("username", username);
		List<SysUserDto> list=sysUserMapper.selectByUsername(map);
		if(list.size()>0 && isNotBlank(list.get(0).getUid())) {
			return list.get(0);
		}
		
		return null;
	}

	
	/**
	 * 查询所有用户
	 */
	@Override
	public List<SysUserDto> selectAllUsers(PageRequest request) throws Exception {
		//pageNum 分页页码  length 每页显示的记录数 params 业务查询参数
		PageHelper.startPage(request.getPageNum(),request.getLength());
		
		return sysUserMapper.selectAllUsers(request.getParams());
	}

	
	/**
	 * 通过用户名更新用户
	 */
	@Override
	public int updateByUsername(SysUser sysUser) {
		String username=sysUser.getUser_username();
		if(isBlank(username)) {
			return 0;
		}
		Example example=new Example(SysUser.class);
		example.createCriteria().andEqualTo("user_username", username);
		//根据Example条件更新实体`record` 包含的不是null的  属性值

		return sysUserMapper.updateByExampleSelective(sysUser, example);
	}


	/**
	 * 新增用户并添加用户-角色关系
	 */
	@Override
	public int insertUser(SysUser sysUser, String[] roles) throws Exception{
		if(exists(sysUser.getUser_username())) {
			throw new BusinessException("用户名："+sysUser.getUser_username()+"已经存在了");
		}
		
		if(isNotBlank(sysUser.getUser_password())) {
			//随机生成一个密码盐值
			String passwordSalt=new SecureRandomNumberGenerator().nextBytes().toHex();
			sysUser.setUser_password_salt(passwordSalt);
			SimpleHash hash=new SimpleHash("md5", sysUser.getUser_password(), passwordSalt, 2);
			sysUser.setUser_password(hash.toHex());
		}
		sysUser.setUser_create_time(DateUtils.getSysDate());
		sysUser.setUser_dept("20000");
		//新增用户
		if(sysUserMapper.insert(sysUser)<=0) {
			throw new BusinessException("创建系统用户失败");
		}
		
		if(roles!=null && roles.length>0) {
			//添加用户-角色关系
			sysUserRoleService.insertUserRole(parseConvert(sysUser.getUid(), roles));
		}
		
		return 1;
	}


	/**
	 * 通过uid加载指定用户信息
	 */
	@Override
	public SysUser selectByUid(String uid) {
		if(isEmpty(uid)) {
			return null;
		}
		Map<String,Object> qryMap=new HashMap<String,Object>();
		qryMap.put("uid", uid);
		
		List<SysUserDto> userList=sysUserMapper.selectAllUsers(qryMap);
		if(userList.size()>0&&isNotBlank(userList.get(0).getUid())) {
			return userList.get(0);
		}
		return null;
	}


	/**
	 * 修改用户并修改用户-角色关系
	 */
	@Override
	public int updateUser(SysUser sysUser, String[] roleIds) throws Exception {
		if(sysUser==null || isBlank(sysUser.getUid())) {
			return 0;
		}
		//删除该用户-角色关系
		sysUserRoleService.deleteUserRole(sysUser.getUid());
		//添加新用户-角色关系
		if(roleIds!=null && roleIds.length>0) {
			sysUserRoleService.insertUserRole(parseConvert(sysUser.getUid(), roleIds));
		}
		String password=sysUser.getUser_password();
		if(isNotBlank(password)) {   //需要修改密码
			String passwordSalt=new SecureRandomNumberGenerator().nextBytes().toHex();
			sysUser.setUser_password_salt(passwordSalt);
			SimpleHash hash=new SimpleHash("md5", password, passwordSalt, 2);
			sysUser.setUser_password(hash.toHex());
		}else {
			sysUser.setUser_password(null);//不需要修改密码     属性为null则不被更新
		}
		sysUser.setUser_username(null);
		//根据主键更新 属性不为null的值
		return sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}


	/**
	 * 通过主键删除单个用户
	 */
	@Override
	public int deleteUser(String uid) {
		return sysUserMapper.deleteByPrimaryKey(uid);
	}


}