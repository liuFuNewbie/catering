 $(function(){
    	$.ajax({  
            url: "../purchaseAction/getAllPurchase.action",  
            type: "POST",  
            dataType:"json",   
            success: function(data){
            	showPur(data);
            }
    	});//加载页面显示数据
    	
    	$(".btn").on("click",function(){
    		var postName = $("#postName").val();
    			$.ajax({
    				url: "../purchaseAction/getAllPurchase.action",
    				data:{"shoppingName":postName},
    		        type: "POST",  
    		        dataType:"json",   
    		        success: function(data){
    		            showPur(data);
    		        }
    			});
    	});//搜索按钮
    	
    	
    	var purObj = null;
		$(".purinfo").on("click",".deletePur",function(){
			purObj = $(this);
			if(confirm("确定删除该编号为:"+purObj.attr("purchaseId")+"  名称为： 《"+purObj.attr("shoppingName")+"》 商品吗？")){
			   deleteByPurId(purObj);
			}
		});//询问是否删除
		
		function deleteByPurId(Obj){//删除数据库数据
			$.ajax({
				type:"GET",
				url:"../purchaseAction/delpurId/"+Obj.attr("purchaseId")+".action",
				data:'',
				dataType:"text",
				success:function(data){
					if(data == "true"){
						Obj.parents("tr").remove();
					}
				}
			});
		}
    	
    	
		//访问修改页面
		$(".purinfo").on("click",".modifyPur",function(){
			var obj = $(this);
			window.location.href="../purchaseAction/getupdatepur.action?purchaseId="+obj.attr("purchaseId");
		});
    	
    	
    	//显示数据
		function showPur(data){
		   $(".purtr").remove();
			var $str = "";
			for(var num=0;num<data.list.length;num++){
				 $str+="<tr class='purtr'><td>"+data.list[num].purchaseId+"</td>"	
				 $str+="<td>"+data.list[num].shoppingName+"</td>"
				 $str+="<td>"+data.list[num].number+"</td>"
				 $str+="<td>"+data.list[num].unit+"</td>"
				 $str+="<td>"+data.list[num].money+"</td>"
				 $str+="<td>"+dateFormat(data.list[num].createDate)+"</td>"
				 if(data.list[num].state == 0){
				 $str+="<td>未交付</td>"
				 }
				 if(data.list[num].state == 1){
					 $str+="<td>已交付</td>"
				 }
				 $str+="<td><a class='modifyPur' href='javascript:;' purchaseId = '"+data.list[num].purchaseId+"' shoppingName = '"+data.list[num].shoppingName+"'><img title='修改' src='../img/xiugai.png' /></a>&nbsp;&nbsp;&nbsp;<a class='deletePur' href='javascript:;' purchaseId = '"+data.list[num].purchaseId+"' shoppingName = '"+data.list[num].shoppingName+"'><img title='删除'src='../img/schu.png' /></a></td></tr>"
			}
			$(".purinfo").append($str);
		}
		
		//时间转换
		function dateFormat(longTypeDate){  
		    var dateType = "";  
		    var month = "";  
		    var day = "";  
		    var date = new Date();  
		    date.setTime(longTypeDate); 
		    month = date.getMonth() + 1; //getMonth()得到的月份是0-11  
		    if(month<10){  //如果月份小于10月前面补个0
		        month = "0" + month;  
		    }  
		    day = date.getDate();  
		    if(day<10){  //如果天数小于10天数前补0
		        day = "0" + day;  
		    }  
		    dateType = date.getFullYear()+"-"+month+"-"+day;//yyyy-MM-dd格式日期
		    return dateType;
		} //时间long类型转换date类型
    });//加载