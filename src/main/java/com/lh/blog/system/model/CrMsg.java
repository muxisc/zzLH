package com.lh.blog.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cr_msg 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年01月11日
 */
@Table(name = "cr_msg")
public class CrMsg implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String id;

    @Column(name = "uid")
    private String uid;

    /**
     * 消息标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 消息内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 发布者
     */
    @Column(name = "create_user")
    private String create_user;

    /**
     * 发布者id
     */
    @Column(name = "user_id")
    private String user_id;

    /**
     * 发布部门
     */
    @Column(name = "user_dept")
    private String user_dept;

    /**
     * 发布时间
     */
    @Column(name = "publish_time")
    private Date publish_time;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date update_time;

    /**
     * 删除时间
     */
    @Column(name = "delete_time")
    private Date delete_time;

    /**
     * 消息状态；0:有效;1:已删除
     */
    @Column(name = "isValid")
    private String isValid;

    /**
     * 消息类型:0:系统消息;1:关注消息
     */
    @Column(name = "msg_type")
    private String msg_type;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
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
     * 获取消息标题
     *
     * @return title - 消息标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置消息标题
     *
     * @param title 消息标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取消息内容
     *
     * @return content - 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置消息内容
     *
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取发布者
     *
     * @return create_user - 发布者
     */
    public String getCreate_user() {
        return create_user;
    }

    /**
     * 设置发布者
     *
     * @param create_user 发布者
     */
    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    /**
     * 获取发布者id
     *
     * @return user_id - 发布者id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * 设置发布者id
     *
     * @param user_id 发布者id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取发布部门
     *
     * @return user_dept - 发布部门
     */
    public String getUser_dept() {
        return user_dept;
    }

    /**
     * 设置发布部门
     *
     * @param user_dept 发布部门
     */
    public void setUser_dept(String user_dept) {
        this.user_dept = user_dept;
    }

    /**
     * 获取发布时间
     *
     * @return publish_time - 发布时间
     */
    public Date getPublish_time() {
        return publish_time;
    }

    /**
     * 设置发布时间
     *
     * @param publish_time 发布时间
     */
    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * 设置修改时间
     *
     * @param update_time 修改时间
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * 获取删除时间
     *
     * @return delete_time - 删除时间
     */
    public Date getDelete_time() {
        return delete_time;
    }

    /**
     * 设置删除时间
     *
     * @param delete_time 删除时间
     */
    public void setDelete_time(Date delete_time) {
        this.delete_time = delete_time;
    }

    /**
     * 获取消息状态；0:有效;1:已删除
     *
     * @return isValid - 消息状态；0:有效;1:已删除
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * 设置消息状态；0:有效;1:已删除
     *
     * @param isValid 消息状态；0:有效;1:已删除
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取消息类型:0:系统消息;1:关注消息
     *
     * @return msg_type - 消息类型:0:系统消息;1:关注消息
     */
    public String getMsg_type() {
        return msg_type;
    }

    /**
     * 设置消息类型:0:系统消息;1:关注消息
     *
     * @param msg_type 消息类型:0:系统消息;1:关注消息
     */
    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }
}