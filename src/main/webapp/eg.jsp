<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>  
<title>Insert title here</title>  
</head>  
<body>  
<input id="inp" type="hidden" maxlength="20">  
<h2>Test formMait</h2>  
<form action="submit.do" method="post" >
账户<input type="text" name="userName"><br>  
密码<input type="text" name="password"><br>  
<button>提交</button>  
</form>  
<script type="text/javascript">  
 $(function(){  
    // alert("json hello");  
       
 })  
 function clicBt(){  
     console.log("hello friends!!!")  
     $.ajax({  
           type: "POST",  
           url: "test.do?id="+$("#inp").val(),  
           data: "name=John&location=Boston",  
           success: function(msg){  
             alert("china is hello  and you are okau!");  
           }  
        });  
       
       
 }  
</script>  
</body>  
</html>