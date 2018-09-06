require(['component/iframeLayer', 'component/dataTable', 'common/util', 
	     'common/http', 'handlebars', 'jquery','jquery.serialize','laydate',
	     'common/validateRules', 
	     'common/ajaxfileupload'], 
		function (layer, dataTable, util, http,handlebars) {
	
	  init();
	  
	  
	  function init(){
		  formValidate();
		  bind();
	  }
	
	
	  function bind(){
		  util.bindEvents([
			  {
				  el:'#close',
				  event:'click',
				  handler:function(){
					  layer.close();
				  }
			  
		      }
		  ])
	  }
	  
	  //delegate('子元素','事件','')
	  $("#uploadFile").delegate('input','change',function(){
		  //<input type="file">是用选择事件change去触发的，
		  //点击选择课程文件，选择a.pptx文件，就改变file输入框的值了
		  var text=$("#btnFile").val();      //  C:\fakepath\哈嗯.pptx
		  var indexTwo=text.lastIndexOf("\\");  //  11         \是转义字符，后面的才是判断的字符
		  var name=text.substring(indexTwo+1,text.length);      //  哈嗯.pptx
		  
		  uploadFile(name);
	  })
	  
	  //上传课件文件
	  function uploadFile(file){
		  
		//文件名反转    xtpp.嗯哈
	    var file_name = file.toLowerCase().split("").reverse().join("");
	    //找到第一个点的位置
		var fileTypeIndex = file_name.indexOf(".");
		//获取文件类型   pptx
		var fileType =file_name.substring(0,fileTypeIndex).toLowerCase().split("").reverse().join("");
		
		var sp = ["mp4"];     //视频格式
		var yp = ["mp3"];     //音频格式
		var ppt = ["ppt","pptx","pdf","doc","docx","xlsx","zip"];//ppt格式
		
		//获取radio选中值
		if($("input[name='courseForm']:checked").val() == "2"){
			var flagPPT = false;
			for(var i=0;i<ppt.length;i++){
				if(fileType == ppt[i]) 
					flagPPT = true;
			}
			if(!flagPPT){
				layer.msg("请上传格式为ppt,pptx,pdf,doc,docx,xlsx文件", {time: 3000}, function() {});
			    return;
			}
		}
		
		
		//上传文件
		var index = layer.msg('正在上传，请稍后...', {icon: 16, time: -1, shade: [0.4, '#CCC']});
		$.ajaxFileUpload({
            url: '/zzLH/lh/uploadAndDownload/upload',
            type: 'post',
            data: {"fileName":file},                  // 哈嗯.pptx
            secureuri: false,           //一般设置为false
            fileElementId: 'btnFile',   //文件上传空间的id属性   <input type='file' id='btnFile'/>
            dataType: 'json',
            success: function(data){
            	layer.close(index);//关闭加载
            	if(data.result=='NO'){
            		layer.msg("文件上传失败", {time: 2000}, function() {});
            		return;
            	}
            	//把哈嗯.pptx显示在选择课程文件前的输入框
            	$("#fileName").val(file);
            	//把lhafba15bcf93c4580ba3a96cd39ff2b39-哈嗯.pptx保存到数据库filePath中
            	$("#filePath").val(data.fileName);
            },
            error: function(data, status){
            	layer.msg("上传失败，请检查网络及文件大小", {time: 2000}, function() {});
            	layer.close(index);//关闭加载
            	return;
            }
        });
	  }
	  
	  
	  
	  function formValidate(){
		  $("#hxForm").validate({
			  rules:{
				  courseName:{
					  required:true
				  }
			  },
			  messages:{
				  courseName:{
					  required:"课程名称不能为空"
				  } 
			  },
			  onkeyup:false,
	          showErrors:function(errorMap,errorList){
	           	 for(var i in errorMap){
	                 layer.tips(errorMap[i],$('#hxForm input[name='+i+'],textarea[name='+i+']'),{
	                     tips:3,
	                     tipsMore:true,
	                     ltype:0
	                 });
	              }
	          },
	          submitHandler:function(){
	        	  //表单校验
	        	  if($("#filePath").val()==''){
	        		  layer.msg("课件未上传",{time: 3000}, function() {});
	        		  return;
	        	  }
	        	  var formParams=$("#hxForm").serializeObject();
	        	  http.httpRequest({
	        		  url:'/zzLH/lh/uploadAndDownload/addCourseInfo',
	        		  data:formParams,
	        		  serializable: true,
	        		  type:'post',
	        		  success:function(data){
	        			  layer.msg(data.msg,{},function(){
	        				  if(data.status=='success'){
	        					  layer.close({reload:true});
	        				  }
	        			  });
	        		  }
	        	  })
	        	  
	        	  
	          }
	          
	          
		  })
		  
		  
	  }
	
	
	
	
	
	
	
})