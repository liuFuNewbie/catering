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

<title>商品详细信息修改页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<title>商品详细信息修改页面</title>

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
							报表管理&nbsp;&nbsp;》&nbsp;&nbsp;营业报表&nbsp;&nbsp;》&nbsp;&nbsp;商品信息&nbsp;&nbsp;》&nbsp;&nbsp;修改
						</h4>
					</div>
					<br />
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="signupForm">
							<div class="form-groupe">
								<label class="col-sm-2 control-label" style="display: none">供应商编号：</label>
								<div class="col-sm-3" style="display: none">
									<input id="materialId" name="materialId" class="form-control"
										type="text" value="${material.materialId }"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">创建人：</label>
								<div class="col-sm-3">
									<input disabled="disabled" id="userName" name="userName"
										class="form-control" type="text" value="${material.userName }">
								</div>
								<label class="col-sm-2 control-label">原料名称：</label>
								<div class="col-sm-4">
									<input id="materialName" name="materialName"
										class="form-control" type="text"
										value="${material.materialName }"> <span
										class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">成本：</label>
								<div class="col-sm-3">
									<input id="cost" name="cost" class="form-control" type="text"
										aria-required="true" aria-invalid="false" class="valid"
										value="${material.cost }"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">单位：</label>
								<div class="col-sm-4">
									<select id="unit" name="unit" class="form-control">
										<option value="0">请选择单位</option>
										<option value="mg"
											<c:if test="${material.unit=='mg' }">selected="selected"</c:if>>mg</option>
										<option value="g"
											<c:if test="${material.unit=='g' }">selected="selected"</c:if>>g</option>
										<option value="kg"
											<c:if test="${material.unit=='kg' }">selected="selected"</c:if>>kg</option>

									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">类别名称：</label>
								<div class="col-sm-3">
									<select id="navId" name="navId" class="form-control">
										<option value="0">请选择类别名称</option>
										<c:forEach var="getNavigationList"
											items="${getNavigationList }" varStatus="i">
											<option value="${getNavigationList.navId}"
												<c:if test="${getNavigationList.navId==material.navId }">selected="selected"</c:if>>${getNavigationList.navName}</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-sm-2 control-label">支付方式名称：</label>
								<div class="col-sm-4">
									<select id="payId" name="payId" class="form-control">
										<option value="0">请选择支付方式</option>
										<c:forEach var="getPayTypeList" items="${getPayTypeList }"
											varStatus="i">
											<option value="${getPayTypeList.payId}"
												<c:if test="${getPayTypeList.payId==material.payId }">selected="selected"</c:if>>${getPayTypeList.payName}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">数量：</label>
								<div class="col-sm-3">
									<input id="number" name="number" class="form-control"
										type="text" value="${material.number }"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">库存：</label>
								<div class="col-sm-4">
									<input id="inventory" name="inventory" class="form-control"
										type="text" value="${material.inventory }"> <span
										class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">描述：</label>
								<div class="col-sm-3">
									<input id="describe" name="describe" class="form-control"
										type="text" value="${material.describe }">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-4">
									<button class="btn btn-primary" type="reset">重置</button>
									<button class="btn btn-primary" type="button" id="btn_update">提交</button>
									<a
										href="${pageContext.request.contextPath }/background/materialinfo.jsp">
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
		src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath }/js/plugins/validate/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/demo/form-material-demo.min.js"></script>
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
	<script
		src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function() {
			var materialId;
			var cost;
			var userName;
			var materialName;
			var cost;
			var unit;
			var navId;
			var payId;
			var number;
			var inventory;
			var describe;
			$("select").focus(function() {
				var index = $("select").index(this);
				$("select").eq(index).css("border-color", "#dcdcdc");
			});
			$("input").focus(function() {
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

			$("#btn_update").on(
					"click",
					function() {
						materialId = $("#materialId").val().trim();
						userName = $("#userName").val().trim();
						materialName = $("#materialName").val().trim();
						cost = $("#cost").val().trim();
						unit = $("#unit").val().trim();
 						number = $("#number").val().trim();
						inventory = $("#inventory").val().trim();
						describe = $("#describe").val().trim();
						navId = $("#navId").val().trim();
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
						if(!checkForm(arr)){
							return false;
						}else{
							checkmaterial(materialId,userName, materialName, cost, unit, number,
									inventory, describe, navId, payId);
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
		function checkmaterial(materialId,userName, materialName, cost, unit, number,
				inventory, describe, navId, payId) {
 				$
						.ajax({
							url : "${pageContext.request.contextPath }/material/updateMaterialById.action",
							data : {
								"materialId" : materialId,
								"userName" : userName,
								"materialName" : materialName,
								"cost" : cost,
								"unit" : unit,
								"navId" : navId,
								"payId" : payId,
								"number" : number,
								"inventory" : inventory,
								"describe" : describe
							},
							dataType : "json",
							type : "post",
							success : function(data) {
								if (data.updateMaterialResult == "true") {
									alert("修改成功");
									location.href = "${pageContext.request.contextPath }/background/materialinfo.jsp";
								} else if (data.updateMaterialResult == "flase") {
									alert("修改失败");
									location.href = "${pageContext.request.contextPath }/background/materialinfo.jsp";
								}
							}
						});

 		}
	</script>
</body>
</html>
