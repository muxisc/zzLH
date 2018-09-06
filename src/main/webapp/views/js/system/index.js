require(
    ['component/iframeLayer', 'common/util', 'jquery', 'common/validateRules',
      'metisMenu',
      'jquery.layout', 'jquery.nanoscroller'], function (layer, util) {

      init();
    	
      function init(){
    	  initMenu();
    	  bind();
      }
      
      
      function initMenu(){
    	  //metisMenu 是个Bootstrap 3 风格的 jQuery 菜单插件，允许用户创建类似手风琴效果的可折叠菜单，允许自动折叠效果。
    	  $("#side-menu").metisMenu();
      }
    	
      function bind(){
    	  util.bindEvents([{
    		  el:'.J_menuItem',
    		  event:'click',
    		  handler:function(){
    			    //class='nav-second-level'  标签名称  li  a  获取了ul下的li下的a元素
    			    $('.nav-second-level li a').removeClass('cur');
    	            $(this).addClass('cur');
                    
    	            $('.J_menuTab').show();
    	            $('.J_mainContent').removeClass('pdt0');
    	            //$().find()  查找子元素
    	            $('.J_menuTab').find('.third-nav').text($(this).text());
    	            //closest()函数会首先检查当前元素是否匹配，如果匹配则直接返回元素本身。如果不匹配则向上查找父元素，一层一层往上，直到找到匹配选择器的元素。如果什么都没找到则返回一个空的jQuery对象。
    	            $('.J_menuTab').find('.second-nav').html($(this).closest(
    	                '.nav-second-level').prev('a').text() + ' &gt;');

    	            var address = $(this).attr('href');
    	            //点击用户管理 把iframe的src改成用户url 用户页面显示在内容部分
    	            var iframe = '<iframe class="J_iframe" width="100%" height="100%" src="'
    	                + address + '" frameborder="0" seamless></iframe>';
    	            $('.J_mainContent').html('').append(iframe).attr('src', address);

    	            return false;
    			  
    		  }
    	  }]);
      }
      
      
})