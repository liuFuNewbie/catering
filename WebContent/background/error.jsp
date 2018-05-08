<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;margin-top: 100px;">请登录后再访问该页面！</h1>
<a href="login.jsp" style="text-align: center;display: block;">立即返回</a>
<h3 style="text-align: center;">剩余<span id="second">5</span>秒,自动跳转</h3>
<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/classPath.js"></script>
<script type="text/javascript">
	var second = document.getElementById("second");
	var i = 4;
	if(window.parent.location.href.indexOf('getAllDataPilots.action')){
		window.parent.location.href = getPath()+"/background/login.jsp";
	}
	var timer=window.setInterval(function(){
		second.innerHTML=i;
		i--;
		if(i==-1){
			window.clearInterval(timer);
			location.href= getPath()+"/background/login.jsp";
		}
	}, 1000);
</script>
</body>
</html>