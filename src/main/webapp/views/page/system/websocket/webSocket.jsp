<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<title>Java后端WebSocket的Tomcat实现</title>
</head>
<body>
  Welcome
  <br/>
  <input id="text" type="text"/>
  <button onclick="send()">发送消息</button> 
  <hr/>
  <button onclick="closeWebSocket()">关闭WebSocket连接</button>
  <hr/>
  <div id="message"></div>
  <input type="hidden" name="sendUser" id="sendUser" value="${sessionScope.sysUser.user_username }">
</body>

<script type="text/javascript">
     var websocket = null;
     var username=document.getElementById('sendUser').value;
     if(username == "sc"){
    	 var toUsername="lkl";         
     }else{
    	 var toUsername="sc";         //receiverUser
     }
     //判断当前浏览器是否支持WebSocket
     if ('WebSocket' in window) {
    	 //申请一个WebSocket对象，参数是需要连接的服务器端的地址
    	 //WebSocket协议的URL使用ws://开头
    	 var url="ws://localhost:8080/zzLH/websocket?username="+username+"&toUsername="+toUsername;
         websocket = new WebSocket(url); //打开websocket连接
     }
     else {
         alert('当前浏览器 Not support websocket')
     }
 
     //连接发生错误的回调方法
     websocket.onerror = function () {
         setMessageInnerHTML("WebSocket连接发生错误");
     };
 
     //连接成功建立的回调方法
     websocket.onopen = function () {
         setMessageInnerHTML("WebSocket连接成功");
     }
 
     //接收到消息的回调方法    同样服务器也可以随时向我们发送讯息，会启动onmessage
     websocket.onmessage = function (event) {
         setMessageInnerHTML(event.data);
     }
 
     //连接关闭的回调方法
     websocket.onclose = function () {
         setMessageInnerHTML("WebSocket连接关闭");
     }
 
     //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
     window.onbeforeunload = function () {
         closeWebSocket();
     }
 
     //将消息显示在网页上
     function setMessageInnerHTML(innerHTML) {
         document.getElementById('message').innerHTML += innerHTML + '<br/>';
     }
 
     //关闭WebSocket连接
     function closeWebSocket() {
         websocket.close();
     }
 
     //发送消息    连接成功，启动open事件时，可以开始对连接对象使用send方法，向服务器发送数据
     function send() {
    	//js中获取当前时间
         var date = new Date(); 
         var mon = date.getMonth() + 1;
         var day = date.getDate();
         var hour=date.getHours();
         var min=date.getMinutes();
         var second=date.getSeconds();
         var nowDay = date.getFullYear() + "-" + (mon<10?"0"+mon:mon) + "-" 
         +(day<10?"0"+day:day)+'&nbsp'+(hour<10?"0"+hour:hour)+":"+(min<10?"0"+min:min)+":"
         +(second<10?"0"+second:second);
         
         var username=document.getElementById('sendUser').value;
         if(username == "sc"){
        	 var toUsername="lkl";         
         }else{
        	 var toUsername="sc";         //receiverUser
         }
         
         var message = username+"("+nowDay+"):"+'<br/>'
                     +'&nbsp'+document.getElementById('text').value+"*"+toUsername;
    	 
         //var message = document.getElementById('text').value;
         websocket.send(message);
     }
</script>

</html>