require([ 'component/iframeLayer', 'component/dataTable', 'common/util',
		'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'pagination' ], 
		function(layer, dataTable, util, http, handlebars) {
	
	init();
	
	function init(){
		bind();
	}
	
	function bind(){
		util.bindEvents([
			{
				el:'.goback',
				event:'click',
				handler:function(){
					//返回上一页      详情页-->列表页
					//history.back(-1); 不管点击哪个链接进入详情页，若用这个，都只会返回列表第一页即最初的页面
					//通过在sessionStorage中存储hcsearch：从哪个页面点进去，就返回那一个页面
					if(sessionStorage.hcsearch){
						//从一个字符串中解析出json对象
						var encode=JSON.parse(sessionStorage.hcsearch).encode;
						//当前窗口打开
						window.open('/zzLH/lh/search/commonSearchList?keyword='+encode,'_self');
					}
				}
			
		    }
		])
	}
	
	
	
	
	
	
	
	
	
	
	
})
