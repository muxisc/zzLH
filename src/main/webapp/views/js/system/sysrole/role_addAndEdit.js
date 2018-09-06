require(['common/util', 'component/iframeLayer', 
	     'common/http', 'ztree','ztreeCheck'], 
	function (util, layer, http) {
	
	init();
	
	function init(){
		ztreeInit();
		bind();
	}
	
	//权限树对象
	var treeObj=null;
	//权限树配置
	var treeSetting={
		//1.引入excheck.js 2.配置check   显示节点前面的勾选框
		check: {
            enable: true,
            chkboxType: {Y: "ps", N: "s"}   //勾选时影响父子节点，取消勾选时影响子节点
        },
		view:{
			dblClickExpand: true,
            showLine: true
		},
		data:{
			simpleData:{
				enable:true,
				idKey:'id',            //后台：data.data即nodes：List<PermisionTreeNode>
				pIdKey:'pId',          //PermisionTreeNode：id，pId，name
				rootPId:""
			}
		}
	}

	//选择角色权限
	function ztreeInit(){
		//加载权限资源
		http.httpRequest({
			url:'/zzLH/admin/system/syspermision/showPermisionTree',
			type:'post',
			success:function(data){
				if(data.status=='success'){
					var treeData=data.data;
					//编辑权限时  选中该角色的所有权限
					http.httpRequest({
						url:'/zzLH/admin/system/sysrole/getPermisions',
						data:{roleId:roleId},
						success:function(data){
							var rolePermisions=data.data;
							if(treeData.length>0){
								for(var i=0;i<treeData.length;i++){
									/**
									 * zTree 初始化方法：

		$.fn.zTree.init(t, setting, zNodes)
									 * t:用于展现 zTree 的 DOM 容器
									 * setting:zTree 的配置数据
									 * zNodes:zTree 的节点数据
									 */
									treeData[i].open=true;
									$.each(rolePermisions,function(index,
											value){
										if(value.rp_permision_id==
											treeData[i].id){
											treeData[i].checked=true;
										}
									});
								}
							}
							//初始化权限树
							treeObj=$.fn.zTree.init($("#permisionTree"),
									treeSetting,treeData);
						}
					});
				}
			}
		})
	}
	
	function bind(){
		util.bindEvents([
		{
			el:'#cancel',
			event:'click',
			handler:function(){
				layer.close();
			}
			
		},{
			el:'#save',
			event:'click',
			handler:function(){
				//选择角色权限校验
				//获取所选的所有节点
				var nodes=treeObj.getCheckedNodes(true);
				if(nodes.length<1){
					layer.alert("请至少选择一项权限");
					return false;
				}
				//表单校验
				var role_name=$("input[name='role_name']").val();
				var role_desc=$("textarea[name='role_desc']").val();
				if(role_name==""||role_desc==""){
					layer.msg("必填项不能为空", {time: 1000}, function () {
                    });
					return;
				}
				var reg =/\s/;
				if(reg.test(role_name)){
					layer.msg("角色名称不能含有空格", {time: 1000}, function () {
                    });
					return;
				}
				
				//$.each()遍历json数组
				var arr=[];
				$.each(nodes,function(index,value){
					arr.push(value.id);
				});
				//表单参数  var formParam=$("#sysPermisionForm").serializeObject();
				var formParam={
					uid:$("input[name=uid]").val(),
					role_name:role_name,
				    role_desc:role_desc,
				    permisions:arr
				}
				
				http.httpRequest({
					url:'/zzLH/admin/system/sysrole/saveRole',
	//必须true   否则报错415  因为后台参数@RequestBody SysRoleDto sysRole
					serializable: true,
					type:'post',
					data:formParam,
					success:function(data){
						layer.msg(data.msg, {time: 1000}, function () {
							if(data.status=='success'){
								layer.close({reload:true});
								return;
							}
	                    });
					}
				})
			}
		}
		])
	}
    

})
