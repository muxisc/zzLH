package com.lh.blog.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    sys_permision 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月17日
 */
@Table(name = "sys_permision")
public class SysPermision implements Serializable {
    
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
     * 资源名称
     */
    @Column(name = "permision_name")
    private String permision_name;

    /**
     * 父资源ID
     */
    @Column(name = "permision_parent_id")
    private String permision_parent_id;

    /**
     * 资源类型
     */
    @Column(name = "permision_type")
    private String permision_type;

    /**
     * 排序
     */
    @Column(name = "permision_sort")
    private Integer permision_sort;

    /**
     * 资源地址
     */
    @Column(name = "permision_url")
    private String permision_url;

    /**
     * 关联资源
     */
    @Column(name = "permision_related_url")
    private String permision_related_url;

    /**
     * 资源描述
     */
    @Column(name = "permision_desc")
    private String permision_desc;

    /**
     * 权限状态
     */
    @Column(name = "permision_state")
    private String permision_state;

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
     * 获取资源名称
     *
     * @return permision_name - 资源名称
     */
    public String getPermision_name() {
        return permision_name;
    }

    /**
     * 设置资源名称
     *
     * @param permision_name 资源名称
     */
    public void setPermision_name(String permision_name) {
        this.permision_name = permision_name;
    }

    /**
     * 获取父资源ID
     *
     * @return permision_parent_id - 父资源ID
     */
    public String getPermision_parent_id() {
        return permision_parent_id;
    }

    /**
     * 设置父资源ID
     *
     * @param permision_parent_id 父资源ID
     */
    public void setPermision_parent_id(String permision_parent_id) {
        this.permision_parent_id = permision_parent_id;
    }

    /**
     * 获取资源类型
     *
     * @return permision_type - 资源类型
     */
    public String getPermision_type() {
        return permision_type;
    }

    /**
     * 设置资源类型
     *
     * @param permision_type 资源类型
     */
    public void setPermision_type(String permision_type) {
        this.permision_type = permision_type;
    }

    /**
     * 获取排序
     *
     * @return permision_sort - 排序
     */
    public Integer getPermision_sort() {
        return permision_sort;
    }

    /**
     * 设置排序
     *
     * @param permision_sort 排序
     */
    public void setPermision_sort(Integer permision_sort) {
        this.permision_sort = permision_sort;
    }

    /**
     * 获取资源地址
     *
     * @return permision_url - 资源地址
     */
    public String getPermision_url() {
        return permision_url;
    }

    /**
     * 设置资源地址
     *
     * @param permision_url 资源地址
     */
    public void setPermision_url(String permision_url) {
        this.permision_url = permision_url;
    }

    /**
     * 获取关联资源
     *
     * @return permision_related_url - 关联资源
     */
    public String getPermision_related_url() {
        return permision_related_url;
    }

    /**
     * 设置关联资源
     *
     * @param permision_related_url 关联资源
     */
    public void setPermision_related_url(String permision_related_url) {
        this.permision_related_url = permision_related_url;
    }

    /**
     * 获取资源描述
     *
     * @return permision_desc - 资源描述
     */
    public String getPermision_desc() {
        return permision_desc;
    }

    /**
     * 设置资源描述
     *
     * @param permision_desc 资源描述
     */
    public void setPermision_desc(String permision_desc) {
        this.permision_desc = permision_desc;
    }

    /**
     * 获取权限状态
     *
     * @return permision_state - 权限状态
     */
    public String getPermision_state() {
        return permision_state;
    }

    /**
     * 设置权限状态
     *
     * @param permision_state 权限状态
     */
    public void setPermision_state(String permision_state) {
        this.permision_state = permision_state;
    }
}