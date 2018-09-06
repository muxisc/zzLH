<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<title>Echarts</title>
	<link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body class="pdr15">
   <!--  饼图pie -->
  <div id="pie_echarts" style="float:left;width:50%;height:100%;">

  </div>
  
   <!-- 地图map -->
  <div id="zjmap_echarts" style="float:left;width:50%;height:100%;">

  </div>
  

<jsp:include page="../system/common/common.jsp" />
<script src="<c:url value='/views/js/echarts/pie_echarts.js'/>"></script>
</body>
</html>
