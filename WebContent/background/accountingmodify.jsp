<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>往来业务修改</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">

</head>

<body>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h4>
							报表管理&nbsp;&nbsp;》&nbsp;&nbsp;往来业务&nbsp;&nbsp;》&nbsp;&nbsp;修改</h4>
					</div>
					<br />
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="signupForm">
							<div class="form-groupe">
								<label class="col-sm-2 control-label" style="display: none">业务编号：</label>
								<div class="col-sm-3" style="display: none">
									<input id="businessId" name="businessId" class="form-control"
										type="text" value="${business.businessId }"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">供应商名称：</label>
								<div class="col-sm-3">
									<select name="supplierId" id="supplierId" class="form-control">
										<option value="0">请选择供应商名称</option>
										<c:forEach var="supplierList" items="${supplierList }"
											varStatus="i">
											<option value="${supplierList.supplierId }"
												<c:if test="${supplierList.supplierId ==business.supplierId}">selected="selected"</c:if>>${supplierList.supplierName }</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-sm-2 control-label">应付款：</label>
								<div class="col-sm-4">
									<input id="due" name="due" class="form-control" type="text"
										value="${business.due }"> <span
										class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">已付款：</label>
								<div class="col-sm-3">
									<input id="accountPaid" name="accountPaid" class="form-control"
										type="text" value="${business.accountPaid }"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">经手人：</label>
								<div class="col-sm-4">
									<select class="form-control" name="empId" id="empId">
										<option value="0">请选择办理人</option>
										<c:forEach var="employeeList" items="${employeeList }"
											varStatus="i">
											<option value="${employeeList.empId }"
												<c:if test="${employeeList.empId ==business.empId}"> selected="selected"</c:if>>${employeeList.empName }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">备注：</label>
								<div class="col-sm-9">
									<input id="remark" name="remark" class="form-control"
										type="text" value="${business.remark}"> <span
										class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-4">
									<button class="btn btn-primary" type="reset">重置</button>
									<button class="btn btn-primary" type="button"
										id="btn_updateBusiness">提交</button>
									<a
										href="${pageContext.request.contextPath }/background/accounting.jsp">
										<button class="btn btn-primary" type="button">返回</button>
									</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script>
		var supplierId;
		var due;
		var accountPaid;
		var empId;
		var remark;
		var businessId;
		$(function() {
			$("select").focus(function() {
				var index = $("select").index(this);
				$("select").eq(index).css("border-color", "#dcdcdc");
			});
			$("input").focus(function() {
				var index = $("input").index(this);
				$("input").eq(index).siblings("span").html("");
			});
			$("#due").on("blur", function() {
				due = $("#due").val().trim();
				checkdue(due);
			});
			$("#accountPaid").on("blur", function() {
				accountPaid = $("#accountPaid").val().trim();
				checkaccountPaid(accountPaid);
			});
			$("#btn_updateBusiness").on(
					"click",
					function() {
						businessId = $("#businessId").val().trim();
						supplierId = $("#supplierId").val().trim();
						due = $("#due").val().trim();
						accountPaid = $("#accountPaid").val().trim();
						empId = $("#empId").val().trim();
						remark = $("#remark").val().trim();
						var arr = new Array(new Array('supplierId', '请选择供应商'),
								new Array('due', '请输入应付款金额'), new Array(
										'accountPaid', '请输入已付款金额'), new Array(
										'empId', '请选择经办人'), new Array('remark',
										'请输入备注'));
						if (!checkForm(arr)) {
							return false;
						} else {
							checkaccount(businessId, supplierId, due,
									accountPaid, empId, remark);
						}
					});
		});
		function checkForm(arr) {
			for (i = 0; i < arr.length; i++) {
				if ($("#" + arr[i][0]).val() == '') {
					if ($("#" + arr[0][0]).val() == 0) {
						$("#" + arr[0][0]).css("border-color", "red");
					}
					if ($("#" + arr[3][0]).val() == 0) {
						$("#" + arr[3][0]).css("border-color", "red");
					}
					$("#" + arr[i][0]).siblings("span").html(arr[i][1]).css(
							"color", "red");
				}
			}
			if ($("#" + arr[0][0]).val() != 0 && $("#" + arr[1][0]).val() != ""
					&& $("#" + arr[2][0]).val() != ""
					&& $("#" + arr[3][0]).val() != 0
					&& $("#" + arr[4][0]).val() != "") {
				return true;
			}
		}
		function checkdue(due) {
			if (due == null || due == "") {
				$("#due").siblings("span").html("请输入应付款金额");
				return false;
			} else if (isNaN(due)) {
				$("#due").siblings("span").html("输入应付款是整数类型");
				return false;
			}
		}
		function checkaccountPaid(accountPaid) {
			if (accountPaid == null || accountPaid == "") {
				$("#accountPaid").siblings("span").html("请输入已付款金额");
				return false;
			} else if (isNaN(accountPaid)) {
				$("#accountPaid").siblings("span").html("输入已付款是整数类型");
				return false;
			}
		}
		function checkaccount(businessId, supplierId, due, accountPaid, empId,
				remark) {
			$
					.ajax({
						url : "${pageContext.request.contextPath }/background/updateBusinessById.action",
						data : {
							"businessId" : businessId,
							"supplierId" : supplierId,
							"due" : due,
							"accountPaid" : accountPaid,
							"empId" : empId,
							"remark" : remark
						},
						dataType : "json",
						type : "post",
						success : function(data) {
							if (data.updatebusinessResult == "true") {
								alert("修改业务成功");
								location.href = "${pageContext.request.contextPath }/background/accounting.jsp";
							} else if (data.updatebusinessResult == "flase") {
								alert("修改业务失败");
								location.href = "${pageContext.request.contextPath }/background/accounting.jsp";
							}
						}
					});
		}
	</script>
</body>
</html>
