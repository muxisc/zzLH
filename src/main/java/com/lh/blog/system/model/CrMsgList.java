package com.lh.blog.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cr_msg_list 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2018年01月11日
 */
@Table(name = "cr_msg_list")
public class CrMsgList implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * uid
     */
    @Column(name = "uid")
    private String uid;

    /**
     * 消息对应uid
     */
    @Column(name = "messageId")
    private String messageId;

    /**
     * 推送对象uid
     */
    @Column(name = "userId")
    private String userId;

    /**
     * 是否阅读 0未读 1已读
     */
    @Column(name = "isRead")
    private String isRead;

    /**
     * 创建时间
     */
    @Column(name = "createDate")
    private Date createDate;

    /**
     * 阅读时间
     */
    @Column(name = "readDate")
    private Date readDate;

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
     * 获取uid
     *
     * @return uid - uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取消息对应uid
     *
     * @return messageId - 消息对应uid
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 设置消息对应uid
     *
     * @param messageId 消息对应uid
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * 获取推送对象uid
     *
     * @return userId - 推送对象uid
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置推送对象uid
     *
     * @param userId 推送对象uid
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取是否阅读 0未读 1已读
     *
     * @return isRead - 是否阅读 0未读 1已读
     */
    public String getIsRead() {
        return isRead;
    }

    /**
     * 设置是否阅读 0未读 1已读
     *
     * @param isRead 是否阅读 0未读 1已读
     */
    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    /**
     * 获取创建时间
     *
     * @return createDate - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取阅读时间
     *
     * @return readDate - 阅读时间
     */
    public Date getReadDate() {
        return readDate;
    }

    /**
     * 设置阅读时间
     *
     * @param readDate 阅读时间
     */
    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }
}