<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商品详细信息页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/background/baobiao.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/background/supplier.css" />
<style type="text/css">
.pager {
	position: absolute;
	top: 315px;
	left: 500px;
}

.currentPage {
	background-color: #cdcdcd !important;
	color: white;
}

.currentPage:hover {
	color: white;
}
</style>
</head>

<body>
	<div class="shoppinginfo">
		<div class="inquiry">
			<form class="navbar-form">
				<div class="form-group">
					<span class="poster"> <select name="type" id="type"
						class="form-control">
							<option value="0">请选择</option>
							<option value="1">商品编号</option>
							<option value="2">菜名</option>
							<option value="3">创建人</option>
					</select> <input type="text" id="postName" name="postName"
						class="form-control" />
					</span>
				</div>
				<button type="button"
					class="btn  btn-primary getMaterialinfoByTypeAndPost">
					<i><img
						src="${pageContext.request.contextPath }/img/search.png" /></i>搜索
				</button>
				<span class="increasedHead"> <a
					href="${pageContext.request.contextPath }/background/addmaterialinfo.jsp">
						<img alt="新增"
						src="${pageContext.request.contextPath }/img/tianjia.png"> <i
						class="raise">新增</i>
				</a>
				</span>
			</form>
		</div>
		<div class="info">
			<table class="discolorationNumber">

			</table>
		</div>
		<div class="pager">
			<ul class="clearfix">
			</ul>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script>
		//名称
		var postName ;
		//下拉框选择类型
		var type ;
		//分页信息
		var pageIndex = null;
		//总页数
		var totalPageCount = 0;
		//当前页数
		var currentPageNo = 1;
		//创建元素节点
		var element;
		var elementPage;
		//提示语句
		var back;
		$(function() {
			doAjax(type, postName, currentPageNo);
			
			//查询按钮事件
			$(".getMaterialinfoByTypeAndPost").click(function() {
				type = $("#type").val();
				postName = $("#postName").val().trim();
				doAjax(type, postName, pageIndex);
			});

			//上一页单击事件
			$(".clearfix").on("click", ".back", function() {
				if (currentPageNo == 1) {
					currentPageNo=1;
 					doAjax(type, postName, currentPageNo);
 					return false;
				} else {
					currentPageNo = currentPageNo - 1;
					doAjax(type, postName, currentPageNo);
				}
			});
			
			//下一页单击事件
			$(".clearfix").on("click", ".next", function() {
				if (currentPageNo >= totalPageCount) {
					currentPageNo=totalPageCount;
					doAjax(type, postName, currentPageNo);
 					return false;
				} else {
					currentPageNo = currentPageNo + 1;
					doAjax(type, postName, currentPageNo);
				}
			});

			//页面点击事件
			$(".clearfix").on("click", ".currentPageIndex a", function() {
				var paIndex = $(".clearfix .currentPageIndex a").index(this);
				var patext = $(".clearfix .currentPageIndex a").eq(paIndex).text();
				doAjax(type, postName, patext);
			});
			
			//删除单击事件
			$("table").on("click", ".del", function() {
				var index = $("table .del").index(this);
				var materialId = $("table .materialId").eq(index).text();
				delMaterialinfoById(materialId);
 			});
		});

		function doAjax(type, postName, pageIndex) {
		
			$
					.ajax({
						url : "${pageContext.request.contextPath }/material/getMaterial.action",
						type : "post",
						data : {
							"type" : type,
							"postName" : postName,
							"pageIndex" : pageIndex
						},
						dataType : "json",
						success : function(data) {
							totalPageCount = data[1];
							currentPageNo = data[2];
							element = '';
							element += ' <tr><td class="number">编号</td><td class="userName">创建人</td><td class="shoppingName">原料名称</td><td class="typeName">类别名称</td><td class="math">成本</td><td class="math">单位</td><td class="typeName">支付方式名称</td><td class="math">数量</td><td class="eatNumber">结账金额</td><td class="math">库存</td><td class="typeName">日期</td><td class="remarks">描述</td><td class="typeName">操作</td></tr>  ';
							$
									.each(

											data[0],
											function(key, val) {
												element += '<tr class="supplierContext">';
												element += '<td class="materialId" > '
														+ val['materialId']
														+ '</td>';
												element += '<td class="userName">'
														+ val['userName']
														+ '</td>';
												element += '<td >'
														+ val['materialName']
														+ '</td>';
												element += '<td >'
														+ val['navName']
														+ '</td>';
												element += '<td >'
														+ val['cost'] + '</td>';
												element += '<td >'
														+ val['unit'] + '</td>';
												element += '<td >'
														+ val['payName']
														+ '</td>';
												element += '<td >'
														+ val['number']
														+ '</td>';
												element += '<td >'
														+ val['totalMoney']
														+ '</td>';
												element += '<td >'
														+ val['inventory']
														+ '</td>';
												element += '<td >'
														+ toDate(val['dateTime'])
														+ '</td>';
												element += '<td >'
														+ val['describe']
														+ '</td>';
												element += '<td> <a href="${pageContext.request.contextPath }/material/getMaterialById.action?materialId='+val['materialId']+'"><img title="修改" src="${pageContext.request.contextPath }/img/xiugai.png" /></a>&nbsp;&nbsp;&nbsp;<a class="del"><img title="删除" src="${pageContext.request.contextPath }/img/schu.png" /></a></td>';
												element += '</tr>';
											});
							$("table").html(element);
							elementPage = "";
							elementPage += '<li>当前页码：[' + currentPageNo + "/"
									+ totalPageCount
									+ ']</li>&nbsp;&nbsp;&nbsp;&nbsp;';
 							if (currentPageNo == 1) {
 								elementPage += '<li  style="position: relative;top: 3px;"><a class="currentPage">上一页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;';
							} else {
								elementPage += '<li  style="position: relative;top: 3px;"><a  class="back">上一页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;';
							}
							if (totalPageCount <= 4) {
								currNo(1, totalPageCount);
							} else {
								if (currentPageNo <= 2) {
									currNo(1, 4);
								} else if (currentPageNo < totalPageCount - 2) {
									currNo(currentPageNo - 2, currentPageNo + 2);
								} else {
									currNo(totalPageCount - 3, totalPageCount);
								}
							}
							if (currentPageNo == totalPageCount) {
								elementPage += '<li  style="position: relative;top: 3px;"><a class="currentPage">下一页</a></li>';
							} else {
								elementPage += '<li  style="position: relative;top: 3px;"><a class="next">下一页</a></li>';
							}
 							$(".pager ul").html(elementPage);
						},
						error : function(err) {
							alert("出错状态：" + err.status);
						}
					});
		};
		
		function currNo(start, end) {
			for (var i = start; i <= end; i++) {
				if (i == currentPageNo) {
					elementPage += '<li class="currentPageIndex"><a class="currentPage">' + i + '</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				} else {
					elementPage += '<li class="currentPageIndex"><a>' + i + '</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				}
			}
		}
	  function delMaterialinfoById(materialId) {
  								if (confirm("确定要删除该记录信息吗?") == false) {
									return false;
								} else {
									$
											.ajax({
												url : "${pageContext.request.contextPath}/material/deleteMaterialById.action",
												data : {
													"materialId" : materialId
												},
												dataType : "json",
												type : "post",
												success : function(data) {
													if (data.delResult == "true") {
 														 doAjax(type, postName, pageIndex);
 														alert("成功删除信息！");
  													} else if (data.delResult == "flase") {
  														 doAjax(type, postName, pageIndex);
  														alert("删除信息失败！");
  													}
												}
											});
								}
						
		}  	
	  function toDate(str) {
		       var date = new Date();
		       date.setTime(str.time);
		       var y = date.getFullYear();
		       var m = date.getMonth()+1;
		       m = m<10?'0'+m:m;
		       var d = date.getDate();
		       d = d<10?("0"+d):d;
		       var str = y+"-"+m+"-"+d;
		       return str;

		  }
	</script>
</body>
</html>
