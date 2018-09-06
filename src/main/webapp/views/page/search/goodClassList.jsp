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
	<link rel="stylesheet" href="<c:url value='/views/css/vendor/dataTables.bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/views/js/lib/ztree/css/zTreeStyle/zTreeStyle.css'/>">
	<link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
	<style>
		.form-header {
			display: block;
			padding: 8px 0px;
			font-size: 16px;
			font-weight: 300;
			color: #232323;
			border-bottom: 1px dashed rgba(0, 0, 0, .2);
			margin: 10px 0px;
			font-family: "Microsoft YaHei", Arial, Helvetica, sans-serif, "宋体";
		}

		.form-header .glyphicon-refresh:before {
			vertical-align: -2px;
			padding-right: 2px;
		}
	</style>
</head>
<body>
<div class="page-content">
	<div class="col-xs-3" style="border-right: 1px solid #CCC; min-height: 400px">
	
		<div>
			<ul id="permisionTree" class="ztree"></ul>
			
		</div>
		
	</div>
	
	<div class="col-xs-9">
		<div class="form-header">
			商品类别&nbsp;
			<button class="btn btn-xs btn-warning glyphicon " id="reloadBtn">重新加载</button>
		</div>
		<button class="btn btn-xs btn-primary" id="addBtn">新增</button>
		<!-- <button class="btn btn-xs btn-primary" id="editBtn">修改</button> -->
		<button class="btn btn-xs btn-primary" id="delBtn">删除</button>
		
		<div id="showArea">

		</div>
	</div>
</div>

<!-- 显示在 id="showArea"区域 -->
<script id="viewTemplate" type="text/x-handlebars-template">
    <input type="hidden" id="id" value="{{uid}}" />
    <table class="table table-bordered" style="margin-top: 14px">
        <tbody>
        <tr>
            <td class="col-xs-2 text-right bgcolor_undertint">商品类别名称：</td>
            <td class="text-left">{{goodName}}</td>
        </tr>
       
        <tr>
            <td class="text-right bgcolor_undertint">序号：</td>
            <td class="text-left">{{good_class_sort}}</td>
        </tr>
        <tr>
            <td class="text-right bgcolor_undertint">商品类别描述：</td>
            <td class="text-left">{{good_class_desc}}</td>
        </tr>
        </tbody>
    </table>
</script>


<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/views/js/search/good_list.js'/>"></script>
</body>
</html>
