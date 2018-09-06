/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.lh.blog.search.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    goodstockinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年04月27日
 */
@Table(name = "goodstockinfo")
public class GoodStockInfo implements Serializable {
    @Id
    @Column(name = "goodId")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer goodId;

    @Column(name = "goodStockAmount")
    private Integer goodStockAmount;
    @Column(name = "goodStockDuo")
    private String goodStockDuo;
    
    
    @Column(name = "goodStockShao")
    private String goodStockShao;

    public String getGoodStockShao() {
		return goodStockShao;
	}

	public void setGoodStockShao(String goodStockShao) {
		this.goodStockShao = goodStockShao;
	}

	public String getGoodStockDuo() {
		return goodStockDuo;
	}

	public void setGoodStockDuo(String goodStockDuo) {
		this.goodStockDuo = goodStockDuo;
	}

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
     * @return goodStockAmount
     */
    public Integer getGoodStockAmount() {
        return goodStockAmount;
    }

    /**
     * @param goodStockAmount
     */
    public void setGoodStockAmount(Integer goodStockAmount) {
        this.goodStockAmount = goodStockAmount;
    }
}