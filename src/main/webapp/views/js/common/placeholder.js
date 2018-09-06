	function isSupportPlaceHolder(){
    	var input = document.createElement("input");
    	return "placeholder" in input;
    }
    if(!isSupportPlaceHolder()){
    	$("input").not("input[type='password']").each(function(){
    			var self = $(this);
    			var val = self.attr("placeholder");
    			input(self,val);
    	});
    }
    function input(obj,val){
    	var $input = obj;
    	var val  = val;
    	$input.attr({value:val});
    	$input.focus(function(){
    		if($input.val()==val){
    			$(this).attr({value:"",style:"color:#000"});
    		}
    	}).blur(function(){
    		if($input.val()==""){
    			$(this).attr({value:val,style:"color:#ccc"});
    		}
    	})
    	
    }