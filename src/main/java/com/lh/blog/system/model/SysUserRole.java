package com.lh.blog.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    sys_user_role 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月17日
 */
@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {
    
    /*@Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;*/

	
	/**
     * 主键
     */
	@Id
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 用户ID
     */
    @Column(name = "ur_user_id")
    private String ur_user_id;

    /**
     * 角色ID
     */
    @Column(name = "ur_role_id")
    private String ur_role_id;

    private static final long serialVersionUID = 1L;


    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取用户ID
     *
     * @return ur_user_id - 用户ID
     */
    public String getUr_user_id() {
        return ur_user_id;
    }

    /**
     * 设置用户ID
     *
     * @param ur_user_id 用户ID
     */
    public void setUr_user_id(String ur_user_id) {
        this.ur_user_id = ur_user_id;
    }

    /**
     * 获取角色ID
     *
     * @return ur_role_id - 角色ID
     */
    public String getUr_role_id() {
        return ur_role_id;
    }

    /**
     * 设置角色ID
     *
     * @param ur_role_id 角色ID
     */
    public void setUr_role_id(String ur_role_id) {
        this.ur_role_id = ur_role_id;
    }
}