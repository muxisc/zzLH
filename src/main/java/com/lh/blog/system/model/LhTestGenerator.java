package com.lh.blog.system.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    lh_test_generator 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月16日
 */
@Table(name = "lh_test_generator")
public class LhTestGenerator implements Serializable {
    //@Id
    @Column(name = "id")
    //@Before
    //@GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "testname")
    private String testname;

    @Column(name = "testtime")
    private Date testtime;

    @Column(name = "testmintime")
    private Date testmintime;

    @Column(name = "testmoney")
    /*private Long testmoney;*/
    private BigDecimal testmoney;

    /**
     * 0 未读  1 已读
     */
    @Column(name = "isTest")
    private String isTest;

    @Column(name = "creattime")
    private Date creattime;

    @Column(name = "updatetime")
    private Date updatetime;

    @Column(name = "testcontent")
    private String testcontent;

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
     * @return testname
     */
    public String getTestname() {
        return testname;
    }

    /**
     * @param testname
     */
    public void setTestname(String testname) {
        this.testname = testname;
    }

    /**
     * @return testtime
     */
    public Date getTesttime() {
        return testtime;
    }

    /**
     * @param testtime
     */
    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }

    /**
     * @return testmintime
     */
    public Date getTestmintime() {
        return testmintime;
    }

    /**
     * @param testmintime
     */
    public void setTestmintime(Date testmintime) {
        this.testmintime = testmintime;
    }

    /**
     * @return testmoney
     */
    public BigDecimal getTestmoney() {
        return testmoney;
    }

    /**
     * @param testmoney
     */
    public void setTestmoney(BigDecimal testmoney) {
        this.testmoney = testmoney;
    }

    /**
     * 获取0 未读  1 已读
     *
     * @return isTest - 0 未读  1 已读
     */
    public String getIsTest() {
        return isTest;
    }

    /**
     * 设置0 未读  1 已读
     *
     * @param isTest 0 未读  1 已读
     */
    public void setIsTest(String isTest) {
        this.isTest = isTest;
    }

    /**
     * @return creattime
     */
    public Date getCreattime() {
        return creattime;
    }

    /**
     * @param creattime
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    /**
     * @return updatetime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return testcontent
     */
    public String getTestcontent() {
        return testcontent;
    }

    /**
     * @param testcontent
     */
    public void setTestcontent(String testcontent) {
        this.testcontent = testcontent;
    }
}