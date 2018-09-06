require(['component/iframeLayer', 'common/util', 'common/http', 'common/validateRules', 
	     'layer1', 'jquery.validate', 'jquery.serialize'], 
		 function (layer, util, http) {

		    init();
		
		   
		
		    function init() {
		        bind();
		        formValid();
		    }
		
		    //表单校验
		    function formValid(){
		    	$("#sysUserForm").validate({
		    		rules:{
		    			user_username:{
		    				required:true,
		    				rangelength:[2,10]
		    			},
		    			user_password:{
		    				rangelength:[5,12]
		    			},
		    			user_real_name:{
		    				required:true,
		    				rangelength:[2,8]
		    			},
		    			user_email:{
		    				required:true
		    			},
		    			user_phone:{
		    				required:true,
		    				checkMobile:true
		    			}
		    		},
		    		messages:{
		    			user_username:{
		    				required:'登录用户名不能为空',
		    				rangelength:'登录用户名长度必须是{0}到{1}之间'
		    			},
		    			user_password:{
		    				rangelength:'登录密码长度必须是{0}到{1}之间'
		    			},
		    			user_real_name:{
		    				required:'姓名不能为空',
		    				rangelength:'姓名长度必须是{0}到{1}之间'
		    			},
		    			user_email:{
		    				required:'电子邮件不能为空',
		    			},
		    			user_phone:{
		    				required:'手机号码不能为空',
		    				checkMobile:'手机号码格式不正确'
		    			}
		    			
		    		},
		    		showErrors: function (errorMap, errorList) {
		                for (var i in errorMap) {
		                    layer.tips(errorMap[i], $('#sysUserForm input[name=' + i + ']'), {
		                        tips: 3,
		                        tipsMore: true,
		                        ltype: 0
		                    });
		                }
		            },
		            submitHandler:function(){
		            	//邮箱验证   
		            	//test()方法用于检测一个字符串是否匹配某个模式.   RegExpObject.test(string)
		            	var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		            	var email=$("#sysUserForm input[name='user_email']").val();
		            	if(!reg.test(email)){
		            		layer.msg("邮箱格式不正确",{time:2000},function(){});
		            		//focus()方法表示将输入焦点移至该对象上
		            		$("#sysUserForm input[name='user_email']").focus();
		            		return;
		            	}
		            	
		            	var formParam=$("#sysUserForm").serializeObject();
		            	http.httpRequest({
		            		url:'/zzLH/admin/system/sysuser/saveUser',
		            		serializable:true,
		            		data:formParam,
		            		type:'post',
		            		success:function(data){
		            			layer.msg(data.msg,{time:2000},function(){
		            				if(data.status=='fail'){
		            					var errors=data.errors;
		            				    for(var i in errors){
		            				    	layer.msg(errors[i].info);
		            				    }
		            					return;
		            				}
		            				if(data.status=='success'){
		            					//关闭弹窗  给callback一个data：reload:true
			            				layer.close({reload:true});
			            			}
		            			})
		            		}
		            	})
		            }
		    		
		    	})
		    }
		    
		
		    function bind() {
		        util.bindEvents([
		        	{
			        	el:'#cancel',
			        	event:'click',
			        	handler:function(){
			        		//关闭弹窗
			        		layer.close();
			        	}
		            }
		        ])
		    }
    
    

})