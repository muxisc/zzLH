require(['component/iframeLayer','component/dataTable','common/util',
         'common/http','handlebars','jquery','jquery.serialize'], 
         function (layer, dataTable, util, http, handlebars) {
	
	var table;
	init();
	
	function init(){
		initDataTable();
		bind();
	}
	
	function initDataTable(){
		var tpl=$("#tpl").html();
		var template=handlebars.compile(tpl);
		table=dataTable.load({
			el:"#role-table",
			//是否加索引值    第一列必须显示序号
			showIndex: true,
			scrollX: true,
			//lengthMenu: [ 5, 10, 20, 50], 显示 5 项结果 
			ajax:{
				url:"/zzLH/admin/system/sysrole/showRoles",
			},
			columns:[
				{data:null,width: '100px',className:'center'},
				{data:'role_name',className:'center',width: '150px'},
				{data:'role_desc',className:'center',cut:{length:20,replace:'...'}},
			    {data:null,width:'120px',className:'center'}
				],
			/*columnDefs : [
	             //用cut截取的，必须定义columnDefs 
			]*/
			columnDefs : [
				{
					targets:3,
					render:function(data,type,row,meta){
						var content={
								func:[{
									'text':'编辑',
									'class':'btn btn-xs btn-primary js-edit'
								},
								{
									'text':'删除',
									'class':'btn btn-xs btn-primary js-delete'
								}
								]
						};
						return template(content);
					}
				}
			]
		})
	};
	
	function bind(){
		util.bindEvents([
		{
			el:'.js-add',
			event:'click',
			handler:function(){
				layer.dialog({
					title:'新增角色',
					area:['628px','500px'],
					content:"/zzLH/admin/system/sysrole/showAddAndEdit",
					callback:function(data){
						if(data.reload){
    						table.ajax.reload();
    					}
					}
				})
				
			}
		},{
			el:'.js-edit',
			event:'click',
			handler:function(){
				//获取当前行的该角色的数据
				var data=table.row($(this).closest('td')).data();
				layer.dialog({
					title:'编辑角色',
					area:['628px','600px'],
					content:"/zzLH/admin/system/sysrole/showAddAndEdit?uid="+data.uid,
					callback:function(data){
						if(data.reload){
    						table.ajax.reload();
    					}
					}
				})
			}
		},{
			el:'.js-delete',
			event:'click',
			handler:function(){
				//获取当前行的角色数据
				var data = table.row($(this).closest('td')).data();
				layer.confirm("确定删除该角色",{icon: 2, title: '提示'},function(index){
					http.httpRequest({
						url:'/zzLH/admin/system/sysrole/deleteRole',
						data:{uid:data.uid},
						success:function(data){
							layer.msg(data.msg,{time: 500},function(){
								if(data.status=='success'){
									table.ajax.reload();
								}
							});
						}
					});
				});
			}
		}
		])
		
	}
	
	
	
})