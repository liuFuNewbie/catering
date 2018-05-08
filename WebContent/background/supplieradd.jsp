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

<title>供应商新增</title>

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
							报表管理&nbsp;&nbsp;》&nbsp;&nbsp;供应商&nbsp;&nbsp;》&nbsp;&nbsp;新增</h4>
					</div>
					<br />
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="signupForm">
							<div class="form-groupe">
								<label class="col-sm-2 control-label">供应商名称：</label>
								<div class="col-sm-3">
									<input id="supplierName" name="supplierName"
										class="form-control" type="text"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">电话号码：</label>
								<div class="col-sm-4">
									<input id="phone" name="phone" class="form-control" type="text">
									<span class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">商品名称：</label>
								<div class="col-sm-3">
									<input id="shoppingName" name="shoppingName"
										class="form-control" type="text"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">家庭地址：</label>
								<div class="col-sm-4">
									<input id="address" name="address" class="form-control"
										type="text"> <span class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">备注：</label>
								<div class="col-sm-9">
									<input id="remark" name="remark" class="form-control"
										type="text"> <span class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-4">
									<button class="btn btn-primary" type="reset">重置</button>
									<button class="btn btn-primary" type="button"
										id="btn_suppliermodify">提交</button>
									<a
										href="${pageContext.request.contextPath }/background/supplier.jsp">
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
	<script type="text/javascript">
		var supplierName;
		var shoppingName;
		var address;
		var remark;
		var phone;
		var myreg;

		$(function() {

			$("input").click(function() {
				var index = $("input").index(this);
				$("input").eq(index).siblings("span").html("");
			});
			$("#phone").on("blur", function() {
				phone = $("#phone").val().trim();
				checkPhone(phone);
			});

			$("#btn_suppliermodify").on(
					"click",
					function() {
						supplierName = $("#supplierName").val().trim();
						shoppingName = $("#shoppingName").val().trim();
						phone = $("#phone").val().trim();
						address = $("#address").val().trim();
						remark = $("#remark").val().trim();
						var arr = new Array(
								new Array('supplierName', '请输供应商名称'),
								new Array('shoppingName', '请输入商品名称'),
								new Array('phone', '请输入电话号码'), new Array(
										'address', '请输入地址'), new Array(
										'remark', '请输入备注'));
						if (!checkForm(arr)) {
							return false;
						} else {
							checkSupplier(supplierName, shoppingName, phone,
									address, remark);
						}
					});
		});
		function checkForm(arr) {
			for (i = 0; i < arr.length; i++) {
				if ($("#" + arr[i][0]).val() == '') {
					$("#" + arr[i][0]).siblings("span").html(arr[i][1]).css(
							"color", "red");
				}
			}
			if ($("#" + arr[0][0]).val() != ""
					&& $("#" + arr[1][0]).val() != ""
					&& $("#" + arr[2][0]).val() != ""
					&& $("#" + arr[3][0]).val() != ""
					&& $("#" + arr[4][0]).val() != "") {
				return true;
			}
		}
		function checkPhone(phone) {
			myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if (phone == null || phone == "") {
				$("#phone").siblings("span").html("请输入电话号码")
						.css("color", "red");
				return false;
			} else if (isNaN(phone)) {
				$("#phone").siblings("span").html("电话号码不能含有其他字符！").css("color",
						"red");
				return false;
			} else if (phone.length != 11) {
				$("#phone").siblings("span").html("电话号码长度不能小于11位").css("color",
						"red");
				return false;
			} else if (!myreg.test(phone)) {
				$("#phone").siblings("span").html("以130-139,150-159,180-189开头")
						.css("color", "red");
				return false;
			}
		}
		function checkSupplier(supplierName, shoppingName, phone, address,
				remark) {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/background/insertSupplier.action",
						data : {
							"supplierName" : supplierName,
							"shoppingName" : shoppingName,
							"phone" : phone,
							"address" : address,
							"remark" : remark,
						},
						dataType : "json",
						type : "post",
						success : function(data) {
							if (data.insertSupplierResult == "true") {
								alert("添加" + supplierName + "供应商信息成功！");
								location.href = "${pageContext.request.contextPath}/background/supplier.jsp";
							} else if (data.insertSupplierResult == "flase") {
								alert("添加" + supplierName + "供应商信息失败！");
								location.href = "${pageContext.request.contextPath}/background/supplier.jsp";
							}
						}
					});
		}
	</script>

</body>
</html>
