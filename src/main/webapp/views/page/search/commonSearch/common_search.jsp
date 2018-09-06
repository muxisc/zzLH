<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>综合搜索</title>
<link rel="stylesheet" href="<c:url value='/views/css/vendor/dataTables.bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body>
	<div class="integrated-search">
		<div id="form" class="mt30">
			<div class="ipt-box">
				<input type="text" id="nameOrUniscid" style="color:#272626;" placeholder="请输入书名、书籍编号、作者、地址等信息搜索" class="integrated-search-txt" value="">
			</div>
		</div>
		<div class="center mt25">
			<input type="button" id="search" value="搜索" class="btn-big integrated-search-btn mr20">
		</div>
	</div>

	</script>
	<script src="<c:url value='/views/js/lib/require.js'/>"></script>
	<script src="<c:url value='/views/js/config.js'/>"></script>
	<script src="<c:url value='/views/js/search/commonSearch/common_search.js'/>"></script>
</body>
</html>
