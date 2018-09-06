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
 * 描述:    goodsellinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年04月27日
 */
@Table(name = "goodsellinfo")
public class GoodSellInfo implements Serializable {
    @Id
    @Column(name = "sellId")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer sellId;

    @Column(name = "goodName")
    private String goodName;

    @Column(name = "goodPrice")
    private BigDecimal goodPrice;

    @Column(name = "sellAmount")
    private Integer sellAmount;

    @Column(name = "sellTotalPrice")
    private BigDecimal sellTotalPrice;

    @Column(name = "sellTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date sellTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return sellId
     */
    public Integer getSellId() {
        return sellId;
    }

    /**
     * @param sellId
     */
    public void setSellId(Integer sellId) {
        this.sellId = sellId;
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
     * @return sellAmount
     */
    public Integer getSellAmount() {
        return sellAmount;
    }

    /**
     * @param sellAmount
     */
    public void setSellAmount(Integer sellAmount) {
        this.sellAmount = sellAmount;
    }

    /**
     * @return sellTotalPrice
     */
    public BigDecimal getSellTotalPrice() {
        return sellTotalPrice;
    }

    /**
     * @param sellTotalPrice
     */
    public void setSellTotalPrice(BigDecimal sellTotalPrice) {
        this.sellTotalPrice = sellTotalPrice;
    }

    /**
     * @return sellTime
     */
    public Date getSellTime() {
        return sellTime;
    }

    /**
     * @param sellTime
     */
    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }
}