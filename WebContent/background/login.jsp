﻿﻿﻿﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>系统登录 - 餐饮管理系统</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/background/login.css" />
</head>
<body class="login_bg">
	<section class="loginBox">
		<c:choose>
			<c:when test="${sessionScope.userSession eq 'loginFailed'}">
				<h4 style="color: red; margin-top: 100px; text-align: center;">密码或者账号输入有误，请重新输入</h4>
			</c:when>
			<c:when test="${not(sessionScope.userSession eq 'redisEmpty')}">
				<jsp:forward page="/userAction/redisLogin.action"></jsp:forward>
			</c:when>
		</c:choose>
		<header class="loginHeader">
			<h1>餐饮管理系统</h1>
		</header>
		<section class="loginCont">
			<form class="loginForm"
				action="${pageContext.request.contextPath }/userAction/getUser.action"
				name="actionForm" id="actionForm" method="post">
				<div class="info"></div>
				<div class="inputbox">
					<label for="user">用户名：</label> <input type="text"
						class="input-text" id="userCode" name="userCode"
						placeholder="请输入用户名" required />
				</div>
				<div class="inputbox">
					<label for="mima">密&nbsp;&nbsp;&nbsp;码：</label> <input
						type="password" id="userPassword" name="userPassword"
						placeholder="请输入密码" required />
				</div>
				<div class="inputbox">
					<label for="yanzhengma">验证码：</label> <input type="text"
						id="identifyingCode" name="identifying" placeholder="请输入验证码"
						required />
					<div id="identifyingCodeImg" title="看不清，点击换一张"></div>
				</div>
				<br />
				<div class="subBtn">
					<input type="submit" value="登录" /> <input type="reset" value="重置" />
				</div>
			</form>
		</section>
	</section>
</body>
<script type="text/javascript">
	var identifyingCodeImg = document.getElementById('identifyingCodeImg');
	identifyingCodeImg.onclick = result;
	var number = 0;
	result();
	function result() {
		var num1 = Math.floor(Math.random() * 20) + 1;
		var num2 = Math.floor(Math.random() * 20) + 1
		var symbol = Math.floor(Math.random() * 2) == 0 ? '+' : '-';
		var fontFamily = [ '华文彩云', '斜体', '微软雅黑', '隶书' ];
		identifyingCodeImg.innerHTML = '&nbsp;' + num1 + symbol + num2 + '=?';
		identifyingCodeImg.style.fontFamily = fontFamily[Math.floor(Math
				.random() * 4)]
		switch (symbol) {
		case '+':
			number = num1 + num2;
			break;
		default:
			number = num1 - num2;
			break;
		}
	}
	var loginForm = document.getElementsByClassName('loginForm');
	var identifyingCode = document.getElementById('identifyingCode');
	loginForm[0].onsubmit=function(){
		if(identifyingCode.value!=number){
			alert('验证码输入有误！');
			result();
			return false;
		}
	}
</script>
</html>
