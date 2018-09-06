<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<title>角色管理</title>
	<link rel="stylesheet" href="<c:url value='/views/css/vendor/dataTables.bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body>
<div class="iframe-wrap">
    <!-- 去掉，否则创建角色按钮没有用 -->
	<!-- <div class="iframe-header-bg"></div> -->
	<div class="form-panel">
	
		<div class="pd15">
		
			<div class="clearfix mb5">
				<p class="fl">
				   <input type="button" class="btn btn-sm mr5 js-add" value="创建角色">
				</p>
			</div>

            
			<table id="role-table" class="table-row" width="100%">
				<thead>
				<tr>
					<th>序号</th>
					<th>角色名</th>
					<th>角色描述</th>
					<th>操作</th>
				</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<!-- class="{{this.class}}" 双引号必须加上-->
<script id="tpl" type="text/x-handlebars-template">

{{#each func}}
  <button type="button" class="{{this.class}}">{{this.text}}</button>
{{/each}}
</script>
	
<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/views/js/system/sysrole/role_list.js'/>"></script> 
</body>
</html>
