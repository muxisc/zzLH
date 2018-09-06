package com.lh.blog.system.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.icinfo.framework.core.validator.Level;
import com.icinfo.framework.core.validator.Password;
import com.lh.blog.system.model.SysUser;

/**
 * 描述:    sys_user 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public class SysUserDto extends SysUser {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 用户所属部门名称
	 */
	private String userdeptname;
	
	/**
	 * 用户的角色
	 */
	private String[] roles;
	
	
	/**
	 * 登录密码后台验证
	 */
	@Password(level=Level.WEAK,message="密码仅允许数字，字母，下划线组合")  //WEAK:弱(1种组合) 中(2种组合) 强 都可         STRONG:只可强
	@Override
	public String getUser_password() {
        return super.getUser_password();
    }
	
	/**
	 * 邮箱后台验证
	 */
	@Email(message="邮箱格式不对")   //该注解的邮箱正确格式 ：11@11即可
	@Override
	public String getUser_email() {
		return super.getUser_email();
	}
	
	public String getUserdeptname() {
		return userdeptname;
	}

	public void setUserdeptname(String userdeptname) {
		this.userdeptname = userdeptname;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	

	

	
	
	
}