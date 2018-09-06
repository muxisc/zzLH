require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 
	'layer1', 'ztree'], function (util, layer, http, handlebars) {
    
	
	init();
	
	function init(){
		ztreeInit();
		bind();
	}
	//权限树对象
	var treeObj=null;
	//权限树配置
	var treeSetting={
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
		},
		callback:{
			onClick:function(event,treeId,treeNode){
				//点击某个权限节点 显示在showArea区域
				var parentNode=treeNode.getParentNode();
				showPermision(treeNode.id,parentNode);
			}
		}
	}
	
	function ztreeInit(){
		//加载权限资源
		http.httpRequest({
			url:'/zzLH/admin/system/syspermision/showPermisionTree',
			type:'post',
			success:function(data){
				if(data.status=='success'){
					/**
					 * zTree 初始化方法：$.fn.zTree.init(t, setting, zNodes)
					 * t:用于展现 zTree 的 DOM 容器
					 * setting:zTree 的配置数据
					 * zNodes:zTree 的节点数据
					 */
					//初始化权限树
					treeObj=$.fn.zTree.init($("#permisionTree"),treeSetting,data.data);
					
					//把单个权限数据显示在showArea区域
					showPermision();
				}
			}
			
		})
	}
	
	
	//初始化权限显示 模板
	var viewTemplate=handlebars.compile($("#viewTemplate").html());
	/**
	 * 显示单个权限数据
	 */
	function showPermision(id,parentNode){
		if(!id){   //!id 即表示id为null    点击menus菜单中的权限管理
			$("#showArea").html(viewTemplate());
			return;
		}

		//加载该权限资源   点击某个权限节点，传递该节点id和父亲节点
		http.httpRequest({
			type:"post",
			url:"/zzLH/admin/system/syspermision/selectByUid",
			data:{uid:id},
			success:function(data){
				if(data.status=='success'){
					var context=data.data;
					context.parentName="----";
					if(parentNode){   //parentNode不为空  即有父节点
						context.parentName=parentNode.name;
					}
					context.permision_type=context.permision_type=='1'?'菜单权限':'操作权限';
					//展示该权限资源
					$("#showArea").html(viewTemplate(context));
				}
			}
		})
		
	}
	//获取所选中的权限id
	function getFirstSelectedId(){
		var id;
		if(treeObj){
			var nodes=treeObj.getSelectedNodes();
			if(nodes.length>0){
				id=nodes[0].id
			}
		}
		return id;
	}
	
	function bind(){
		util.bindEvents([{
			el:'#addBtn',
			event:'click',
			handler:function(){
				//获取所选中的权限id
				var sid=getFirstSelectedId();
				if(!sid){
					layer.msg('请选择要增加的权限的位置',{time:500});
					return;
				}
				
				layer.dialog({
					title:'新增权限',
					area:['628px', '500px'],
					content:'/zzLH/admin/system/syspermision/showAddAndEdit?sid='+sid,
					callback:function(data){
						if(data.reload){
							ztreeInit();
						}
					}
				})
				
			}
		},{
			el:'#editBtn',
			event:'click',
			handler:function(){
				var id=$("#id").val();
				if(!id){
					layer.msg("请选择需要修改的权限",{time:1000});
					return;
				}
				layer.dialog({
					title:'修改权限',
					area:['628px', '500px'],
					content:"/zzLH/admin/system/syspermision/showAddAndEdit?id="+id,
					callback:function(data){
						if(data.reload){
							layer.close();
							ztreeInit();
						}
					}
				});
			}
		},{
			el:'#delBtn',
			event:'click',
			handler:function(){
				var id=$("#id").val();
				if(!id){
					layer.msg("请选择要删除的权限",{time:1000});
					return;
				}
				layer.confirm("确定要删除该权限吗？",{icon:2,title:'提示'},function(index){
					http.httpRequest({
						type:'post',
						url:'/zzLH/admin/system/syspermision/deletePermision',
						data:{uid:id},
						success:function(data){
							if(data.status=='success'){
								layer.msg(data.msg,{time:1000},function(){
									ztreeInit();
								});
								return;
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
					});
				});
			}
		},{
			el:'#reloadBtn',
			event:'click',
			handler:function(){
				http.httpRequest({
					url:"/zzLH/admin/system/syspermision/reload",
					type:"GET",
					success:function(data){
						alert(666);
					}
				})
			}
		}
		])
	}
	
})