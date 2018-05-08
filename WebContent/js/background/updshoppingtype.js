var navName = null;
var navName1 = null;
    $(function(){
	
    	/*提交按钮的点击事件*/
    	$("#btnUpdate").click(function(){
    		navName=$("#navName").val();
    		navName1=$("#navName1").val();
    		if(navName == null || $.trim(navName) == ""){
    			$("#mismark").next().remove();
    			$("#error").append("<span>请输入商品类别名称！</span>");
    			$("#error").css("display","block");	
    			return false;
    			}else{
    				if(navName == navName1){
    					$("#navForm").submit();
    				}else{
    					updateNavigation();
    				}
    			}
    	});
    	
    	/*添加商品类别，若已存在相同的商品类别则给予提示*/
    	function updateNavigation(){
    		navName=$("#navName").val();
    		$.ajax({
    			type:"post",
    			url:"navigation/getNavigationCountByName.action",
    			data:{"navName":navName},
    			dataType:"text",		
    			success:function(data){
    				if(data != null){		
    					if(data == "true"){
    						$("#navForm").submit();
    					}else{
    						$("#mismark").next().remove();
    						$("#error").append("<span>已经存在该商品类别名称！</span>");
    						$("#error").css("display","block");	
    						return false;
    					}
    				}
    			},
    			error: function (err) {
                    alert("ajax错误码:" + err.status);
                }
    		});
    	}
    });