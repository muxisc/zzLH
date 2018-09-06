package com.lh.blog.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    sys_role 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月17日
 */
@Table(name = "sys_role")
public class SysRole implements Serializable {
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
     * 角色名称
     */
    @Column(name = "role_name")
    private String role_name;

    /**
     * 角色描述
     */
    @Column(name = "role_desc")
    private String role_desc;

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
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * 设置角色名称
     *
     * @param role_name 角色名称
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    /**
     * 获取角色描述
     *
     * @return role_desc - 角色描述
     */
    public String getRole_desc() {
        return role_desc;
    }

    /**
     * 设置角色描述
     *
     * @param role_desc 角色描述
     */
    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }
}