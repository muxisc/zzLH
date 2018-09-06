require(['component/iframeLayer',
         'component/dataTable',
         'common/util',
         'common/http',
         'handlebars',
         'jquery','jquery.serialize','laydate'], 
  function (layer, dataTable, util, http, handlebars) {
	
	var table;
    init();
    
    function init() {
        initDataTable();
        bind();
    }



    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#hx-table',
            showIndex: true,
    		scrollX: true,
    		aLengthMenu: [5,10,20,50,100],
            ajax: {
                url:'/zzLH/lh/uploadAndDownload/doGetLoadPage',
                data:function(d){
                	d.params = $("#hxForm").serializeObject();
                }
            },
            columns: [
                {data: null,defaultContent: 1,className:'center'},
                {data: null,className:'center'},
                {data: 'courseName',className:'center'},
                {data: 'courseForm',className:'center'}
            ],
            columnDefs: [
            	   {
					    targets: 1,
					    render: function (data, type, row, meta) {
					        return "<a href='javascript:void(0)' class='downloadFile' id='"+row.filePath+"'>查看上传文件(下载文件)</a>";
					    }
					},
					{
					    targets: 3,
					    render: function (data, type, row, meta) {
					        if(row.courseForm == '0')
					        	return "视频";
					        if(row.courseForm=='1')
					        	return "音频";
					        if(row.courseForm=='2')
					        	return "PPT";
					    }
					}
				
            ]
        })
        table.on('xhr.dt',function(e,settings,json,xhr){
        	if(json != null){
        		if(json.recordsTotal < 6){
        			$('.dataTables_wrapper .bottom').hide();
    			}else{
    				$('.dataTables_wrapper .bottom').show();
    			}
        	}else{
        		$('.dataTables_wrapper .bottom').hide();
        	}
    		
        })
    }
    
    function bind(){
        util.bindEvents([ 
	        {
	        	el:'#addCourse',
	        	event:'click',
	        	handler:function(){
	        		layer.dialog({
	                    title: '视频/音频/PPT上传',
	                    area: ['60%', '70%'],
	                    content: '/zzLH/lh/uploadAndDownload/enterUploadPage',
	                    callback: function (data) {
	                        if (data.reload==true) {
	                            table.ajax.reload();
	                        }
	                       
	                    }
	                })
	        	}
	        },
	        {
	        	el:'.downloadFile',
	        	event:'click',
	        	handler:function(){
	        		alert("下载文件");
	        		var filePath=this.id;
                    location.href='/zzLH/lh/uploadAndDownload/download?fileName='+filePath;	        		
	        	}
	        },{
	        	el:'#exportData',
	        	event:'click',
	        	handler:function(){
	        		location.href='/zzLH/lh/uploadAndDownload/exportDataToExcel';
	        	}
	        },{
	        	el:'#downloadAll',
	        	event:'click',
	        	handler:function(){
	        		//该页的全部下载  ：把多个文件打包成.zip再下载 ，即打包下载
	        		//获取类名一样的，都是class=downloadFile的超链接
	        		var allFilePathA=new Array();
	        		allFilePathA=$(".downloadFile");
	        		
	        		var jsonArray=new Array();
	        		allFilePathA.each(function(key,value){
	        			//获取每个超链接的id值
	        			var filePath=$(this).attr("id");
	        			jsonArray.push(filePath);
	        		});
	        		//把json数组：[]--->字符串：'[]'---->传递给后台
	        		var allFilePathString=JSON.stringify(jsonArray);    //["lh7921cb54e018409e8c287160262fa599-sf.xlsx","lhfa24ae72e2094022923d93c3324095f4-jy哈哈.pptx"]
	        		
	        		location.href='/zzLH/lh/uploadAndDownload/downloadAll?fileNameArray='+allFilePathString;        		
	        	}
	        }
        ])
    }
    
});


