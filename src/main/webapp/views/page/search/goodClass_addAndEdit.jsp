<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>权限管理</title>
    <link rel="stylesheet" href="<c:url value='/views/css/vendor/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body>
<div class="container .container-fluid">
    <div class="">
        <form class="form-horizontal" id="sysPermisionForm">
        
          <input type="hidden" name="uid" value="${sysPermision.uid }" />
        
            <%-- <div class="form-group">
                <label class="col-xs-3 control-label">上级权限：</label>
           <div class="col-xs-9">
              <c:choose> 
                <c:when test="${empty sysPermision}">
                          <input type="radio" name="permision_parent_id" checked="checked" value="${parentIdForTj }">添加同级权限
                          <input type="radio" name="permision_parent_id" value="${parentIdForZj}">添加子权限
                </c:when>
                <c:otherwise>
                  ${empty parentName ? '无':parentName}
                </c:otherwise>
             </c:choose> 
            </div>  
            </div> --%>
            <div class="form-group">
                <label class="col-xs-3 control-label">商品类别名称(<span style="color: red"> *</span>)：</label>
                <div class="col-xs-9">
                    <input type="text" name="permision_name" class="form-control" maxLength="20" placeholder="请输入商品类别名称"
                           value="${sysPermision.permision_name }">
                </div>
            </div>
            <%-- <div class="form-group">
                <label class="col-xs-3 control-label">权限类型：</label>
            <div class="col-xs-9">
                <c:choose>
                  <c:when test="${empty sysPermision }">
	                            <input type="radio" name="permision_type" checked="checked" value="1">菜单权限
	                            <input type="radio" name="permision_type" value="0">操作权限
	
	              </c:when>
	              <c:otherwise>
	                ${sysPermision.permision_type=='1' ? '菜单权限':'操作权限' }
	              </c:otherwise>
                </c:choose>
             </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">权限资源(<span style="color: red"> *</span>)：</label>
                <div class="col-xs-9">
                    <input type="text" name="permision_url" class="form-control" placeholder="请输入权限资源"
                           value="${sysPermision.permision_url }">
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">关联资源：</label>
                <div class="col-xs-9">
                    <input type="text" name="permision_related_url" class="form-control" placeholder="请输入关联权限资源"
                           value="${sysPermision.permision_related_url }">
                </div>
            </div> --%>
            <div class="form-group">
                <label class="col-xs-3 control-label">序号：</label>
                <div class="col-xs-9">
                    <input type="text" name="permision_sort" class="form-control" placeholder="请输入序号"
                           value="${sysPermision.permision_sort }">
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3 control-label">商品类别描述：</label>
                <div class="col-xs-9">
                    <textarea name="permision_desc" class="form-control" maxLength="50" placeholder="请输入商品类别描述">${sysPermision.permision_desc}</textarea>
                </div>
            </div>
        </form>
    </div>
    <div class="row text-center">
        <button id="save" type="button" class="btn btn-primary">保存</button>
        <button id="cancel" type="button" class="btn btn-primary">取消</button>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/views/js/system/syspermision/permision_addAndEdit.js'/>"></script>
</body>
</html>
