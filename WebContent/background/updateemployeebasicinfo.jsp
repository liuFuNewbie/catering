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

<title>员工基本信息修改</title>

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
							系统设置&nbsp;&nbsp;》&nbsp;&nbsp;员工管理&nbsp;&nbsp;》&nbsp;&nbsp;员工基本信息&nbsp;&nbsp;》&nbsp;&nbsp;修改
						</h4>
					</div>
					<br />
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="signupForm">
							<div class="form-groupe">
								<label class="empId" style="display: none;">${employee.empId }</label>
								<label class="col-sm-2 control-label">员工姓名：</label>
								<div class="col-sm-3">
									<input id="empName" name="empName" class="form-control"
										type="text" value="${employee.empName }"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">身份证号：</label>
								<div class="col-sm-4">
									<input id="identificationCard" name="identificationCard"
										class="form-control" type="text"
										value="${employee.identificationCard }"> <span
										class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">性别：</label>
								<div class="col-sm-3">
									<select id="gender" name="gender" class="form-control">
										<option value="女"
											<c:if test="${employee.gender=='女' }">selected="selected"</c:if>>女</option>
										<option value="男"
											<c:if test="${employee.gender=='男' }">selected="selected"</c:if>>男</option>
									</select>
								</div>
								<label class="col-sm-2 control-label">电话号码：</label>
								<div class="col-sm-4">
									<input id="phone" name="phone" class="form-control" type="text"
										aria-required="true" aria-invalid="false" class="valid"
										value="${employee.phone }"> <span
										class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">出生日期：</label>
								<div class="col-sm-3">
									<input id="birthdate" name="birthdate" class="form-control"
										type="date" value="${dateString}"> <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">家庭住址：</label>
								<div class="col-sm-4">
									<input id="address" name="address" class="form-control"
										type="text" value="${employee.address}"> <span
										class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">工资：</label>
								<div class="col-sm-3">
									<input id="salary" name="salary" class="form-control"
										type="text" value="${employee.salary}">
										 <span
										class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">奖金：</label>
								<div class="col-sm-4">
									<input id="bonus" name="bonus" class="form-control" type="text"
										value="${employee.bonus}">
										 <span
										class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">状态：</label>
								<div class="col-sm-3">
									<select id="pose" name="pose" class="form-control">
										<option value="-1">请选择状态</option>
										<option value="0"
											<c:if test="${employee.pose==0}">selected="selected"</c:if>>未发放</option>
										<option value="1"
											<c:if test="${employee.pose==1}">selected="selected"</c:if>>已发放</option>
									</select>
								</div>
								<label class="col-sm-2 control-label">员工类型：</label>
								<div class="col-sm-4">
									<select id="empTypeId" name="empTypeId" class="form-control">
										<option value="-1">请选择员工类型</option>
										<c:forEach var="getmployeeTypeList"
											items="${getmployeeTypeList }" varStatus="i">
											<option value="${getmployeeTypeList.empTypeId }"
												<c:if test="${employee.empTypeId==getmployeeTypeList.empTypeId }">selected="selected"</c:if>>${getmployeeTypeList.empTypeName }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">专业：</label>
								<div class="col-sm-3">
									<select id="majorId" name="majorId" class="form-control">
										<option value="-1">请选择专业</option>
										<c:forEach var="getMajorList" items="${getMajorList }"
											varStatus="i">
											<option value="${getMajorList.majorId }"
												<c:if test="${employee.majorId==getMajorList.majorId }">selected="selected"</c:if>>${getMajorList.majorName }</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-sm-2 control-label">学历：</label>
								<div class="col-sm-4">
									<select id="educationId" name="educationId"
										class="form-control">
										<option value="-1">请选择学历</option>
										<c:forEach var="getEducationList" items="${getEducationList }"
											varStatus="i">
											<option value="${getEducationList.educationId }"
												<c:if test="${employee.educationId==getEducationList.educationId }">selected="selected"</c:if>>${getEducationList.educationName }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-4">
									<button class="btn btn-primary" type="reset">重置</button>
									<button class="btn btn-primary" type="button"
										id="btn_upemployee">提交</button>
									<a
										href="${pageContext.request.contextPath }/background/employeebasicinfo.jsp">
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
 
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
	<script
		src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script>
		var element = "";
		var empId;
		var empName;
		var identificationCard;
		var gender;
		var phone;
		var birthdate;
		var address;
		var salary;
		var bonus;
		var pose;
		var empTypeId;
		var majorId;
		var educationId;
		$(function() {

			$("select").focus(function() {
				var index = $("select").index(this);
				$("select").eq(index).css("border-color", "#dcdcdc");
			});
			$("input").focus(function() {
				var index = $("input").index(this);
				$("input").eq(index).siblings("span").html("");
			});

			$("#identificationCard").on("blur", function() {
				identificationCard = $("#identificationCard").val().trim();
				identifityCard(identificationCard);
			});

			$("#phone").on("blur", function() {
				phone = $("#phone").val().trim();
				checkPhone(phone);
			});

			//验证员工工资
			$("#salary").on("blur", function() {
				salary = $("#salary").val().trim();
				checkSalary(salary); 
			});
			//验证员工奖励金
			$("#bonus").on("blur", function() {
				bonus = $("#bonus").val().trim();
				checkBonus(bonus);
			});

			$("#btn_upemployee").on(
					"click",
					function() {
						empId = $(".empId").text();
						empName = $("#empName").val().trim();
						identificationCard = $("#identificationCard").val().trim();
						gender = $("#gender").val();
						phone = $("#phone").val().trim();
						birthdate = $("#birthdate").val().trim();
						address = $("#address").val().trim();
						salary = $("#salary").val().trim();
						bonus = $("#bonus").val().trim();
						pose = $("#pose").val().trim();
						empTypeId = $("#empTypeId").val();
						educationId = $("#educationId").val();
						majorId = $("#majorId").val();
						var arr = new Array(
								new Array('empName', '请输入员工名称'),
								new Array('identificationCard', '请输入身份证号码'),
								new Array('gender', '请选择性别'), 
								new Array('phone', '请输入手机号码'),
								new Array('birthdate', '请选择出生日期'),
								new Array('address', '请输入地址'),
								new Array('salary', '请输入工资'),
								new Array('bonus','请输入奖励金'),
								new Array('pose', '请选择状态'),
								new Array('empTypeId', '请选择员工类型'),
								new Array('educationId', '请选择专业'), 
								new Array('majorId', '请选择学历'));
						if (!checkForm(arr)) {
							return false;
						} else {
							verification(empId, empName, identificationCard,
									gender, phone, birthdate, address, salary,
									bonus, pose, empTypeId, majorId, educationId);
						}
						
					});
		});
		function checkForm(arr) {
			for (i = 0; i < arr.length; i++) {
				if ($("#" + arr[i][0]).val() == '') {
					if ($("#" + arr[2][0]).val() == -1) {
						$("#" + arr[2][0]).css("border-color", "red");
					}
					if ($("#" + arr[8][0]).val() == -1) {
						$("#" + arr[8][0]).css("border-color", "red");
					}
					if ($("#" + arr[9][0]).val() == -1) {
						$("#" + arr[9][0]).css("border-color", "red");
					}
					if ($("#" + arr[10][0]).val() == -1) {
						$("#" + arr[10][0]).css("border-color", "red");
					}
					if ($("#" + arr[11][0]).val() == -1) {
						$("#" + arr[11][0]).css("border-color", "red");
					}
					$("#" + arr[i][0]).siblings("span").html(arr[i][1]).css(
							"color", "red");
				}
			}
			if ($("#" + arr[0][0]).val() != ""
					&& $("#" + arr[1][0]).val() != ""
					&& $("#" + arr[2][0]).val() != -1
					&& $("#" + arr[3][0]).val() != 0
					&& $("#" + arr[4][0]).val() != ""
					&& $("#" + arr[5][0]).val() != ""
					&& $("#" + arr[6][0]).val() != ""
					&& $("#" + arr[7][0]).val() != ""
					&& $("#" + arr[8][0]).val() != -1
					&& $("#" + arr[9][0]).val() != -1
					&& $("#" + arr[10][0]).val() != -1
					&& $("#" + arr[11][0]).val() != -1) {
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

		function checkSalary(salary) {
			if (salary == null || salary == "") {
				$("#salary").siblings("span").html("请输入员工工资");
				return false;
			} else if (isNaN(salary)) {
				$("#salary").siblings("span").html("员工工资不能是字符类型");
				return false;
			}
		}
		function checkBonus(bonus) {
			if (bonus == null || bonus == "") {
				$("#bonus").siblings("span").html("请输入员工奖励金");
				return false;
			} else if (isNaN(bonus)) {
				$("#bonus").siblings("span").html("员工奖励金不能是字符类型");
				return false;
			}
		}
		function identifityCard(identificationCard) {
			if (identificationCard == null || identificationCard == "") {
				$("#identificationCard").siblings("span").html("请输入员工更改身份证号码");
				return false;
			} else if (identificationCard.length != 18) {
				$("#identificationCard").siblings("span").html(
						"身份证号码不能小于或大于18位");
				return false;
			}
		}
		//表当验证
		function verification(empId, empName, identificationCard, gender,
				phone, birthdate, address, salary, bonus, pose, empTypeId,
				majorId, educationId) {
 				$
						.ajax({
							url : "${pageContext.request.contextPath }/employee/updateEmployeeById.action",
							data : {
								"empId" : empId,
								"empName" : empName,
								"identificationCard" : identificationCard,
								"gender" : gender,
								"phone" : phone,
								"birth" : birthdate,
								"address" : address,
								"salary" : salary,
								"bonus" : bonus,
								"pose" : pose,
								"empTypeId" : empTypeId,
								"majorId" : majorId,
								"educationId" : educationId
							},
							type : "post",
							dataType : "json",
							success : function(data) {
								if (data.upemployee == "ok") {
									alert("修改员工" + empName + "成功！");
									location.href = "${pageContext.request.contextPath }/background/employeebasicinfo.jsp";
								} else {
									alert("修改员工" + empName + "成功！");
									location.href = "${pageContext.request.contextPath }/background/employeebasicinfo.jsp";
								}
							}
						});
			}
 		 
	</script>
</body>
</html>
