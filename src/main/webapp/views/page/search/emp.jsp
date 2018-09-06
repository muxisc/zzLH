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
                <label class="col-3 control-label">员工编号：</label>
                <div class="col-9">
                
                    <input type="text" name="goodId" maxLength="18" class="form-control" autocomplete="off" 
                           placeholder="请输入员工编号"  value="${sysUserEdit.user_username }"  ${empty sysUserEdit.user_username ? "":"readonly" }>
                           
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label">员工姓名：</label>
                <div class="col-9">
                
                    <input type="password" name="goodName" class="form-control" placeholder="${!empty sysUserEdit.uid? '如需修改密码，请输入新密码':'请输入员工姓名' }"
                           value="" autocomplete="new-password" ${empty sysUserEdit.uid?"required='required'":""} }>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label text-right">员工性别：</label>
                <div class="col-9">
                    <input type="radio" name="field＿name" checked value="'value" >男
                    <input type="radio" name="field＿name"  value="'value" >女
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label text-right">员工身份证号：</label>
                
                <div class="col-9">
                    <input type="text" name="goodPrice" class="form-control" placeholder="请输入员工身份证号"
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
                <label class="col-3 control-label">员工联系方式：</label>
                <div class="col-9">
                
                    <input type="text" name="goodPlace" maxLength="18" class="form-control" autocomplete="off" placeholder="请输入员工联系方式"
                           value="${sysUserEdit.user_phone }">
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
<script src="<c:url value='/views/js/search/goodinfo_addAndEdit.js'/>"></script>
</body>
</html>