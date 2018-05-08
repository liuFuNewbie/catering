var payName = null;
var payName1 = null;
    $(function(){
	
    	/*提交按钮的点击事件*/
    	$("#btnUpdate").click(function(){
    		payName=$("#payName").val();
    		payName1=$("#payName1").val();
    		if(payName == null || $.trim(payName) == ""){
    			$("#mismark").next().remove();
    			$("#error").append("<span>请输入支付类别名称！</span>");
    			$("#error").css("display","block");	
    			return false;
    			}else{
    				if(payName == payName1){
    					$("#payForm").submit();
    				}else{
    					updateNavigation();
    				}
    			}
    	});
    	
    	/*添加商品类别，若已存在相同的商品类别则给予提示*/
    	function updateNavigation(){
    		payName=$("#payName").val();
    		$.ajax({
    			type:"post",
    			url:"paytype/getPayTypeCountByName.action",
    			data:{"payName":payName},
    			dataType:"text",
    			success:function(data){
    				if(data != null){		
    					if(data == "true"){
    						$("#payForm").submit();
    					}else{
    						$("#mismark").next().remove();
    						$("#error").append("<span>已经存在该支付类别名称！</span>");
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