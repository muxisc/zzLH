package com.lh.blog.system.websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
  * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
  * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
  */
 @ServerEndpoint("/websocket")
 public class WebSocketTest {
     //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     //private static int onlineCount = 0;
 
     //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
     //private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<WebSocketTest>();
	 private static final Map<String,Session> userSessionMap=new ConcurrentHashMap<String,Session>();
	 
     //与某个客户端的连接会话，需要通过它来给客户端发送数据
     private Session session;
     public void setSession(Session session) {
			this.session = session;
	 }
     
     private String username;
     private String toUsername;
     private String name;
    
     /**
      * 连接建立成功调用的方法
      * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @throws IOException 
      */
     @OnOpen
     public void onOpen(Session session) throws IOException{
         this.session = session;
         String username1 = session.getQueryString();  // username=zhang&toUsername=li  
         int index1=username1.indexOf('=');
         int index11=username1.indexOf('&');
         String username=username1.substring(index1+1,index11);  //发送者用户名
         int index2=username1.lastIndexOf('=');
         String toUsername=username1.substring(index2+1);  //接收者用户名
         this.username=username;
         this.toUsername=toUsername;
         this.name=username+toUsername;
         System.out.println("&&&&&&&&&"+name);
        
         //sclkl的session    sc登录进来找lkl
         userSessionMap.put(name, this.session); 
         //lkl登录进来找sc，toUsername+username)就是sclkl
         Session session2 = userSessionMap.get(toUsername+username);
        
         if(session2==null){  //说明lkl没有登录进来找sc             lkl不在线
        	String message2="-------------------------抱歉了，"+toUsername+" 不在线！！！-----------------------";
        	this.session.getBasicRemote().sendText(message2);
        
        }else{
        	String message2="-------------------------恭喜了，"+toUsername+" 在线了！！！-----------------------";
        	String message3="-------------------------恭喜了，"+username+" 在线了！！！-----------------------";
        	this.session.getBasicRemote().sendText(message2);  //sc的对话框会显示的内容
        	session2.getBasicRemote().sendText(message3);      //lkl的对话框....
        	System.out.println(this.session==session2);
        	System.out.println(toUsername+"在线了！！");
         }
        	
         //System.out.println("@@@@@@@@@@本机ip："+InetAddress.getLocalHost().getHostAddress());  
         
         
         /*webSocketSet.add(this);     //加入set中
         addOnlineCount();           //在线数加1
         System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());*/
     }
 
     /**
      * 连接关闭调用的方法
     * @throws IOException 
      */
     @OnClose
     public void onClose() throws IOException{
    	 String message2="-------------------------抱歉了，"+username+" 不在线！！！-----------------------";
    	 System.out.println(message2);
    	 Session session2 = userSessionMap.get(toUsername+username);
    	 if(session2!=null){
    		 session2.getBasicRemote().sendText(message2);
    	 }
    	 userSessionMap.remove(this.name);
         /*webSocketSet.remove(this);  //从set中删除
         subOnlineCount();           //在线数减1
         System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());*/
     }
 
     /**
      * 收到客户端消息后调用的方法
      * @param message 客户端发送过来的消息
      * @param session 可选的参数
     * @throws IOException 
      */
     @OnMessage
     public void onMessage(String message, Session session) throws IOException {
    	 int index4=message.lastIndexOf('*');
    	 String message1=message.substring(0,index4); //真正要发送的消息  最后显示的消息
    	 
    	 Session myAndHerWebSocket = userSessionMap.get(username+toUsername);
    	 Session herAndMyWebSocket = userSessionMap.get(toUsername+username);
    	 
    	 myAndHerWebSocket.getBasicRemote().sendText(message1);
    	 if(herAndMyWebSocket!=null){
    		 herAndMyWebSocket.getBasicRemote().sendText(message1);
    	 }
    	
         /*System.out.println("来自客户端的消息:" + message);
         //群发消息
         for(WebSocketTest item: webSocketSet){
             try {
                 item.sendMessage(message);
             } catch (IOException e) {
                 e.printStackTrace();
                 continue;
             }
         }*/
     }
 
     /**
      * 发生错误时调用
      * @param session
      * @param error
      */
     @OnError
     public void onError(Session session, Throwable error){
         System.out.println("发生错误");
         error.printStackTrace();
     }
 
     /**
      * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
      * @param message
      * @throws IOException
      */
     public void sendMessage(String message) throws IOException{
    	  //可以在该方法中：把私信记录报存到数据库中   
    	 
         //this.session.getBasicRemote().sendText(message);
     }
 
     /*public static synchronized int getOnlineCount() {
         return onlineCount;
     }
     public static synchronized void addOnlineCount() {
         WebSocketTest.onlineCount++;
     }
     public static synchronized void subOnlineCount() {
         WebSocketTest.onlineCount--;
     }*/
     
     //注释掉的是群发，此处是私信，点对点聊天
 }

