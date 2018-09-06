package com.lh.blog.system.service;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.lh.blog.system.dto.SysRoleDto;
import com.lh.blog.system.model.SysRole;

/**
 * 描述:    sys_role 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public interface ISysRoleService extends BaseService {
	
	/**
	 * 获取所有角色
	 * @return
	 */
	public List<SysRole> getAllRoles();
	
	/**
	 * 获取分页角色
	 * @param request
	 * @return
	 */
	public List<SysRole> getPageRoles(PageRequest request);
	
	/**
	 * 保存角色
	 * @param sysRole
	 * @return
	 * @throws Exception
	 */
	public int insertRole(SysRoleDto sysRole)throws Exception;
	
	/**
	 * 根据uid查询角色
	 * @param uid
	 * @return
	 */
	public SysRole getRoleByUid(String uid);
	
	/**
	 * 通过uid编辑角色
	 * @param uid
	 * @return
	 */
	public int updateByUid(SysRoleDto sysRole,String[] permisions)throws Exception;
	
	/**
	 * 删除角色
	 * @param uid
	 * @return
	 */
	public int deleteByUid(String uid);
	
	/**
	 * 通过角色名查询角色
	 * @param qryMap
	 * @return
	 */
	public List<SysRole> getRoleByName(Map<String,Object> qryMap);
	
	/**
	 * 新增角色和新增角色权限关系
	 * @param sysRole
	 * @param permisions
	 * @return
	 * @throws Exception
	 */
	public int insertRolePer(SysRoleDto sysRole,String[] permisions)throws Exception;
}