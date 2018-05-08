<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<title>支付方式</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/background/baobiao.css">

</head>

<body>
	<div>
		<div class="inquiry">
			<span class="increasedHead"> <a
				href="${pageContext.request.contextPath }/background/addpayoffmode.jsp">
					<img alt="新增"
					src="${pageContext.request.contextPath }/img/tianjia.png"> <i
					class="raise">新增</i>
			</a>
			</span>
		</div>
		<table class="discolorationNumber"
			style="text-align: center;">
			<tr>
				<td>编号</td>
				<td>支付类型名称</td>
				<td>操作</td>
			</tr>
			<c:forEach var="paytype" items="${payTypeList }" varStatus="status">
				<tr>
					<td>${paytype.payId }</td>
					<td>${paytype.payName }</td>
					<td>
						<a class="updpay" href="javascript:;" payId=${paytype.payId } payName=${paytype.payName }>
							<img alt="修改图标" title="修改" src="${pageContext.request.contextPath }/img/zd.png">
						</a>
						<a class="delpay" href="javascript:;" payId=${paytype.payId } payName=${paytype.payName }>
							<img alt="删除图标" title="删除" src="${pageContext.request.contextPath }/img/schu.png">
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/background/payoffmodes.js"></script>
</html>
