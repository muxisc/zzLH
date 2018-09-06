<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<title>用户管理</title>
	<link rel="stylesheet" href="<c:url value='/views/css/vendor/dataTables.bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body>
<div class="iframe-wrap">
	<div class="iframe-header-bg"></div>
	<div class="form-panel">
	
	  <form id="user-form" class="form-box mb10">
	  
		
			<div class="form-list">
				<div class="form-item clearfix mr20">
					<div class="col-6">
							<label class="item-name col-5">用户名 ：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="user_username" value="">
								</div>
							</div>
					</div>
					<div class="col-6" id="uniCode">
							<label class="item-name col-5">姓名 ：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="user_real_name" value="">
								</div>
							</div>
					</div>
				</div>
			</div>
			
			<div class="mt15">
					<div class="center">
						<input type="button" id="search" value="查询" class="btn mr20"> 
						<input type="reset" value="重置" class="btn ">
					</div>
			</div>
				
	  </form>

		<div class="pd15">
		
			<div class="clearfix mb5">
				<p class="fl">
				
				<input type="button" class="btn btn-sm mr5 js-add" value="创建新用户">
				
				</p>
			</div>


			<table id="user-table" class="table-row" width="100%">
				<thead>
				<tr>
					<th>用户名</th>
					<th>姓名</th>
					<!-- <th>部门</th> -->
					<th>电子邮件</th>
					<!-- <th>用户状态</th> -->
					<th>联系方式</th>
					<th>创建时间</th>
					<th>最后登录时间</th>
					<th>操作</th>
				</tr>
				</thead>
			</table>
		</div>
	</div>
	
	
	<!-- 操作列 ：每行2个按钮：编辑和删除                handlebars.js模板引擎-->
	<script id="tpl" type="text/x-handlebars-template">
		{{#each func}}
		<button type="button" class="{{this.class}}">{{this.text}}</button>
		{{/each}}
	</script>

<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/views/js/system/sysuser/user_list.js'/>"></script>
</body>
</html>
