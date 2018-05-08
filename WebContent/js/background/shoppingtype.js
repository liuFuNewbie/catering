var navObj;
$(function(){
	/*删除商品类别信息*/
	$(".shanchu").on("click",function(){
		navObj = $(this);
		selectMenu(navObj);
	});
	
	/*修改商品信息*/
	$(".updnav").on("click",function(){
		navObj = $(this);
		window.location.href="navigation/getNavigation.action?id="+navObj.attr("navId")+"&name="+navObj.attr("navName");
	});
});
/*在删除商品类别前先查询该类别下是否有商品信息*/
function selectMenu(obj){
	$.ajax({
		type:"GET",
		url:"menuAction/getMenuCountByNavId/"+obj.attr("navId")+".action",
		data:'',
		dataType:"json",
		success:function(data){
			if(data.selResult == "true"){
				alert(obj.attr("navName")+"类别有关联的商品信息，不能删除！");
			}else{
					var r = confirm("确定要删除"+obj.attr("navName")+"类别吗？");
					if (r == true) {
						deleteNavigation(obj);
					}
			}
		}
	});
}

/*删除商品类别*/
function deleteNavigation(obj){
	$.ajax({
		type:"GET",
		url:"navigation/delNavigationById/"+obj.attr("navId")+".action",
		data:'',
		dataType:"json",
		success:function(data){
			if(data.delResult=="true"){
				obj.parents("tr").remove();
			}
	}
	});
}