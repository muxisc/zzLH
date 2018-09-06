package com.lh.blog.system.service;


import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.lh.blog.system.model.SysUserRole;

/**
 * 描述:    sys_user_role 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public interface ISysUserRoleService extends BaseService {
	
	/**
	 * 添加用户-角色关系
	 * @return
	 */
	public int insertUserRole(List<SysUserRole> userRoles);
	
	/**
	 * 通过用户Id获取其角色id
	 * @param userId
	 * @return
	 */
	public List<SysUserRole> selectByUserId(String userId);
	
	/**
	 * 通过用户Id删除其角色
	 * @param userId
	 * @return
	 */
	public int deleteUserRole(String userId);
}