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
		    			
		    		},
		    		messages:{
		    			
		    			
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