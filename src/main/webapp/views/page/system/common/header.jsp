<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header clearfix">
    <a href="/admin/index" class="logo fl" style="font-size: 24px;color:#fff;line-height: 55px">
        超市管理
    </a>
    <c:if test="${!empty sysUserKey }">
    	<div class="hd-nav fr">
            <ul class="fl">
                <li class="user">
                    <span class="hd-icon"></span><em>${userProfile.realName }</em><b class="hd-icon arrow-icon"></b> 
                    <div class="tip-box">
                        <ul class="clearfix">
                            <li class="hd-icon fl edit-pw">修改密码</li>
                            <li class="hd-icon fl edit-pw js-logout">退出系统</li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
   </c:if> 
</div>