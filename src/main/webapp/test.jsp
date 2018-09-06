<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<script type="text/javascript" src="views/js/lib/jquery/jquery-1.12.3.min.js"></script>  
<title>测试</title>  
</head>  
<body>  
<h2>测试</h2>  

<hr>

<a href="<c:url value='test/selectInfo' />">基本信息</a>


<hr/>

<form action="<c:url value='/test/insertInfo' />">
 姓名：<input type="text" name="name"/>
年龄：<input type="text" name="age"/>

<input type="submit" value="提交1"/>
</form>

<hr/>
<form action="<c:url value='/generator/insertGen' />">
 测试姓名：<input type="text" name="testname"/>
测试内容：<input type="text" name="testcontent"/>
测试金额：<input type="text" name="testmoney"/>

<input type="submit" value="提交2"/>
</form>

</body>  
</html>