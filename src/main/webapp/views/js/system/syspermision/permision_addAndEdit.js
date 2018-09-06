require(['component/iframeLayer', 'common/util', 'common/http', 
	'common/validateRules', 'layer1', 'jquery.validate', 'jquery.serialize'],
	function (layer, util, http) {

	
	init();
	
	function init(){
		bind();
	}
	
	function bind(){
		util.bindEvents([{
			el:'#cancel',
			event:'click',
		 	handler:function(){
		 		layer.close();
		 	}
		},{
			el:'#save',
			event:'click',
			handler:function(){
				//表单校验
				var permision_name=$("#sysPermisionForm input[name='permision_name']").val();
				var permision_url=$("input[name='permision_url']").val();
				if(permision_name=="" || permision_url==""){
					layer.msg("必填项不能为空",{time:1000},function(){});
					return;
				}
				var reg =/\s/;
				if(reg.test(permision_name)){
					layer.msg("权限名称不能含有空格",{time:1000},function(){});
					return;
				}
				
				var formParam=$("#sysPermisionForm").serializeObject();
				http.httpRequest({
					url:'/zzLH/admin/system/syspermision/doAddAndEdit',
					type:'post',
					data:formParam,
					success:function(data){
						if(data.status=='success'){
							layer.msg(data.msg,{time:500},function(){
								layer.close({reload:true});
								return;
						    })
						}
						
						var errorMsg=data.msg;
						var errors=data.errors;
						if(errors.length>0){
							for(var i=0;i<errors.length;i++){
								errorMsg+="<br/>"+(i+1)+":"+errors[i].field+errors[i].info;
							}
						}
						layer.msg(errorMsg,{time:1000});
						
					}
				})
			}
		}
		])
	}
  

})