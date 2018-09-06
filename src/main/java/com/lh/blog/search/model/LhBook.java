package com.lh.blog.search.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    lh_book 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年01月19日
 */
@Table(name = "lh_book")
public class LhBook implements Serializable {
    
    /*@Id*/
    @Column(name = "id")
    /*@Before*/
    /*@GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")*/
    private Integer id;
    
    /**
     * 主键
     */
    @Id
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 书籍名称
     */
    @Column(name = "bookName")
    private String bookName;

    /**
     * 书籍状态
     */
    @Column(name = "bookState")
    private String bookState;

    /**
     * 书籍编号
     */
    @Column(name = "bookNumber")
    private String bookNumber;

    /**
     * 作者
     */
    @Column(name = "author")
    private String author;

    /**
     * 出版日期
     */
    @Column(name = "publishDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date publishDate;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 作者简介
     */
    @Column(name = "authorDesc")
    private String authorDesc;

    /**
     * 书籍简介
     */
    @Column(name = "bookDesc")
    private String bookDesc;
    
    /**
     * 书籍类型
     */
    @Column(name = "bookType")
    private String bookType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取书籍名称
     *
     * @return bookName - 书籍名称
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置书籍名称
     *
     * @param bookName 书籍名称
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 获取书籍状态
     *
     * @return bookState - 书籍状态
     */
    public String getBookState() {
        return bookState;
    }

    /**
     * 设置书籍状态
     *
     * @param bookState 书籍状态
     */
    public void setBookState(String bookState) {
        this.bookState = bookState;
    }

    /**
     * 获取书籍编号
     *
     * @return bookNumber - 书籍编号
     */
    public String getBookNumber() {
        return bookNumber;
    }

    /**
     * 设置书籍编号
     *
     * @param bookNumber 书籍编号
     */
    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取出版日期
     *
     * @return publishDate - 出版日期
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 设置出版日期
     *
     * @param publishDate 出版日期
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取作者简介
     *
     * @return authorDesc - 作者简介
     */
    public String getAuthorDesc() {
        return authorDesc;
    }

    /**
     * 设置作者简介
     *
     * @param authorDesc 作者简介
     */
    public void setAuthorDesc(String authorDesc) {
        this.authorDesc = authorDesc;
    }

    /**
     * 获取书籍简介
     *
     * @return bookDesc - 书籍简介
     */
    public String getBookDesc() {
        return bookDesc;
    }

    /**
     * 设置书籍简介
     *
     * @param bookDesc 书籍简介
     */
    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
    
    
}