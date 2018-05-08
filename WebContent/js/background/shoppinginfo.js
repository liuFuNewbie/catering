//当前页数
var currentPageNo = 0;
//总页数
var totalPageCount = 0;
//请求地址
var path = null;
//节点对象
var element = '';
//菜单编号
var menuId = null;
//菜单名称
var menuName = null;
//创建人名称
var userName = null;
//上一页对象
var pageUp = null;
//下一页对象
var pageDown = null;
//跳转对象
var jump = null;
//保存跳出页数
var jumpPageNo = '';
//搜索对象
var search = null;


/*加载事件*/
$(function(){
	path = "menuAction/getMenuListAjax.action";
	/*显示页面先加载菜谱信息*/
	menuAjax(path);
	/*上一页的点击事件*/
	$(".pager").on('click','.pageUp',function(){
		currentPageNo = $(this).attr("currentPageNo");
		if($(this).attr("usreName") != null && $(this).attr("usreName") !=''){
			userName = $(this).attr("userName");
			alert("userName"+userName);
		}
		menuAjax(path,menuId,menuName,userName,currentPageNo);
	});
	/*下一页的点击事件*/
	$(".pager").on('click','.pageDown',function(){
		currentPageNo = $(this).attr("currentPageNo");
		if($(this).attr("usreName") != null && $(this).attr("usreName") !=''){
			userName = $(this).attr("userName");
		}
		menuAjax(path,menuId,menuName,userName,currentPageNo);
	});
	/*跳转页数点击事件*/
	$(".pager").on('click','.jump',function(){
		currentPageNo = parseInt($(".jumpPage").val());
		jumpPageNo = currentPageNo;
		totalPageCount = parseInt($(this).attr("totalPageCount"));
		if($(this).attr("usreName") != null && $(this).attr("usreName") !=''){
			userName = $(this).attr("userName");
		}
		if($.trim(currentPageNo)==null || $.trim(currentPageNo) == ''){
			alert("请输入要跳转的页数！");
			$(".jumpPage").focus();
			return;
		}else if(isNaN(currentPageNo)){
			alert("输入有误，请输入数字！");
			$(".jumpPage").focus();
			return;
		}else if(currentPageNo > totalPageCount){
			alert("跳转页数不能大于总页数！");
			$(".jumpPage").focus();
			return;
		}else if(currentPageNo == 0){
			alert("跳转页数不存在0！");
			return;
		}
		menuAjax(path,menuId,menuName,userName,currentPageNo);
	});
	/*搜索的点击事件*/
	$(".searchs").on("click",function(){
		var type = $(".searchType").val();
		var postName = $(".postName").val();
		currentPageNo=1;
		if(type==1){
			menuName=null;
			userName=null;
			if(postName == null || postName ==''){
				alert("请输入要搜索的编号！");
				return;
			}else if(isNaN(postName)){
				alert("输入有误，请输入数字类型的编号！");
				return;
			}
			menuId = postName;
		}else if(type==2){
			menuId=null;
			userName=null;
			if(postName == null || postName ==''){
				alert("请输入要搜索的菜名！");
				return;
			}
			menuName = postName;			
		}else if(type==3){
			menuId=null;
			menuName=null;
			if(postName == null || postName == ''){
				alert("请输入要搜索的创建人名称！");
				return;
			}
			userName = postName;			
		}
		menuAjax(path,menuId,menuName,userName,currentPageNo);
	});
	
	/*修改的点击事件*/
	$(".menuTable").on("click",".updMenu",function(){
		window.location.href="menuAction/getMenuById.action?menuId="+$(this).attr("menuId");		
	});
	
	/*删除的点击事件*/
	$(".menuTable").on("click",".delMenu",function(){
		var objMenu = $(this);
		$.ajax({
			type:"GET",
			url:"menuAction/deleteMenuById/"+objMenu.attr("menuId")+".action",
			data:'',
			dataType:"text",
			success:function(data){
				if(data == "true"){
					if(confirm("确定要删除吗？")){
						objMenu.parents("tr").remove();
					}
				}else{
					alert("出现错误！");
				}
			}
		});
	});	
})

/*时间类型转换*/
function toDate(v) {
       var date = new Date();
       date.setTime(v.time);
       var y = date.getFullYear();
       var m = date.getMonth()+1;
       m = m<10?'0'+m:m;
       var d = date.getDate();
       d = d<10?("0"+d):d;
       var str = y+"-"+m+"-"+d;
       return str;
  }
function menuAjax(path,menuId,menuName,userName,currentPageNo){
	$.ajax({
		type:"get",
		url:path,
		data:{"menuId":menuId,"menuName":menuName,"userName":userName,"currentPageNo":currentPageNo},
		dataType:"json",
		success : function(result) {
			totalPageCount = result[1];
			currentPageNo = result[2];
			if(totalPageCount == 0){
				currentPageNo=0;
			}else{
				if(currentPageNo>totalPageCount){
					return;
				}else if(currentPageNo<1){
					return;
				}
			}
			element = '<tr>';
			element += '<td class="number">编号</td>';
			element += '<td class="userName">创建人</td>';
			element += '<td class="shoppingName">名称</td>';
			element += '<td class="typeName">类别名称</td>';
			element += '<td class="math">单价</td>';
			element += '<td class="math">成本</td>';
			element += '<td class="mealName">套餐名称</td>';
			element += '<td class="math">单位</td>';
			element += '<td class="math">打折</td>';
			element += '<td class="typeName">日期</td>';
			element += '<td class="remarks">描述</td>';
			element += '<td class="typeName">操作</td>';
			element += '</tr>';
			$.each(result[0],function(key,val){
				element += '<tr class="menutr">';
				element += '<td>'+val['menuId']+'</td>';
				element += '<td>'+val['userList'][0]['userName']+'</td>';
				element += '<td>'+val['menuName']+'</td>';
				element += '<td>'+val['navigationList'][0]['navName']+'</td>';
				element += '<td>'+val['unitPrice']+'</td>';
				element += '<td>'+val['cost']+'</td>';
				element += '<td>'+val['comboList'][0]['comboName']+'</td>';
				element += '<td>'+val['unit']+'</td>';
				element += '<td>'+val['discount']+'</td>';
				var isoDate = val['dateTime'];
				isoDate = toDate(isoDate);
				element += '<td>'+isoDate+'</td>';
				element += '<td>'+val['describe']+'</td>';
				element += '<td><a class="updMenu" href="javascript:;" menuId='+val['menuId']+'><img title="修改" src="img/zd.png"></a>';
				element += '<a class="delMenu" href="javascript:;" menuId='+val['menuId']+'><img title="删除" src="img/schu.png"></a></td>';
				element += '</tr>';
			});
			$(".menuTable").html(element);
		    if(totalPageCount > 1){
		    	element = '';
		    	element += '<ul class="clearfix"><li>当前页数['+currentPageNo+'/'+totalPageCount+']</li>&nbsp;&nbsp;';
		    	element += '<li><a class="pageUp" href="javascript:;" currentPageNo='+(currentPageNo-1)+' userName='+userName+' menuName='+menuName+'>上一页</a></li>&nbsp;&nbsp;';
		    	element += '<li><a class="pageDown" href="javascript:;" currentPageNo='+(currentPageNo+1)+' userName='+userName+' menuName='+menuName+'>下一页</a></li>&nbsp;&nbsp;';
		    	element += '<li>跳转至&nbsp;&nbsp;<input class="jumpPage" value="'+jumpPageNo+'" name="jumpPage" type="type" ><button class="jump" type="button" value="GO" userName='+userName+' menuName='+menuName+' totalPageCount='+totalPageCount+'>GO</button></li></ul>';
			$(".pager").html(element);
		    }else{
		    	$(".pager").html('');
		    }
		},
		error:function(err){
			alert(err.status);
		}
	});
}