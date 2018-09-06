require(['component/iframeLayer',
         'component/dataTable',
         'common/util',
         'common/http',
         'handlebars',
         'jquery','jquery.serialize','placeholder'], 
         function (layer, dataTable, util, http, handlebars) {
	
	     init();
	     
	     
	     function init(){
	    	 //HTML5 会话存储对象 临时保存同一窗口的数据  关闭窗口后删除这些数据  js中sessionStorage调用
	    	 sessionStorage.clear();
	    	 bind();
	     }
	     
	     //回车键
	     //只要你定义了这些键的动作，你在浏览器里按下这些键就会响应，兼容目前所有浏览器。
	     $("#form").keydown(
	    	function(event){
		     	if(event.keyCode==13){   //enter键
		     		event.preventDefault();
		     		$("#search").click();  //要做的事情
		     	}
	        }
	     );
    
	     function bind(){
	    	 util.bindEvents([
	    		 {
	    			 el:'#search',
	    			 event:'click',
	    			 handler:function(){
	    				 //校验
	    				 var inputVal=$("#nameOrUniscid").val();
	    				 if(inputVal==null||inputVal==''||inputVal=='请输入书名、书籍编号、作者、地址等信息搜索'){
	    					 layer.msg("请输入关键字!",{time:1500});
	    					 return;
	    				 }
	    				 var reg=/[~#^$@%&!！*<>:;'"{}【】  ]/gi;
	    				 if(reg.test(inputVal)){
	    					layer.msg("关键字包含空格或特殊字符，请重新输入!",{time:1500});
	    					return;
	    				 }
	    				 //encodeURIComponent用于编码URL中的参数，escape用于编码字符串
	    				 sessionStorage.encode=escape(encodeURIComponent(inputVal));
	    				 location.href='/zzLH/lh/search/commonSearchList?keyword='+escape(encodeURIComponent(inputVal));
	    			 }
	    	     }
	    	 ]);
	     }
});


