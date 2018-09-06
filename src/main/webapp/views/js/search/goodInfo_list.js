require(['component/iframeLayer','component/dataTable','common/util',
         'common/http','handlebars','jquery','jquery.serialize'], 
         function (layer, dataTable, util, http, handlebars) {
	
	         init();
	         
	         
	         function init(){
	        	 initDataTable();
	        	 bind();
	         }
	
	         var table;
	         function initDataTable(){
	        	 
	        	 //用jquery获取模板
	        	 var tpl=$("#tpl").html();
	        	 //预编译模板
	        	 var template=handlebars.compile(tpl);
	        	 
	        	 
	        	 table=dataTable.load({
	        		 el:'#user-table',
	        		 ajax:{
	        			 url:'/zzLH/goodInfo/showUsers',
	        			 data:function(d){
	        				 d.params=$("#user-form").serializeObject()
	        			 }
	        		 },
	        		//需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
	        		 //className：class="center"
	        		 columns:[
	        			 {data: 'goodId',className:'center'},
	        			 {data: 'goodName',className:'center'},
	        			 {data: 'goodClassId',className:'center'},
	        			 {data: 'goodPrice',className:'center'},
	        			 {data: 'goodPlace',className:'center'},
	        		 ]
	        		 
	        	 })
	         }
	         
	         function bind(){
	        	util.bindEvents([
	        		{
		        		el:'#search',
		        		event:'click',
		        		handler:function(){
		        			table.ajax.reload();
		        		}
		        	},{
		        		el:'.js-add',
		        		event:'click',
		        		handler:function(){
		        			//弹小窗
		        			layer.dialog({
		        				title:'添加商品',
		        				area:['628px','360px'],
		        				content:'/zzLH/goodInfo/showAddAndEdit',
		        				callback:function(data){
		        					//{reload:true}    重新加载用户列表数据
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
		        			//获取当前行的该用户的数据     
		        			var data=table.row($(this).closest('td')).data();
		        			layer.dialog({
		        				title:'编辑用户',
		        				area:['628px','500px'],
		        				content:'/zzLH/admin/system/sysuser/showAddAndEdit?uid='+data.uid,
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
		        			var uid=table.row($(this).closest('td')).data().uid;
		        			layer.confirm('确定要删除该用户吗？',{icon:2,title:'提示'},function(index){
		        				http.httpRequest({
		        					url:'/zzLH/admin/system/sysuser/deleteUser',
		        					data:{uid:uid},
		        					success:function(data){
		        						layer.msg(data.msg,{time:500},function(){
		        							if(data.status=='success'){
		        								//重新加载用户列表
		        								table.ajax.reload();
		        							}
		        						})
		        					}
		        				})
		        			});
		        			
		        		}
		        	}
	        	]) 
	         }
	
	
})
