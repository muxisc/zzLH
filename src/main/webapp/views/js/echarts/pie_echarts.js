require(['jquery', 'echarts', 'layer1', 'common/http', 
	'common/util', 'handlebars','zhejiang','common/hbsHelper'],
    function (jquery, echarts, layer, http, util, handlebars) {
    	
	    init();
	    
	    function init(){
	    	//显示饼图
	    	initPieEcharts();
	    	//显示浙江地图
	    	initMapEcharts();
	    }
	    
	    
	    //显示浙江地图
	    function initMapEcharts(){
	    	
	    }
	    
	
	    //显示饼图
	    function initPieEcharts(){
            $.get("/zzLH/lh/Echarts/getPieData", function(data) {
            	
            	var myChart = echarts.init(document.getElementById('pie_echarts'));
    			
            	/*var total = 0;
            	//Map：[{'name':'武侠小说','value':'100'},{'name':'青春校园','value':'300'}]
    			var numMap = data.data.pieDataMap
    			//Object：{'武侠小说':'100','青春校园':'300'}
    			var percentObj = {};
    			//把Map--->Object
    			for(var index in numMap){
    				var key=numMap[index].name;
    				var value=numMap[index].value;
    				percentObj[key]=value;
    				total+=value;
    			}*/
    			
    			myChart.showLoading();
    			var option = {
    			    title:{
    			    	text:'饼图',
    			    	x:'center',
    			    	top:'50'
    			    },		
    				//提示框
    				tooltip : {
    					trigger : 'item',
    					// a（系列名称），b（数据项名称），c（数值）, d（饼图：百分比 ）
    					formatter : "{b}:</br>{c}({d}%)"
    				},
    				//图例
    				legend : {
    					orient : 'vertical',
    					right : '80',
    					top : 'center',
    					itemGap : 10,
    					icon : 'rect',
    					itemWidth : 30,
    					itemHeight : 20,
    					height:'100%',
    					textStyle : {
    						color : 'black'
    					},
    					/*formatter:function(params){
    						return Math.round((percentObj[params]/total)*10000)/100+
    						       "%"+params
    					},*/
    					data : data.data.pieDataMap.map(function(item) {
    						//循环第一次：item = {name: "武侠小说", value: "100"}
    						//循环第二次：item = {name: "青春校园", value: "300"}
    						//debugger;
    						//alert(item.name);
    						return item;
    					})
    				},
    				series : [ {
    					type : 'pie',
    					radius : [ '40%', '60%' ],
    					center : [ '30%', '55%' ],
    					avoidLabelOverlap : true,
    					labelLine : {
    						normal : {
    							show : false
    						}
    					},
    					//图形上的文本标签，可用于说明图形的一些数据信息，比如值，名称等，
    					label : {
    						normal : {
    							show : false,
    							position: 'center'  //显示在饼图中间
    						},
    						//需要显示武侠小说
    		                emphasis: {
    		                    show: true,
    		                    textStyle: {
    		                        fontSize: '30',
    		                        fontWeight: 'bold'
    		                    }
    		                }
    					},
    					data : data.data.pieDataMap.map(function(item) {
    						return item;
    					})
    				} ]
    			};
    			myChart.hideLoading();
    			myChart.setOption(option);     //为echarts对象加载数据
              });
            
           }
})