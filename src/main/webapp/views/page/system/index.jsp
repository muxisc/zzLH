<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>超市管理中心</title>
    <link rel="stylesheet" href="<c:url value='/views/css/vendor/layout-default-latest.css'/>">
    <link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body style="overflow: hidden; position: relative;" class="manage-page">
<!-- 上部分 头部分-->
<jsp:include page="common/header.jsp"/>

<div id="container">
    <div>


<!-- 下左部分   可折叠菜单-->
        <!-- 菜单 start  -->
        <div class="ui-layout-west" style="display: block;">
            <div class="nano">
                <div class="nano-content">
                    <div class="sidebar">
                        <div class="sidebar-nav">
                            <div class="flex-tab js-trigger"><i></i></div>
                            <ul id="side-menu" class="metismenu">
                                <c:forEach var="menu_1" items="${menus['-1'] }">
                                
  <!-- 登录进去，默认是收起关闭二级菜单的，此时li和ul class="metis-close" 
       打开二级菜单，此时li class="active"和ul class="metis-open"   metisMenu.js会处理
       注：ul需要有class="collapse"，才会默认是收起的，否则默认是展开二级菜单的
  -->                           
                                    <li>
                 <!-- href="javascript:void(0);或javascript:;" 表示一个死链接，不会影响超链接click事件的传播-->
                                        <a href="javascript:void(0)">
                                            <i class="side-icon"></i>
                                            <span class="nav-label">${menu_1.permision_name }</span>
                                            <span class="nav-arrow"></span>
                                        </a>

                                       <c:if test="${!empty menus[menu_1.uid] }">
           <!-- Bootstrap中nav(导航分析)和collapse(折叠效果) -->
                                            <ul class="nav nav-second-level collapse">
                                            <c:forEach var="menu_2" items="${menus[menu_1.uid] }">
                                                <c:if test="${empty menus[menu_2.uid] }">
                                                     <%--不存在三级目录 则二级目录触发--%>
                                                        <li>
                                                            <a class="J_menuItem" href="<c:url value='${menu_2.permision_url }'/>">
                                                                <i class="side-icon"></i>
                                                                <span>${menu_2.permision_name }</span>
                                                            </a>
                                                        </li>
                                                    
                                                 </c:if>
                                                 <c:if test="${!empty menus[menu_2.uid] }">
                                                     <%--存在三级目录 则二级目录不触发 三级目录触发--%>
                                                        <li>
                                                            <a href="javascript:void(0)"><span class="nav-arrow">${menu_2.permision_name }</span></a>
                                                            <ul class="nav nav-third-level collapse">
                                                                <c:forEach var="menu_3" items="${menus['menu_2.uid'] }">
                                                                    <li><a class="J_menuItem" href="<c:url value='${menu_3.permision_url }'/>">${menu_3.permision_name }</a></li>
                                                                </c:forEach>
                                                            </ul>

                                                        </li>
                                                  </c:if>  

                                               </c:forEach>
                                            </ul>
                                        </c:if>
                                    </li>
                               </c:forEach>
                            </ul>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 菜单 end  -->
       
<!-- 下右部分 主要内容部分 --> 
       <div class="ui-layout-center" style="padding-left: 170px;">
            <div id="page-wrapper" style="padding-top: 0px;">
                <div class="sub-nav J_menuTab" style="display: none;">
                    <i class="home-icon"></i>
                    <a href="javascript:void(0);" class="first-nav"></a>
                    <a href="javascript:void(0);" class="second-nav"></a>
                    <a href="javascript:void(0);" class="cur third-nav"></a>
                </div>
                
                <div id="content-main" class="J_mainContent pdt0">
 <!--嵌入式框架iframe  1.登陆成功进入后台,这部分会显示homePage页面   2.点击用户管理等后，改变src值去触发，用户页面会显示在该部分    多用ajax -->
                    <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<c:url value='/admin/homePage'/>" data-id="/admin/homePage" frameborder="0"></iframe>
                
                </div>
            </div>
        </div>
        
    </div>
</div>


<!-- 通用页面 -->
<jsp:include page="common/common.jsp"/>

<script type="text/javascript" src="<c:url value='/views/js/system/index.js' />"></script>
</body>
</html>