require(['common/util', 
	     'layer1', 
	     'common/http', 
	     'jquery.validate', 
	     'jquery',
	     'jquery.serialize'], 
function (util, layer, http) {
	
	
	init();
	
	
	function init(){
		formValid();
		//bind();
	}
	
	//登录表单校验
	function formValid(){
		$("#login-form").validate({
			showErrors : function(errorMap, errorList) {
				for ( var i in errorList) {
					layer.msg(errorList[i].message);
					break;
				}
			},
			onkeyup : false,
			onfocusout : false,
			onsubmit : true,
			rules:{
				username:{
					required:true,
					rangelength:[2,10]
				},
				password:{
					required:true,
					rangelength:[5,12]
				}/*,
				checkCode:{
					required:true
				}*/
			},
			messages:{
				username:{
					required:'用户名不能为空',
					rangelength:'用户名长度必须在{0}到{1}之间'
				},
				password:{
					required:'密码不能为空',
					rangelength:'密码长度必须在{0}到{1}之间'
				}/*,
				checkCode:{
					required:'验证码不能为空'
				}*/
				
			},
			submitHandler:function(form){
				//这里的form就是"#login-form"
				var formParam=$(form).serializeObject();
				http.httpRequest({
					url:'/zzLH/admin/login',
					type:'post',
					data:formParam,
					success:function(data){
						if(data.status=='success'){
							alert(data.msg);
							alert("成功登录");
							//登录成功跳转到后台首页
							location.assign("/zzLH/admin/index");
							
						}else{
							alert(data.msg);
							//页面F12--Network--Response
//{"status":"fail","msg":"后台参数验证错误","errors":[{"field":"username","info":"登录用户名必须在5~8之间"},{"field":"password","info":"登录密码必须在7~10之间"}]}							
							//前台显示注解校验错误的信息   js中的增强for循环
							var errorsList=data.errors;
							for(var error in errorsList){
								alert(errorsList[error].info);
							}
							alert("登录失败");
						}
						
					}
					
				})
				
			}
			
		})
	}
	
	
	
	
	
})