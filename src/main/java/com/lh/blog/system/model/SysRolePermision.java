package com.lh.blog.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    sys_role_permision 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月17日
 */
@Table(name = "sys_role_permision")
public class SysRolePermision implements Serializable {
    /**
     * 主键
     */
    /*@Id*/
    @Column(name = "id")
    /*@Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")*/
    private Integer id;

    
    @Id
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 角色ID
     */
    @Column(name = "rp_role_id")
    private String rp_role_id;

    /**
     * 权限ID
     */
    @Column(name = "rp_permision_id")
    private String rp_permision_id;

    
    @Column(name = "rp_resource_id")
    private String rp_resource_id;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * 获取角色ID
     *
     * @return rp_role_id - 角色ID
     */
    public String getRp_role_id() {
        return rp_role_id;
    }

    /**
     * 设置角色ID
     *
     * @param rp_role_id 角色ID
     */
    public void setRp_role_id(String rp_role_id) {
        this.rp_role_id = rp_role_id;
    }

	public String getRp_permision_id() {
		return rp_permision_id;
	}

	public void setRp_permision_id(String rp_permision_id) {
		this.rp_permision_id = rp_permision_id;
	}

	public String getRp_resource_id() {
		return rp_resource_id;
	}

	public void setRp_resource_id(String rp_resource_id) {
		this.rp_resource_id = rp_resource_id;
	}

    /**
     * @return rp_permision_id
     */
    
    
}