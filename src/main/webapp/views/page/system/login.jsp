<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <!-- <title>welcome-login</title> -->
    <title>超市管理系统用户登陆</title>
    <link rel="stylesheet" href="<c:url value='/views/css/system/style.css'/>">
</head>
<body class="bg-login">
    <div class="login-bg-cont">
    <form id="login-form">
        <div class="login-box">
            <div class="login-form">
            
                <from>
                    <input class="login-ipt login-user" name="username" placeholder="请输入用户名" type="text" value="管理员">
                    <input class="login-ipt login-password" name="password" placeholder="请输入密码" type="password" value="admin123">
                    <!-- <input class="login-ipt login-verification" name="checkCode" placeholder="请输入验证码" type="text">  -->
                    <!-- <img class="login-code-img" width="92" height="44" src="/ndrcCaptcha?t=0.9532056235676236" alt=""> -->
                    <input class="login-btn" type="submit" value="登 录">
                </from>
            </div>
        </div>
  	</form>
    </div>
    
</body>
<script src="<c:url value='/views/js/lib/require.js'/>"></script>
<script src="<c:url value='/views/js/config.js'/>"></script>
<script src="<c:url value='/views/js/system/login/login.js'/>"></script>
</body>
</html>
