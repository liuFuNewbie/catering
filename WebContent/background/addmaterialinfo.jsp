<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>商品详细信息新增页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">

<title>商品详细信息新增页面</title>

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
								<label class="col-sm-2 control-label">原料名称：</label>
								<div class="col-sm-3">
									<input id="materialName" name="materialName"
										class="form-control" type="text"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">数量：</label>
								<div class="col-sm-4">
									<input id="number" name="number" class="form-control"
										type="text"> <span class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">单价：</label>
								<div class="col-sm-3">
									<input id="cost" name="cost" class="form-control" type="text"
										aria-required="true" aria-invalid="false" class="valid">
									<span class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">结算金额：</label>
								<div class="col-sm-4">
									<input id="totalMoney" name="totalMoney" class="form-control"
										type="text" aria-required="true" aria-invalid="false"
										class="valid"> <span class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">单位：</label>
								<div class="col-sm-3">
									<select id="unit" name="unit" class="form-control">
										<option value="0">请选择单位</option>
										<option value="mg">mg</option>
										<option value="g">g</option>
										<option value="kg">kg</option>
									</select>
								</div>
								<label class="col-sm-2 control-label">支付方式：</label>
								<div class="col-sm-4">
									<select id="payId" name="payId" class="form-control">

									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">导航：</label>
								<div class="col-sm-3">
									<select id="navId" name="navId" class="form-control">

									</select>
								</div>
								<label class="col-sm-2 control-label">用户：</label>
								<div class="col-sm-4">
									<select id="userId" name="userId" class="form-control">

									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">库存：</label>
								<div class="col-sm-3">
									<input id="inventory" name="inventory" class="form-control"
										type="text"> <span class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">描述：</label>
								<div class="col-sm-4">
									<input id="describe" name="describe" class="form-control"
										type="text"> <span class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-4">
									<button class="btn btn-primary" type="reset">重置</button>
									<button class="btn btn-primary" type="button"
										id="btn_materialinfo">提交</button>
									<a
										href="${pageContext.request.contextPath }/background/shoppinginfo.jsp">
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
		var number;
		var inventory;
		var cost;
		var totalMoney;
		var materialName;
		var unit;
		var describe;
		var navId;
		var userId;
		var payId;
		var element = "";
		$(function() {
			BingComBox();
			$("select").click(function() {
				var index = $("select").index(this);
				$("select").eq(index).css("border-color", "#dcdcdc");
			});
			$("input").click(function() {
				var index = $("input").index(this);
				$("input").eq(index).siblings("span").html("");
			});
			$("#cost").on("blur", function() {
				cost = $("#cost").val().trim();
				checkcost(cost);
			});

			$("#inventory").on("blur", function() {
				inventory = $("#inventory").val().trim();
				checkinventory(inventory);
			});
			$("#number").on("blur", function() {
				number = $("#number").val().trim();
				checkNumber(number);
			});
			$("#totalMoney").on("blur", function() {
				totalMoney = $("#totalMoney").val().trim();
				checkMoney(totalMoney);
			});
			$("#btn_materialinfo")
					.on(
							"click",
							function() {
								materialName = $("#materialName").val().trim();
								cost = $("#cost").val().trim();
								unit = $("#unit").val().trim();
								number = $("#number").val().trim();
								totalMoney = $("#totalMoney").val().trim();
								inventory = $("#inventory").val().trim();
								describe = $("#describe").val().trim();
								navId = $("#navId").val().trim();
								userId = $("#userId").val().trim();
								payId = $("#payId").val().trim();
								var arr = new Array(
										new Array('materialName','请输入原料名称'),
										new Array('cost', '请输入单价'),
										new Array('unit', '请选择单位'), 
										new Array('number', '请输入数量'),
										new Array('totalMoney', '请输入结算金额'),
										new Array('inventory', '请输入库存'),
										new Array('describe', '请输入描述'),
										new Array('navId', '请选择导航'),
										new Array('userId', '请选择用户'),
										new Array('payId', '请选择支付方式'));
								if (!checkForm(arr)) {
									return false;
								} else {
									checkmaterial(materialName, cost, unit,
											number, totalMoney, inventory,
											describe, navId, userId, payId);
								}
							});
		});
		function checkForm(arr) {
			for (i = 0; i < arr.length; i++) {
				if ($("#" + arr[i][0]).val() == '') {
					if ($("#" + arr[2][0]).val() == 0) {
						$("#" + arr[2][0]).css("border-color", "red");
					}
					if ($("#" + arr[7][0]).val() == 0) {
						$("#" + arr[7][0]).css("border-color", "red");
					}
					if ($("#" + arr[8][0]).val() == 0) {
						$("#" + arr[8][0]).css("border-color", "red");
					}
					if ($("#" + arr[9][0]).val() == 0) {
						$("#" + arr[9][0]).css("border-color", "red");
					}
					$("#" + arr[i][0]).siblings("span").html(arr[i][1]).css(
							"color", "red");
				}
			}
			if ($("#" + arr[0][0]).val() != ""
					&& $("#" + arr[1][0]).val() != ""
					&& $("#" + arr[2][0]).val() !=0
					&& $("#" + arr[3][0]).val() != ""
					&& $("#" + arr[4][0]).val() != ""
					&& $("#" + arr[5][0]).val() != ""
					&& $("#" + arr[6][0]).val() != ""
					&& $("#" + arr[7][0]).val() != 0
					&& $("#" + arr[8][0]).val() != 0
					&& $("#" + arr[9][0]).val() != 0) {
				return true;
			}
		}
		function checkinventory(inventory) {
			if (inventory == null || inventory == "") {
				$("#inventory").siblings("span").html("请输入库存量");
				return false;
			} else if (isNaN(inventory)) {
				$("#inventory").siblings("span").html("输入库存量是整数类型");
				return false;
			}
		}
		function checkcost(cost) {
			if (cost == null || cost == "") {
				$("#cost").siblings("span").html("请输入输入单价");
				return false;
			} else if (isNaN(cost)) {
				$("#cost").siblings("span").html("输入单价是整数类型");
				return false;
			}
		}
		function checkNumber(number) {
			if (number == null || number == "") {
				$("#number").siblings("span").html("请输入输入数量");
				return false;
			} else if (isNaN(number)) {
				$("#number").siblings("span").html("输入数量是整数类型");
				return false;
			}
		}
		function checkMoney(money) {
			if (totalMoney == null || totalMoney == "") {
				$("#totalMoney").siblings("span").html("请输入结算金额");
				return false;
			} else if (isNaN(totalMoney)) {
				$("#totalMoney").siblings("span").html("输入结算金额是整数类型");
				return false;
			}
		}
		function checkmaterial(materialName, cost, unit, number, totalMoney,
				inventory, describe, navId, userId, payId) {
			$
					.ajax({
						url : "${pageContext.request.contextPath }/material/insetMaterial.action",
						data : {
							"materialName" : materialName,
							"cost" : cost,
							"unit" : unit,
							"number" : number,
							"totalMoney" : totalMoney,
							"inventory" : inventory,
							"describe" : describe,
							"navId" : navId,
							"userId" : userId,
							"payId" : payId
						},
						dataType : "json",
						type : "post",
						success : function(data) {
							if (data.insertMaterialResult == "true") {
								alert("添加成功！");
								location.href = "${pageContext.request.contextPath }/background/materialinfo.jsp";
							} else if (data.insertMaterialResult == "false") {
								alert("添加失败！");
								location.href = "${pageContext.request.contextPath }/background/materialinfo.jsp";
							}
						}
					});
		}
		function BingComBox() {
			$
					.ajax({
						url : "${pageContext.request.contextPath }/material/getMaterialInfo.action",
						data : null,
						post : "post",
						dataType : "json",
						success : function(data) {
							element += '<option value="0">请选择支付方式</option>';
							$.each(data[0], function(key, val) {
								element += '<option value="'+val['payId']+'">'
										+ val['payName'] + '</option>';
							});
							$("#payId").html(element);
							element = "";
							element += '<option value="0">请选择导航 </option>';
							$.each(data[1], function(key, val1) {
								element += '<option value="'+val1['navId']+'">'
										+ val1['navName'] + '</option>';
							});
							$("#navId").html(element);
							element = "";
							element += '<option value="0"> 请选择用户 </option>';
							$
									.each(
											data[2],
											function(key, val2) {
												element += '<option value="'+val2['userId']+'">'
														+ val2['userName']
														+ '</option>';
											});
							$("#userId").html(element);
						},
						error : function(err) {
							alert(err.status);
						}

					});
		}
	</script>
</body>
</html>