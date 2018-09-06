package com.lh.blog.system.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


/**
 * 后台用户登录Dto对象
 * @author hzhb
 *
 */
public class LoginDto implements Serializable {
	
	/**
	 * 登录用户名
	 */
	@NotBlank               //必须加上@Valid,这些注解才起作用
	@Size(min=2,max=8,message="登录用户名必须在2~8之间")
	private String username;
	/**
	 * 登录密码
	 */
	@NotBlank
	@Size(min=5,max=10,message="登录密码必须在5~10之间")
	private String password;
	
	/**
	 * 登录验证码
	 */
	//private String checkCode;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}*/



}
