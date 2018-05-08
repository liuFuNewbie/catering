<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更换用户头像页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/userHeadImage.js"></script> 
	<script type="text/javascript">
		if('${requestScope.num}'=="1"){
			alert("修改成功！");
			window.parent.document.getElementById('headImage').setAttribute("src",'${pageContext.request.contextPath }/${sessionScope.userSession.headPortraits}');
		}else if('${requestScope.num}'=="0"){
			alert('修改失败');
		}
	</script>
</head>
<body>
    <div style="text-align: center;">  
      <form action="${pageContext.request.contextPath }/userAction/udpheadPortraits.action" method="post" enctype="multipart/form-data">
        <c:forEach items="${userHeadPortraits }" var="user">
	        <div style="margin: 20px;">
	          <img id="myimage" height="100" width="100" alt="用户头像" src="${pageContext.request.contextPath }/${user.headPortraits }" />
	        </div>
        </c:forEach>
         <br/>
		<input id="file1" name="file1" style="margin-left: 35%;" type="file" value="选择文件" onchange="getImgURL(this)">
		<br/>
		<input type="submit" value="上       传" class="btn btn-primary btn-lg">
	  </form>
    </div> 
 
</body>
</html>