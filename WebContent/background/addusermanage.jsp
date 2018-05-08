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

<title>用户管理新增</title>

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
							系统设置&nbsp;&nbsp;》&nbsp;&nbsp;用户管理&nbsp;&nbsp;》&nbsp;&nbsp;新增</h4>
					</div>
					<br />
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="signupForm" action="${pageContext.request.contextPath }/userAction/insertUser.action"
							enctype="multipart/form-data" method="post">
							<div class="form-groupe">
								<label class="col-sm-2 control-label">用户名：</label>
								<div class="col-sm-3">
									<input id="userName" name="userName" class="form-control"
										type="text"> <span class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">电话号码：</label>
								<div class="col-sm-4">
									<input id="phone" name="phone" class="form-control" type="text">
									<span class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">密码：</label>
								<div class="col-sm-3">
									<input id="userPwd" name="userPwd" class="form-control"
										type="text"> <span class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">确认密码：</label>
								<div class="col-sm-4">
									<input id="userPwds" name="userPwds" class="form-control"
										type="text"> <span class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">出生日期：</label>
								<div class="col-sm-3">
									<input type="date" id="birthdates" name="birth"
										class="form-control" /> <span class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">性别：</label>
								<div class="col-sm-4">
									<select id="gender" name="gender" class="form-control">
										<option value="0">请选择性别</option>
										<option value="女">女</option>
										<option value="男">男</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">状态：</label>
								<div class="col-sm-3">
									<select id="roleId" name="roleId" class="form-control">

									</select>
								</div>
								<label class="col-sm-2 control-label">用户头像：</label>
								<div class="col-sm-4">
									<input id="headPortraits" name="portraits" class="form-control"
										type="file" accept="*.webp,*.bmp,*.jpg,*.png,*.tiff,*.gif"
										onchange="filesize(this)"> <span
										class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-4">
									<button class="btn btn-primary" type="reset">重置</button>
									<button class="btn btn-primary" type="submit" id="btn_addUser">提交</button>
									<a
										href="${pageContext.request.contextPath }/background/usermanage.jsp">
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
		var userName;
		var phone;
		var userPwd;
		var userPwds;
		var birthdates;
		var myreg;
		var filename;
		var headPortraits;
		var element = "";
		var roleId;
		var gender;
		$(function() {
			BingComBox();
			$("select").click(function() {
				var index = $(this).val();
				$(this).eq(index).css("border-color", "#dcdcdc");
			});
			$("input").click(function() {
				var index = $("input").index(this);
				$("input").eq(index).siblings("span").html("");
			});
			$("#userPwd").on("blur", function() {
				userPwd = $("#userPwd").val().trim();
				checkuserPwd(userPwd);
			});

			$("#userPwds").on("blur", function() {
				userPwd = $("#userPwd").val().trim();
				userPwds = $("#userPwds").val().trim();
				checkuseerPwds(userPwd, userPwds);
			});

			$("#phone").on("blur", function() {
				phone = $("#phone").val().trim();
				checkPhone(phone);
			});

			$("#btn_addUser").on(
					"click",
					function() {
						userName = $("#userName").val().trim();
						phone = $("#phone").val().trim();
						userPwd = $("#userPwd").val().trim();
						userPwds = $("#userPwds").val().trim();
						birthdates = $("#birthdates").val().trim();
						roleId = $("#roleId").val().trim();
						gender = $("#gender").val().trim();
						headPortraits = $("#headPortraits").val().trim();
						var arr = new Array(
								new Array('userName', '请输入用户名'),
							 	new Array('phone', '请输入手机号码'),
							 	new Array('userPwd', '请输入密码'), 
							 	new Array('userPwds', '请输入确认密码'), 
							 	new Array('birthdates', '请选择出生日期'), 
							 	new Array('roleId', '请选择角色'), 
							 	new Array('gender','请选择性别'),
							 	new Array('headPortraits','请选择用户图片')
								);
						if (!checkForm(arr)) {
 							return false;
						} else {
 							return true;
						}
					});
		});
		function checkForm(arr) {
			for (var i = 0; i < arr.length; i++) {
				if ($("#" + arr[i][0]).val() == '') {
					if ($("#" + arr[5][0]).val() == 0) {
						$("#" + arr[5][0]).css("border-color", "red");
					}
					if ($("#" + arr[6][0]).val() == 0) {
						$("#" + arr[6][0]).css("border-color", "red");
					}
					$("#" + arr[i][0]).siblings("span").html(arr[i][1]).css(
							"color", "red");
				}
			}
			if ($("#" + arr[0][0]).val() != ""
					&& $("#" + arr[1][0]).val() != ""
					&& $("#" + arr[2][0]).val() != ""
					&& $("#" + arr[3][0]).val() != ""
					&& $("#" + arr[4][0]).val() != ""
					&& $("#" + arr[5][0]).val() != 0
					&& $("#" + arr[6][0]).val() != 0
					&& $("#" + arr[7][0]).val() != "") {
				return true;
			}
		}

		function checkuserPwd(userPwd) {
			if (userPwd == null || userPwd == "") {
				$("#userPwd").siblings("span").html("请输入密码！").css("color",
						"red");
				return false;
			} else {
				if (userPwd.length != 6) {
					$("#userPwd").siblings("span").html("密码不能小于或大于6位！").css(
							"color", "red");
					return false;
				}
			}
		}
		function checkuseerPwds(userPwd, userPwds) {
			if (userPwds == null || userPwds == "") {
				$("#userPwds").siblings("span").html("请输入确认密码！").css("color",
						"red");
				return false;
			} else {
				if (userPwds != userPwd) {
					$("#userPwds").siblings("span").html("两次输入密码不一致！").css(
							"color", "red");
					return false;
				}
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

		function filesize(ele) {
			filename = ele.value.substring(ele.value.lastIndexOf("\\") + 1,
					ele.value.length);
			if (!/\.(jpg|jpeg|png|GIF|JPG|PNG)$/.test(filename)) {
				$("#headPortraits").siblings("span").html(
						"用户证件照片格式.jpg|.jpeg|.png").css("color", "red");
				return false;
			} else {
				// 返回 KB，保留小数点后两位 (ele.files[0].size / 1024).toFixed(2)
				//返回 KB，不保留小数点后两位，取整数 (ele.files[0].size / 1024).toFixed(0)
				var fileSize = (ele.files[0].size / 1024).toFixed(0);
				if (fileSize > 102400) {
					$("#headPortraits").siblings("span").html("上传文件大小不能超过10M")
							.css("color", "red");
					return false;
				}/*else{alert("保留小数点后两位："+(ele.files[0].size / 1024).toFixed(2)+"\t"+"不保留小数点后两位："+fileSize);}*/
			}
		}
		function BingComBox() {
			$
					.ajax({
						url : "${pageContext.request.contextPath }/userAction/getRoleList.action",
						data : null,
						post : "post",
						dataType : "json",
						success : function(data) {
							element += '<option value="0"> 请选择状态 </option>';
							$.each(data[0], function(key, val) {
								element += '<option value="'+val['roleId']+'">'
										+ val['roleName'] + '</option>';
							});
							$("#roleId").html(element);

						},
						error : function(err) {
							alert(err.status);
						}

					});
		}
	</script>
</body>
</html>
