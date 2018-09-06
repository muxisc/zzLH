<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>角色管理</title>
    <link rel="stylesheet" href="<c:url value='/views/css/vendor/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/views/js/lib/ztree/css/zTreeStyle/zTreeStyle.css'/>">
    <link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body>
<div class="container .container-fluid">
    <div class="clearfix" style="margin-bottom: 10px;">
        <div class="col-xs-6">
        
            <form class="form-horizontal" id="sysRoleForm">
                <input type="hidden" name="uid" value="${sysRole.uid }">
                <div class="form-group">
                    <font color="red">*</font><label class="control-label">角色名称：</label>
                    
                    <input type="text" name="role_name" id="roleName" class="form-control" maxLength="15" placeholder="请输入角色名称"
                           value="${sysRole.role_name }">
                           
                </div>
                <div class="form-group">
                    <font color="red">*</font><label class="control-label">备注：</label>
                    
                    <textarea name="role_desc" class="form-control" rows="8" maxLength="100" placeholder="请输入角色描述">${sysRole.role_desc }</textarea>
                
                </div>
            </form>
        </div>
        <div class="col-xs-6">
            <h5>选择角色权限</h5>
            
            <ul id="permisionTree" class="ztree ztree-list"></ul>
            
        </div>
    </div>
    <div class="row text-center">
        <button id="cancel" type="button" class="btn btn-primary">取消</button>
        <button id="save" type="button" class="btn btn-primary">保存</button>
    </div>
</div>

<script>
    var roleId = '${sysRole.uid}';
</script>

<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/views/js/system/sysrole/role_addAndEdit.js'/>"></script>
</body>
</html>