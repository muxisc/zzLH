package com.lh.blog.system.dto;

import com.lh.blog.system.model.SysRole;

/**
 * 描述:    sys_role 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public class SysRoleDto extends SysRole {
	
	private static final long serialVersionUID = 1L;
	
	//角色的权限列表
	public String[] permisions;

	public String[] getPermisions() {
		return permisions;
	}

	public void setPermisions(String[] permisions) {
		this.permisions = permisions;
	}
	
	
	
}