package com.lh.blog.search.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    lh_pie_echarts 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年03月01日
 */
@Table(name = "lh_pie_echarts")
public class LhPieEcharts implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 书籍类型
     */
    @Column(name = "pieBookType")
    private String pieBookType;

    /**
     * 各类型书籍的数量
     */
    @Column(name = "pieTypeAmount")
    private String pieTypeAmount;

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
     * 获取书籍类型
     *
     * @return pieBookType - 书籍类型
     */
    public String getPieBookType() {
        return pieBookType;
    }

    /**
     * 设置书籍类型
     *
     * @param pieBookType 书籍类型
     */
    public void setPieBookType(String pieBookType) {
        this.pieBookType = pieBookType;
    }

    /**
     * 获取各类型书籍的数量
     *
     * @return pieTypeAmount - 各类型书籍的数量
     */
    public String getPieTypeAmount() {
        return pieTypeAmount;
    }

    /**
     * 设置各类型书籍的数量
     *
     * @param pieTypeAmount 各类型书籍的数量
     */
    public void setPieTypeAmount(String pieTypeAmount) {
        this.pieTypeAmount = pieTypeAmount;
    }
}