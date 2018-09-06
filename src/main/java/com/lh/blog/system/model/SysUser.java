package com.lh.blog.system.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    sys_user 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月17日
 */
@Table(name = "sys_user")
public class SysUser implements Serializable {
    /*
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;*/

	
	/**
     * 主键 
     */
	//@Before和@GeneratedValue表示在插入之前   生成一个随机uuid 作为主键uid的值       注：必须和@Id搭配   
	@Id
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy=GenerationType.IDENTITY,generator="select replace(uuid(),'-','')")
    private String uid;

    /**
     * 登录用户名
     */
    @Column(name = "user_username")
    private String user_username;

    /**
     * 登录密码
     */
    @Column(name = "user_password")
    private String user_password;

    /**
     * 密码盐值
     */
    @Column(name = "user_password_salt")
    private String user_password_salt;

    /**
     * 用户唯一编号
     */
    @Column(name = "user_identity")
    private String user_identity;

    /**
     * 真实姓名
     */
    @Column(name = "user_real_name")
    private String user_real_name;

    /**
     * 电子邮件
     */
    @Column(name = "user_email")
    private String user_email;

    /**
     * 创建时间
     */
    @Column(name = "user_create_time")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date user_create_time;

    /**
     * 最后登录时间
     */
    @Column(name = "user_last_login_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date user_last_login_time;

    /**
     * 用户状态 1:有效 0:无效
     */
    @Column(name = "user_status")
    private String user_status;

    /**
     * 用户描述
     */
    @Column(name = "user_desc")
    private String user_desc;

    /**
     * 用户部门
     */
    @Column(name = "user_dept")
    private String user_dept;

    /**
     * 联系方式
     */
    @Column(name = "user_phone")
    private String user_phone;

    private static final long serialVersionUID = 1L;

    

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
     * 获取登录用户名
     *
     * @return user_username - 登录用户名
     */
    public String getUser_username() {
        return user_username;
    }

    /**
     * 设置登录用户名
     *
     * @param user_username 登录用户名
     */
    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    /**
     * 获取登录密码
     *
     * @return user_password - 登录密码
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * 设置登录密码
     *
     * @param user_password 登录密码
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /**
     * 获取密码盐值
     *
     * @return user_password_salt - 密码盐值
     */
    public String getUser_password_salt() {
        return user_password_salt;
    }

    /**
     * 设置密码盐值
     *
     * @param user_password_salt 密码盐值
     */
    public void setUser_password_salt(String user_password_salt) {
        this.user_password_salt = user_password_salt;
    }

    /**
     * 获取用户唯一编号
     *
     * @return user_identity - 用户唯一编号
     */
    public String getUser_identity() {
        return user_identity;
    }

    /**
     * 设置用户唯一编号
     *
     * @param user_identity 用户唯一编号
     */
    public void setUser_identity(String user_identity) {
        this.user_identity = user_identity;
    }

    /**
     * 获取真实姓名
     *
     * @return user_real_name - 真实姓名
     */
    public String getUser_real_name() {
        return user_real_name;
    }

    /**
     * 设置真实姓名
     *
     * @param user_real_name 真实姓名
     */
    public void setUser_real_name(String user_real_name) {
        this.user_real_name = user_real_name;
    }

    /**
     * 获取电子邮件
     *
     * @return user_email - 电子邮件
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * 设置电子邮件
     *
     * @param user_email 电子邮件
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * 获取创建时间
     *
     * @return user_create_time - 创建时间
     */
    public Date getUser_create_time() {
        return user_create_time;
    }

    /**
     * 设置创建时间
     *
     * @param user_create_time 创建时间
     */
    public void setUser_create_time(Date user_create_time) {
        this.user_create_time = user_create_time;
    }

    /**
     * 获取最后登录时间
     *
     * @return user_last_login_time - 最后登录时间
     */
    public Date getUser_last_login_time() {
        return user_last_login_time;
    }

    /**
     * 设置最后登录时间
     *
     * @param user_last_login_time 最后登录时间
     */
    public void setUser_last_login_time(Date user_last_login_time) {
        this.user_last_login_time = user_last_login_time;
    }

    /**
     * 获取用户状态 1:有效 0:无效
     *
     * @return user_status - 用户状态 1:有效 0:无效
     */
    public String getUser_status() {
        return user_status;
    }

    /**
     * 设置用户状态 1:有效 0:无效
     *
     * @param user_status 用户状态 1:有效 0:无效
     */
    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    /**
     * 获取用户描述
     *
     * @return user_desc - 用户描述
     */
    public String getUser_desc() {
        return user_desc;
    }

    /**
     * 设置用户描述
     *
     * @param user_desc 用户描述
     */
    public void setUser_desc(String user_desc) {
        this.user_desc = user_desc;
    }

    /**
     * 获取用户部门
     *
     * @return user_dept - 用户部门
     */
    public String getUser_dept() {
        return user_dept;
    }

    /**
     * 设置用户部门
     *
     * @param user_dept 用户部门
     */
    public void setUser_dept(String user_dept) {
        this.user_dept = user_dept;
    }

    /**
     * 获取联系方式
     *
     * @return user_phone - 联系方式
     */
    public String getUser_phone() {
        return user_phone;
    }

    /**
     * 设置联系方式
     *
     * @param user_phone 联系方式
     */
    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}