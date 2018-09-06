/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.lh.blog.search.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    employeeinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年04月27日
 */
@Table(name = "employeeinfo")
public class EmployeeInfo implements Serializable {
    /**
     * 员工编号id
     */
    @Id
    @Column(name = "employeeId")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer employeeId;

    @Column(name = "employeeName")
    private String employeeName;

    @Column(name = "employeeSex")
    private String employeeSex;

    @Column(name = "employeeCerNo")
    private String employeeCerNo;

    @Column(name = "employeePhone")
    private String employeePhone;

    private static final long serialVersionUID = 1L;

    /**
     * 获取员工编号id
     *
     * @return employeeId - 员工编号id
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工编号id
     *
     * @param employeeId 员工编号id
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return employeeSex
     */
    public String getEmployeeSex() {
        return employeeSex;
    }

    /**
     * @param employeeSex
     */
    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    /**
     * @return employeeCerNo
     */
    public String getEmployeeCerNo() {
        return employeeCerNo;
    }

    /**
     * @param employeeCerNo
     */
    public void setEmployeeCerNo(String employeeCerNo) {
        this.employeeCerNo = employeeCerNo;
    }

    /**
     * @return employeePhone
     */
    public String getEmployeePhone() {
        return employeePhone;
    }

    /**
     * @param employeePhone
     */
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
}