package com.lh.blog.system.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    sys_depart 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月01日
 */
@Table(name = "sys_depart")
public class SysDepart implements Serializable {
    @Id
    @Column(name = "id")
  //@Before
  //@GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 部门编码
     */
    @Column(name = "orgCoding")
    private String orgCoding;

    /**
     * 部门名称
     */
    @Column(name = "orgName")
    private String orgName;

    /**
     * 上级部门编码
     */
    @Column(name = "pOrgCoding")
    private String pOrgCoding;

    /**
     * 1:是父节点
     */
    @Column(name = "parentFlag")
    private String parentFlag;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门编码
     *
     * @return orgCoding - 部门编码
     */
    public String getOrgCoding() {
        return orgCoding;
    }

    /**
     * 设置部门编码
     *
     * @param orgCoding 部门编码
     */
    public void setOrgCoding(String orgCoding) {
        this.orgCoding = orgCoding;
    }

    /**
     * 获取部门名称
     *
     * @return orgName - 部门名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置部门名称
     *
     * @param orgName 部门名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取上级部门编码
     *
     * @return pOrgCoding - 上级部门编码
     */
    public String getpOrgCoding() {
        return pOrgCoding;
    }

    /**
     * 设置上级部门编码
     *
     * @param pOrgCoding 上级部门编码
     */
    public void setpOrgCoding(String pOrgCoding) {
        this.pOrgCoding = pOrgCoding;
    }

    /**
     * 获取1:是父节点
     *
     * @return parentFlag - 1:是父节点
     */
    public String getParentFlag() {
        return parentFlag;
    }

    /**
     * 设置1:是父节点
     *
     * @param parentFlag 1:是父节点
     */
    public void setParentFlag(String parentFlag) {
        this.parentFlag = parentFlag;
    }
}