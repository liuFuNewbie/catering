<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 员工基本信息  -->
<link
	href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/font-awesome.min93e3.css?v=4.4.0"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/animate.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/styles.css"
	rel="stylesheet">
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
<div id="all">
	<div class="inquiry">

		<form class="navbar-form navbar-right">
			<div class="form-group">
				<label>员工名：</label><input type="text" class="form-control"
					id="empName" name="empName" />
			</div>
			<button type="button" class="btn  btn-primary btn_employee">
				<i><img src="${pageContext.request.contextPath }/img/search.png" /></i>搜索
			</button>
			<span class="increased"><a
				href="${pageContext.request.contextPath }/background/addemployeebasicinfo.jsp"><img
					alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png"><i
					class="increasedName">新增</i></a></span>
		</form>
	</div>
	<div class="tables">
		<table>
		</table>
	</div>
	<div class="pager">
		<ul class="clearfix">

		</ul>
	</div>
</div>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script>
	var empName = "";
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
		doAjax(empName, pageIndex);
		$(".btn_employee").click(function(){
			empName=$("#empName").val().trim();
			doAjax(empName, pageIndex);
		});
		//上一页单击事件
		$(".clearfix").on("click", ".back", function() {
			if (currentPageNo == 1) {
				currentPageNo=1;
				doAjax(empName, currentPageNo);
				return false;
			} else {
				currentPageNo = currentPageNo - 1;
				doAjax(empName, currentPageNo);
			}
		});
		//下一页单击事件
		$(".clearfix").on("click", ".next", function() {
			if (currentPageNo >= totalPageCount) {
				currentPageNo=totalPageCount;
				doAjax(empName, currentPageNo);
			return false;
			} else {
				currentPageNo = currentPageNo + 1;
				doAjax(empName, currentPageNo);
			}
		});
		//页面点击事件
		$(".clearfix").on("click", ".currentPageIndex a", function() {
			var paIndex = $(".clearfix .currentPageIndex a").index(this);
			var patext = $(".clearfix .currentPageIndex a").eq(paIndex).text();
			doAjax(empName, patext);
		});
		//删除单击事件
	 	$("table").on("click", ".del", function() {
	 		 var index = $("table .del").index(this);
	 		var empId = $("table .empId").eq(index).text();
		 		delEmployeeById(empId);
		 	});
	});
	//根据供应商编号删除供应商信息
	function delEmployeeById(empId){
 	
		if (confirm("确定要删除该员工信息吗?") == false) {
			return false;
		} else {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/employee/delEmployeeById.action",
						data : {
							"empId" : empId
						},
						dataType : "json",
						type : "post",
						success : function(data) {
							if (data.delResult == "ok") {
								doAjax(empName, pageIndex);
								alert("该供员工以下文章有信息，不能进行删除！");
 							} else if (data.delResult == "true") {
								doAjax(empName, pageIndex);
								alert("成功删除该员工信息！");
 							} else if (data.delResult == "false") {
								doAjax(empName, pageIndex);
								alert("删除该员工信息失败！");
							}
						}
					});
		}
	};
	function doAjax(empName, pageIndex) {
	
		$
				.ajax({
					url : "${pageContext.request.contextPath }/employee/getEmployeeByOrempNameList.action",
					data : {
						"empName" : empName,
						"pageIndex" : pageIndex
					},
					type : "post",
					dataType : "json",
					success : function(data) {
						totalPageCount = data[1];
						currentPageNo = data[2];
						element = '';
						element += '<tr><td>编号</td><td>姓名</td><td>性别</td><td>出生日期</td><td>联系电话</td><td>地址</td><td>操作</td></tr>';
						$
								.each(
										data[0],
										function(key, val) {
											element += '<tr>';
											element += '<td class="empId">' + val['empId']
													+ '</td>';
											element += '<td class="empName">' + val['empName']
													+ '</td>';
											element += '<td>' + val['gender']
													+ '</td>';
											element += '<td>'
													+ toDate(val['birthdate'])
													+ '</td>';
											element += '<td>' + val['phone']
													+ '</td>';
											element += '<td>' + val['address']
													+ '</td>';
											element += '<td><a href="${pageContext.request.contextPath }/employee/getEmployeeById.action?empId='+val['empId']+'"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a><a  class="del"><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>';
											element += '</tr>';
										});
						$("table").html(element);
						elementPage = '';
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
 						$(".clearfix").html(elementPage);
					},
					error : function(err) {
						alert(err.status);
					}
				});
	}
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
		var m = date.getMonth() + 1;
		m = m < 10 ? '0' + m : m;
		var d = date.getDate();
		d = d < 10 ? ("0" + d) : d;
		var str = y + "-" + m + "-" + d;
		return str;

	}
</script>