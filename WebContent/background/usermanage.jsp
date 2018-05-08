<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 用戶管理 -->
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/background/baobiao.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/background/supplier.css" />
<style>
.inquiry {
	border: 1px solid transparent;
	margin: 10px 0px;
}
 
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
				<label>用户名：</label> <input type="text" class="form-control"
					id="userName" name="userName" />
			</div>
			<button type="button" class="btn btn-primary " id="getUserByUserName">
				<i><img src="${pageContext.request.contextPath }/img/search.png" /></i>搜索
			</button>
			<span class="increased"><a
				href="${pageContext.request.contextPath }/background/addusermanage.jsp"><img
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
	var userName = "";
	var currentPageNo = 1;
	//分页信息
	var pageIndex = null;
	var totalPageCount = 0;
	var element = ""; //添加节点
	var elementPage;
	var back = ""; //提示语句
	var str = "";
	$(function() {
		doAjax(userName, currentPageNo);
		//上一页单击事件
		$(".clearfix").on("click", ".back", function() {
			if (currentPageNo == 1) {
				currentPageNo=1;
 				doAjax(userName, currentPageNo);
 				return false;
			} else {
				currentPageNo = currentPageNo - 1;
				doAjax(userName, currentPageNo);
			}

		});
		//下一页单击事件
		$(".clearfix").on("click", ".next", function() {
			if (currentPageNo >= totalPageCount) {
				currentPageNo = totalPageCount;
				doAjax(userName, currentPageNo);
				return false;
			} else {
				currentPageNo = currentPageNo + 1;
				doAjax(userName, currentPageNo);
			}
		});
		//页面点击事件
		$(".clearfix").on("click", ".currentPageIndex a", function() {
			var paIndex = $(".clearfix .currentPageIndex a").index(this);
			var patext = $(".clearfix .currentPageIndex a").eq(paIndex).text();
			doAjax(userName, patext);
		});
		//搜索按钮单击事件
		$(".inquiry").on("click", "#getUserByUserName", function() {
			userName = $("#userName").val().trim();
			doAjax(userName, currentPageNo);
		});

		//删除单击事件
		$("table").on("click", ".del", function() {
			var index = $("table .del").index(this);
			var userId = $("table .userId").eq(index).text();
			delUserById(userId, userName);
		});
	});
	//根据供应商编号删除供应商信息
	function delUserById(userId, userName) {

		if (confirm("确定要删除该用户信息吗?") == false) {
			return false;
		} else {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/userAction/delUserById.action",
						data : {
							"userId" : userId
						},
						dataType : "json",
						type : "post",
						success : function(data) {
							if (data.delUserResult == "ok") {
								doAjax(userName, pageIndex);
								alert("该用户以下文章有信息，不能进行删除！");
							} else if (data.delUserResult == "true") {
								doAjax(userName, pageIndex);
								alert("成功删除该用户信息！");
							} else if (data.delUserResult == "false") {
								doAjax(userName, pageIndex);
								alert("删除该用户信息失败！");
							}
						}
					});
		}
	};

	function doAjax(userName, pageIndex) {
		
		$
				.ajax({
					url : "${pageContext.request.contextPath }/userAction/getUserListByWrongUserName.action",
					data : {
						"userName" : userName,
						"pageIndex" : pageIndex
					},
					type : "post",
					dataType : "json",
					success : function(data) {
						totalPageCount = data[1];
						currentPageNo = data[2];
						element = "";
						element += '<tr><td>编号</td><td>姓名</td><td>密码</td><td>性别</td><td>出生日期</td><td>联系电话</td><td>操作</td></tr>';
						$
								.each(
										data[0],
										function(key, val) {

											element += '<tr>';
											element += '<td class="userId">'
													+ val['userId'] + '</td>';
											element += '<td class="userName">'
													+ val['userName'] + '</td>';
											element += '<td>' + val['userPwd']
													+ '</td>';
											element += '<td>' + val['gender']
													+ '</td>';
											element += '<td>'
													+ toDate(val['birthdate']);
											+'</td>';
											element += '<td>' + val['phone']
													+ '</td>';
											element += '<td><a class="updateuserrevise" href="${pageContext.request.contextPath }/userAction/getUserById.action?userId='
													+ val['userId']
													+ '"><img title="修改" src="${pageContext.request.contextPath }/img/zd.png"></a><a class="del"><img title="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>';
											element += '</tr>';
										});
						$("table").html(element);
						elementPage = "";
						elementPage += '<li>当前页码：[' + currentPageNo + "/"
								+ totalPageCount
								+ ']</li>&nbsp;&nbsp;&nbsp;&nbsp;';
						if (currentPageNo == 1) {
							element += '<li  style="position: relative;top: 3px;"><a class="currentPage">上一页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;';
						} else {
							element += '<li  style="position: relative;top: 3px;"><a  class="back">上一页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;';
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
						$(".pager .clearfix").html(elementPage);
					},
					error : function(err) {
						alert(err.status);
					}
				});
	};
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
	function currNo(start, end) {
		for (var i = start; i <= end; i++) {
			if (i == currentPageNo) {
				elementPage += '<li class="currentPageIndex"><a class="currentPage">'
						+ i + '</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
			} else {
				elementPage += '<li class="currentPageIndex"><a>' + i
						+ '</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
			}
		}
	}
</script>