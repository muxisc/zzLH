/**
 * @author framework generator
 * @date 2017年10月17日
 * @version 2.0
 */
package com.lh.blog.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.lh.blog.system.dto.SysUserDto;
import com.lh.blog.system.model.SysUser;

/**
 * 描述:    sys_user 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public interface SysUserMapper extends Mapper<SysUser> {
	/**
	 * 通过用户名查询用户
	 * @param map
	 * @return
	 */
	public List<SysUserDto> selectByUsername(Map<String,Object> map);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<SysUserDto> selectAllUsers(Map<String,Object> request);
}