/**
 * @author framework generator
 * @date 2017年10月17日
 * @version 2.0
 */
package com.lh.blog.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.lh.blog.system.model.SysRole;

/**
 * 描述:    sys_role 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public interface SysRoleMapper extends Mapper<SysRole> {
	
	/**
	 * 获取所有角色
	 * @return
	 */
	public List<SysRole> getAllRoles();
	
	/**
	 * 根据uid查询角色
	 * @param qryMap
	 * @return
	 */
	public List<SysRole> getRoleByUid(Map<String,Object> qryMap);
	
	/**
	 * 根据角色名获取角色
	 * @param qryMap
	 * @return
	 */
	public List<SysRole> getRoleByName(Map<String,Object> qryMap);
	
}