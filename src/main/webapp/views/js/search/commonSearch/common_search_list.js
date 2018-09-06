require(['component/iframeLayer',
         'component/dataTable',
         'common/util',
         'common/http',
         'handlebars',
         'jquery','jquery.serialize','pagination'], 
         function (layer, dataTable, util, http, handlebars) {
	
	     var pageNumber;
	     var encode;
	     init();
	     
	     //回车键
	     //只要你定义了这些键的动作，你在浏览器里按下这些键就会响应，兼容目前所有浏览器。
	     $("#hx-form").keydown(
	    	function(event){
		     	if(event.keyCode==13){   //enter键
		     		event.preventDefault();
		     		$("#search").click();  //要做的事情
		     	}
	        }
	     );
	     
	     
	     function init(){
	    	 if(sessionStorage.hcsearch){   //sessionStorage中的hcsearch不为空，即有值
	    		 //点击详情页上的返回，执行下面
	    		 condition=JSON.parse(sessionStorage.hcsearch);
	    		 $('#keywordType').val(condition.keywordType);
	    		 $('#keyword').val(condition.keyword);
	    		 var hcdpage=condition.hcpage;
	    		 var hcdlength=condition.pageLength;
	    		 //获取当前书籍类型
	    		 var curentType=$(".search-select a[data-val='"+condition.searchSelectType+"']");
	    		 curentType.addClass('cur').siblings().removeClass('cur');
	    		 
	    		 $('#pageLength').val(hcdlength);
	    		 encode=condition.encode;
	    		 build(hcdpage,hcdlength);
	    		 //清除sessionStorage数据
	    		 sessionStorage.clear();
	    		 
	    	 }else{       //一开始通过搜索点击进去，hcsearch是无值的
	    		 $("#pageLength").val("5");
	    		 build(0,5);
	    	 }
	    	 bind();
	     }
	
	     /*
	      * jQuery Pagination分页插件
	      * 是Ajax分页插件，一次性加载，故分页切换时无刷新与延迟
	      */
	     function build(page, length, callback) {
	         var params = [{name: "keywordType", value: $('#keywordType').val()},
	        	           {name:"keyword",value:$('#keyword').val()},
	                       {name:"start",value:page * length},
	                       {name:"length",value:length},
	                       {name:"draw",value:"0"}];
	         http.httpRequest({
	             url: '/zzLH/lh/search/getBookList',
	             type: 'POST',
	             data: params,
	             success: function (data) {
	            	 pageNumber = page;
	                 var itemCount = data.recordsTotal;
	                 if (itemCount != 0) {
	                     $("#search-tip").html('').append('<p class="search-result-p">系统为您找到相关结果约<font color="blue">'+itemCount+'</font>个</p>');
	                     $("#pageforhide").show();
	                     $('.pagination').pagination(itemCount, {
	                         prev_text: '<i class="icon-triangle-left"></i>上一页',
	                         next_text: '下一页<i class="icon-triangle-right"></i>',
	                         num_display_entries: 4, //连续分页主体部分分页条目数
	                         num_edge_entries: 1,//两侧首尾分页条目数
	                         current_page: page,
	                         items_per_page: length,
	                         link_to: 'javascript:void(0)',
	                         ellipse_text: '...',
	                         first_text: '首页',
	                         last_text: '末页',
	                         callback: function (page, jq) {
	                             // page表示当前是第几页（从0开始），length表示每页长度
	                         	 pageNumber = page;
	                         	 //点击第1页和第2页等调用这里
	                             build(page, length);
	                         }
	                     });
	                     //取消dom元素绑定事件
	                     $('.items-page select').unbind('change');
	                     $('.items-page select').on('change',function(){
	                         var num = $('#items-page select option:selected').val();
	                         build(0, num);
	                     });
	                     
	                     var myTemplate=handlebars.compile($("#rstList-template").html());
	                     $("#rstList").html(myTemplate(data));
	                     
	                     $("#notice-total").text(itemCount);
	                     /*var pageNum = itemCount % 10 == 0 ? itemCount / 10 : Math.ceil(itemCount / 10);
	                     $("#notice_pageNum").text(pageNum);*/
	                 } else {
	                	 $('#search-tip').html('').append('<p class="search-result-p">很抱歉，没有找到与<font color="red">'+$('#keyword').val()+'</font> 相关的结果，请重新输入查询条件。</p>');
	                	 $("#pageforhide").hide();
	                	 $("#rstList").html('');
	                 }
	             }
	         });
	     };
	     
	     function bind(){
	    	 util.bindEvents([
	    		 {
		    		 el:'.search-select-a',
		    		 event:'click',
		    		 handler:function(){
		    //$(this).addClass('cur').siblings() 返回其同胞元素	
		    			 $(this).addClass('cur').siblings().removeClass('cur');
		    			 /*$(".cur").removeClass("cur");
		    			 $(this).addClass("cur");*/
		    //<a data-val="">   获取"" 
		    			 $("#keywordType").val($(this).data('val'));
		    			 initSearchList();
		    		 }
	    	     },
	    	     {
	    	    	 el:'#search',
	    	    	 event:'click',
	    	    	 handler:function(){
	    	    		 initSearchList();
	    	    	 }
	    	     },
	    	     {
	    	    	 el:'.company-mc a',
	    	    	 event:'click',
	    	    	 handler:function(){
	    	    		 //点击超链接，缓存数据，进入详情页，
	    	    		 //缓存数据，点击详情页的返回上一页，回到该列表，原本是刷新初始页面
	    	    		 //会调用init():会判断hcsearch是否有值
	    	    		 var keyword=$('#keyword').val();
	    	    		 var keywordType=$("#keywordType").val();
	    	    		 var hcpage=pageNumber;
	    	    		 var pageLength=$("#pageLength").val();
	    	    		 var searchSelectType=$('.cur').data('val');
	    	    		 if(sessionStorage.encode){
	    	    			 //从最初的搜索框进入列表页面，设置encode为传递的keyword参数值
	    	    			 encode=sessionStorage.encode;
	    	    		 }
	    	    		 var jsonObject={keyword:keyword,keywordType:keywordType,searchSelectType:searchSelectType,
	    	    				 hcpage:hcpage,	pageLength:pageLength,encode:encode	 
	    	    		 };
	    	    		 //JSON.stringify()：从一个对象中解析出字符串
	    	    		 //{name:'goatling'}---->'{"name":"goatling"}'
	    	    		 sessionStorage.hcsearch=JSON.stringify(jsonObject);
	    	    		 //对应于JSON.parse()：从一个字符串中解析出json对象
	    	    	 }
	    	     }
	    	 ])
	     };
	     
	     function initSearchList(){
	    	 //表单校验
	    	 var keyword=$("#keyword").val();
             if(keyword==null ||keyword=='' ||keyword=='请输入书名、书籍编号、作者、地址等信息搜索'){
            	 layer.msg("请输入关键字！");
            	 return;
             }
             var reg=/[~#^$@%&!！*<>:;'"{}【】  ]/gi;
             if(reg.test(keyword)){
            	 layer.msg("关键字包含空格或特殊字符，请重新输入!");
            	 return;
             }
             $("#pageLength").val("5");
             build(0,5);
	     }
	
});


