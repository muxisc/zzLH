/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.lh.blog.search.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    goodClassInfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年04月27日
 */
@Table(name = "goodclassinfo")
public class GoodClassInfo implements Serializable {
    /*@Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;
*/
    
    @Id
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    @Column(name = "goodName")
    private String goodName;

    @Column(name = "good_parent_id")
    private String good_parent_id;

    @Column(name = "good_class_sort")
    private Integer good_class_sort;

    @Column(name = "good_class_desc")
    private String good_class_desc;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
   /* public Integer getId() {
        return id;
    }

    *//**
     * @param id
     *//*
    public void setId(Integer id) {
        this.id = id;
    }*/

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
     * @return good_parent_id
     */
    public String getGood_parent_id() {
        return good_parent_id;
    }

    /**
     * @param good_parent_id
     */
    public void setGood_parent_id(String good_parent_id) {
        this.good_parent_id = good_parent_id;
    }

    /**
     * @return good_class_sort
     */
    public Integer getGood_class_sort() {
        return good_class_sort;
    }

    /**
     * @param good_class_sort
     */
    public void setGood_class_sort(Integer good_class_sort) {
        this.good_class_sort = good_class_sort;
    }

    /**
     * @return good_class_desc
     */
    public String getGood_class_desc() {
        return good_class_desc;
    }

    /**
     * @param good_class_desc
     */
    public void setGood_class_desc(String good_class_desc) {
        this.good_class_desc = good_class_desc;
    }
}