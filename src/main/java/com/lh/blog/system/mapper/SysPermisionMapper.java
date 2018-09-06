/**
 * @author framework generator
 * @date 2017年10月17日
 * @version 2.0
 */
package com.lh.blog.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.lh.blog.system.model.SysPermision;

/**
 * 描述:    sys_permision 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public interface SysPermisionMapper extends Mapper<SysPermision> {
	/**
	 * 查询当前用户的权限列表
	 */
	public List<SysPermision> selectUserPermisons(Map<String,Object> map);
	
	/**
	 * 查询所有权限资源
	 * @return
	 */
	public List<SysPermision> selectAllPermisions();
	
	
}