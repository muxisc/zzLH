<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>用户管理</title>
	<link rel="stylesheet" href="<c:url value='/views/css/vendor/dataTables.bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body>
<div class="container .container-fluid">
    <div class="form-format">
    
        <form class="form-horizontal" id="sysUserForm">
          <input type="hidden" name="uid" value="${sysUserEdit.uid }">
          <input type="hidden" name="user_dept" value="80000">
        
            <div class="form-group clearfix">
                <label class="col-3 control-label">用户名：</label>
                <div class="col-9">
                
                    <input type="text" name="user_username" maxLength="18" class="form-control" autocomplete="off" 
                           placeholder="请输入登录用户名"  value="${sysUserEdit.user_username }"  ${empty sysUserEdit.user_username ? "":"readonly" }>
                           
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label">登录密码：</label>
                <div class="col-9">
                
                    <input type="password" name="user_password" class="form-control" placeholder="${!empty sysUserEdit.uid? '如需修改密码，请输入新密码':'请输入登录密码' }"
                           value="" autocomplete="new-password" ${empty sysUserEdit.uid?"required='required'":""} }>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label text-right">姓名：</label>
                <div class="col-9">
                
                    <input type="text" name="user_real_name" class="form-control" maxLength="15" placeholder="请输入姓名"
                           value="${sysUserEdit.user_real_name }">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label text-right">Email：</label>
                
                <div class="col-9">
                    <input type="text" name="user_email" class="form-control" placeholder="请输入Email地址"
                           value="${sysUserEdit.user_email }">
                </div>
            </div>
            <!-- <div class="form-group clearfix">
                <label class="col-3 control-label ">部门：</label>
                <div class="col-9 pos-rel">
                    <input type="text" class="form-control" name="userdeptname"  id="userdeptname" value="" readonly/>
                        <input type="hidden"  name="userdept" id="userdept" value=""/>
                        <span class="add-icon" id="selectDept">
                            <i></i>
                        </span>
                </div>
            </div> -->
            <div class="form-group clearfix">
                <label class="col-3 control-label">联系方式：</label>
                <div class="col-9">
                
                    <input type="text" name="user_phone" maxLength="18" class="form-control" autocomplete="off" placeholder="请输入手机号码"
                           value="${sysUserEdit.user_phone }">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label text-right">角色：</label>
                <div class="col-9">
                    <c:forEach var="role" items="${allRoles }">
                        <label class="checkbox-inline">
                    <!--注：后台SysUserDto：String[] roles，此处name="roles[]" -->
                            <input type="checkbox" name="roles[]"
                                   value="${role.uid }" ${(empty sysUserRoleMap[role.uid])? "":"checked"  }>${role.role_name }
                        </label>
                    </c:forEach>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label text-right">用户状态：</label>
                <div class="col-9">
                        <label class="checkbox-inline">
                            <input type="radio" name="user_status" value="1" ${(sysUserEdit.user_status == "1")?"checked":"" }>有效
                            <input type="radio" name="user_status" value="0" ${(sysUserEdit.user_status =="0" || empty sysUserEdit.user_status)? "checked":"" }>无效
                        </label>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label text-right">备注：</label>
                <div class="col-9">
                    <textarea name="user_desc" class="form-control" maxLength="30" style="line-height:28px">${sysUserEdit.user_desc }</textarea>
                </div>
            </div>
            <div class="center mt20">
                 <!-- submit -->
         	    <button id="save" type="submit" class="btn btn-sm mr20">保存</button>
         	    
                <button id="cancel" type="button" class="btn btn-sm mr20">取消</button>
            </div>
        </form>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/views/js/system/sysuser/user_addAndEdit.js'/>"></script>
</body>
</html>