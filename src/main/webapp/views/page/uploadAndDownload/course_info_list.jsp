<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<title>课程列表</title>
	<link rel="stylesheet" href="<c:url value='/views/css/vendor/dataTables.bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body>
	<div class="iframe-wrap">
		<div class="iframe-header-bg"></div>
		<div class="form-panel">
			<form id="hxForm" class="form-box mb10">
				<div class="form-list">
					<div class="form-item clearfix mr20">
						<div class="col-6">
							<label class="item-name col-5">课程名称：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="courseName" value="">
								</div>
							</div>
						</div>
						<div class="col-6">
							<label class="item-name col-5">课程形式：</label>
							<div class="col-5">
								<div class="ipt-box">
									<select name="courseForm" class="clx">
										<option value="">全部</option>
										<option value="0">视频</option>
										<option value="1">音频</option>
										<option value="2">PPT</option>
									</select>
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
				<div style="margin-bottom: 10px;">
					<input type="button" id="addCourse" value="上传" class="btn ">
					<input type="button" id="exportData" value="导出" class="btn ">
					<input type="button" id="downloadAll" value="全部下载" class="btn ">
				</div>
				<table id="hx-table" class="table-row" width="100%">
					<thead>
						<tr>
							<th style="padding: 0 20px;">序号</th>
							<th>操作</th>
							<th>课程名称</th>
							<th>课程形式</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
<jsp:include page="../system/common/common.jsp"/>
<script src="<c:url value='/views/js/uploadAndDownload/course_info_list.js'/>"></script>
</body>
</html>
