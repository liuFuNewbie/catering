var navObj;
$(function(){
	/*删除支付类别信息*/
	$(".delpay").on("click",function(){
		navObj = $(this);
		selectMaterial(navObj);
	});
	
	/*修改商品信息*/
	$(".updpay").on("click",function(){
		alert("哈哈ssss");
		navObj = $(this);
		window.location.href="/member/getMember.action"+navObj.attr("memberId")+"&name="+navObj.attr("memberName");
	});
});
/*在删除支付类别前先查询该类别下是否有支付信息*/
function selectMaterial(obj){
	$.ajax({
		type:"GET",
		url:"material/getMaterialCountById/"+obj.attr("payId")+".action",
		data:'',
		dataType:"text",
		success:function(data){
			if(data == "false"){
				alert(obj.attr("payName")+"支付类别有关联的支付信息，不能删除！");
			}else{
					var r = confirm("确定要删除"+obj.attr("payName")+"支付类别吗？");
					if (r == true) {
						deletePayType(obj);
					}
			}
		},error:function(err){
			alert(err.status);
		}
	});
}

/*删除商品类别*/
function deletePayType(obj){
	$.ajax({
		type:"GET",
		url:"paytype/delPayTypeById/"+obj.attr("payId")+".action",
		data:'',
		dataType:"text",
		success:function(data){
			if(data =="true"){
				obj.parents("tr").remove();
			}
	}
	});
}