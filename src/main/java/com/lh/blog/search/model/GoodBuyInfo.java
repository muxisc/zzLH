/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.lh.blog.search.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    goodbuyinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年04月27日
 */
@Table(name = "goodbuyinfo")
public class GoodBuyInfo implements Serializable {
    @Id
    @Column(name = "buyId")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer buyId;

    @Column(name = "goodId")
    private Integer goodId;

    @Column(name = "goodName")
    private String goodName;

    @Column(name = "goodPrice")
    private BigDecimal goodPrice;

    @Column(name = "buyAmount")
    private Integer buyAmount;

    @Column(name = "buyTotalPrice")
    private BigDecimal buyTotalPrice;

    @Column(name = "buyDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date buyDate;

    @Column(name = "supplierName")
    private String supplierName;

    private static final long serialVersionUID = 1L;

    /**
     * @return buyId
     */
    public Integer getBuyId() {
        return buyId;
    }

    /**
     * @param buyId
     */
    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

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
     * @return buyAmount
     */
    public Integer getBuyAmount() {
        return buyAmount;
    }

    /**
     * @param buyAmount
     */
    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
    }

    /**
     * @return buyTotalPrice
     */
    public BigDecimal getBuyTotalPrice() {
        return buyTotalPrice;
    }

    /**
     * @param buyTotalPrice
     */
    public void setBuyTotalPrice(BigDecimal buyTotalPrice) {
        this.buyTotalPrice = buyTotalPrice;
    }

    /**
     * @return buyDate
     */
    public Date getBuyDate() {
        return buyDate;
    }

    /**
     * @param buyDate
     */
    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    /**
     * @return supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}