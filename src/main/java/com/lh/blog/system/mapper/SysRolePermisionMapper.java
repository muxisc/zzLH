/**
 * @author framework generator
 * @date 2017年10月17日
 * @version 2.0
 */
package com.lh.blog.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.lh.blog.system.model.SysRolePermision;

/**
 * 描述:    sys_role_permision 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public interface SysRolePermisionMapper extends Mapper<SysRolePermision> {
	
	/**
	 * 获取该角色的所有权限Id
	 * @param qryMap
	 * @return
	 */
	public List<SysRolePermision> getByRoleId(Map<String,Object> qryMap);
	
}