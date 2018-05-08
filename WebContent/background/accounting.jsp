<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sun/common-one.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/background/baobiao.css" />
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
<div class="content">
	<div class="container">
		<div class="row">
			<div class="inquiry">
				<form class="navbar-form"
					action="${pageContext.request.contextPath }/background/getBusinessExtension.action"
					method="post">
					<div class="form-group">
						<span class="poster"> <label>请输入供应商名称：</label> <input
							type="text" id="supplierName" name="supplierName"
							class="form-control" />
						</span>
					</div>
					<button type="button"
						class="btn btn-primary inquire " id="getBusinessBysupplierName">
						<i><img
							src="${pageContext.request.contextPath }/img/search.png" /></i>搜索
					</button>
					<span class="increasedHead"> <a
						href="${pageContext.request.contextPath }/background/accountingadd.jsp">
							<img alt="新增"
							src="${pageContext.request.contextPath }/img/tianjia.png">
							<i class="raise">新增</i>
					</a>
					</span>
				</form>
			</div>
			<div class="purchaseInfo">
				<table>

				</table>
			</div>
			<div class="pager">
				<ul class="clearfix">

				</ul>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script>
	var supplierName = "";
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
		doAjax(supplierName, currentPageNo);

		//根据供应商名称获取供应商信息列表
		$("#getBusinessBysupplierName").on("click",function(){
			supplierName = $("#supplierName").val().trim();
			doAjax(supplierName, pageIndex);
		});

		//上一页单击事件
		$(".clearfix").on("click", ".back", function() {
			if (currentPageNo == 1) {
				currentPageNo=1;
 				doAjax(supplierName, currentPageNo);
 				return false;
			} else {
				currentPageNo = currentPageNo - 1;
				doAjax(supplierName, currentPageNo);
			}
		});

		//下一页单击事件
		$(".clearfix").on("click", ".next", function() {
			if (currentPageNo >= totalPageCount) {
				currentPageNo=totalPageCount;
				doAjax(supplierName, currentPageNo);
 				return false;
			} else {
				currentPageNo = currentPageNo + 1;
				doAjax(supplierName, currentPageNo);
			}
		});
		//页面点击事件
		$(".clearfix").on("click", ".currentPageIndex a", function() {
			var paIndex = $(".clearfix .currentPageIndex a").index(this);
			var patext = $(".clearfix .currentPageIndex a").eq(paIndex).text();
			doAjax(supplierName, patext);
		});
		//删除单击事件
		$("table").on("click", ".del", function() {
			var index = $("table .del").index(this);
			var businessId = $("table .businessId").eq(index).text();
 			var supplierName = $("table .supplierName").eq(index).text();
			 delBusinessById(businessId,supplierName);
		});
	});
	function doAjax(supplierName, pageIndex) {
		
		$
				.ajax({
					url : "${pageContext.request.contextPath }/background/getBusinessExtension.action",
					type : "post",
					data : {
						"supplierName" : supplierName,
						"pageIndex" : pageIndex
					},
					dataType : "json",
					success : function(data) {
						totalPageCount = data[1];
						currentPageNo = data[2];
						element = '';
						element += '<tr class="title"><td>编号</td><td>供应商名称</td><td>供货日期</td><td>应付款</td><td>已付款</td><td>经手人</td><td>货单备注</td><td>操作</td></tr>';
						$
								.each(
										data[0],
										function(key, val) {
											element += '<tr class="supplierContext">';
											element += '<td class="businessId" style="padding-left: 10px;"> '
													+ val['businessId']
													+ '</td>';
											element += '<td class="supplierName">'
													+ val['supplierName']
													+ '</td>';
											element += '<td >'
													+ toDate(val['createDate'])
													+ '</td>';
											element += '<td >' + val['due']
													+ '</td>';
											element += '<td >'
													+ val['accountPaid']
													+ '</td>';
											element += '<td >' + val['empName']
													+ '</td>';
											element += '<td >' + val['remark']
													+ '</td>';
											element += '<td style="padding-right: 10px;"> <a href="${pageContext.request.contextPath }/background/getBusinessById.action?businessById='
													+ val['businessId']
													+ '"><img title="修改" src="${pageContext.request.contextPath }/img/xiugai.png" /></a>&nbsp;&nbsp;&nbsp;<a class="del"><img title="删除" src="${pageContext.request.contextPath }/img/schu.png" /></a></td>';
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
						alert(err.status + "1");
					}
				});
	};

	function delBusinessById(businessId,supplierName) {
							if (confirm("确定要删除该业务信息吗?") == false) {
								return false;
							} else {
								$
										.ajax({
											url : "${pageContext.request.contextPath}/background/delectBusinessById.action",
											data : {
												"businessId" : businessId
											},
											dataType : "json",
											type : "post",
											success : function(data) {
												if (data.delResult == "true") {
													doAjax(supplierName, pageIndex);
 													alert("成功删除"+supplierName+"业务信息！");
 												} else if (data.delResult == "flase") {
													doAjax(supplierName, pageIndex);
 													alert("删除"+supplierName+"业务信息失败！");
 												}
											}
										});
							}
						
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