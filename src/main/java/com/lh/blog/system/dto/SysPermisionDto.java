package com.lh.blog.system.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.lh.blog.system.model.SysPermision;

/**
 * 描述:    sys_permision 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年10月17日
 */
public class SysPermisionDto extends SysPermision {
	

	/**
	 * 后台参数验证
	 */
	
	@NotBlank
	@Override
	public String getPermision_name() {
        return super.getPermision_name();
    }

	@NotBlank
	@Override
	public String getPermision_url() {
        return super.getPermision_url();
    }
	
}