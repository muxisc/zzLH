package com.lh.blog.system.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.lh.blog.system.model.SysRolePermision;

/**
 * 描述:    sys_role_permision 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public interface ISysRolePermisionService extends BaseService {
	
	/**
	 * 获取该角色的所有权限id
	 * @return
	 */
	public List<SysRolePermision> getByRoleId(String roleId);
	
	/**
	 * 新增角色-权限关系
	 * @param sysRolePers
	 * @return
	 * @throws Exception
	 */
	public int insertRolePermisions(List<SysRolePermision> sysRolePers)throws Exception;

	/**
	 * 删除角色权限
	 * @return
	 * @throws Exception
	 */
    public int deleteByRoleId(String roleId)throws Exception;
}