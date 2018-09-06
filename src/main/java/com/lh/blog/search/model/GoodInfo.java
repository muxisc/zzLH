/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.lh.blog.search.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * 描述:    goodinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年04月27日
 */
@Table(name = "goodinfo")
public class GoodInfo implements Serializable {
    @Id
    @Column(name = "goodId")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer goodId;

    @Column(name = "goodClassId")
    private String goodClassId;

    @Column(name = "goodName")
    private String goodName;

    @Column(name = "goodPrice")
    private BigDecimal goodPrice;

    @Column(name = "goodPlace")
    private String goodPlace;

    private static final long serialVersionUID = 1L;

    /**
     * @return goodId
     */
    public Integer getGoodId() {
        return goodId;
    }

    /**
     * @param goodId
     */
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    /**
     * @return goodClassId
     */
    public String getGoodClassId() {
        return goodClassId;
    }

    /**
     * @param goodClassId
     */
    public void setGoodClassId(String goodClassId) {
        this.goodClassId = goodClassId;
    }

    /**
     * @return goodName
     */
    public String getGoodName() {
        return goodName;
    }

    /**
     * @param goodName
     */
    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    /**
     * @return goodPrice
     */
    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    /**
     * @param goodPrice
     */
    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    /**
     * @return goodPlace
     */
    public String getGoodPlace() {
        return goodPlace;
    }

    /**
     * @param goodPlace
     */
    public void setGoodPlace(String goodPlace) {
        this.goodPlace = goodPlace;
    }
}