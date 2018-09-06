package com.lh.blog.search.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    lh_course_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年02月06日
 */
@Table(name = "lh_course_info")
public class LhCourseInfo implements Serializable {
    /*@Id*/
    @Column(name = "id")
    /*@Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")*/
    private Integer id;

    
    @Id
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 课程名称
     */
    @Column(name = "courseName")
    private String courseName;

    /**
     * 课程形式     0视频    1音频    2PPT
     */
    @Column(name = "courseForm")
    private String courseForm;

    /**
     * 文件路径
     */
    @Column(name = "filePath")
    private String filePath;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createTime;

    /**
     * 课程简介
     */
    @Column(name = "briefInfo")
    private String briefInfo;

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
     * 获取课程名称
     *
     * @return courseName - 课程名称
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 设置课程名称
     *
     * @param courseName 课程名称
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 获取课程形式0视频1音频2PPT
     *
     * @return courseForm - 课程形式0视频1音频2PPT
     */
    public String getCourseForm() {
        return courseForm;
    }

    /**
     * 设置课程形式0视频1音频2PPT
     *
     * @param courseForm 课程形式0视频1音频2PPT
     */
    public void setCourseForm(String courseForm) {
        this.courseForm = courseForm;
    }

    /**
     * 获取文件路径
     *
     * @return filePath - 文件路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置文件路径
     *
     * @param filePath 文件路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取课程简介
     *
     * @return briefInfo - 课程简介
     */
    public String getBriefInfo() {
        return briefInfo;
    }

    /**
     * 设置课程简介
     *
     * @param briefInfo 课程简介
     */
    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }
}