<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>好好吃餐饮管理系统</title>
<link
	href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/font-awesome.min93e3.css?v=4.4.0"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/style.min862f.css?v=4.1.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/background/baobiao.css"
	rel="stylesheet">
</head>
<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow: hidden">
	<c:choose>
		<c:when test="${(empty sessionScope.userSession) or (sessionScope.userSession eq 'loginFailed') or (sessionScope.userSession eq 'redisEmpty')}">
    		<jsp:forward page="${pageContext.request.contextPath }/background/login.jsp"></jsp:forward>
    	</c:when>
    	<c:when test="${empty requestScope.dataPilotList}">
    		<jsp:forward page="/dataPilotAction/getAllDataPilots.action"></jsp:forward>
    	</c:when>
    </c:choose>
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
		<div class="nav-close">
			<i class="fa fa-times-circle"></i>
		</div>
		<div class="sidebar-collapse">
			<input type="hidden" value='${requestScope.dataPilotList}'
				id="dataPilot" />
			<ul class="nav" id="side-menu">
				<li class="nav-header">
					<div class="dropdown profile-element">
						<span> <img alt="用户头像" id="headImage" class="img-circle"
							style="width: 45%; height: 45%;"
							src="${pageContext.request.contextPath }/${sessionScope.userSession.headPortraits }" />
						</span> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
							class="clear"> <span class="block m-t-xs"><strong
									class="font-bold">微点餐后台管理</strong></span><span
								class="text-muted text-xs block" style="color: red">超级管理员<b
									class="caret"></b></span>
						</span>
						</a>
						<ul class="dropdown-menu animated fadeInRight m-t-xs">
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath }/userAction/getHeadPortraits.action?userName=${sessionScope.userSession.userName }">修改头像</a></li>
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath }/background/contacts.jsp">联系我们</a></li>
						</ul>
					</div>
				</li>
			</ul>
		</div>
		</nav>
		<!--左侧导航结束-->

		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<section class="publicTime">
			<p>
				<span style="color: red;">${sessionScope.userSession.role.roleName }</span>欢迎你！
			</p>
			<span id="time">2015年1月1日 11:11 星期一 </span> </section>
			<div class="row content-tabs">
				<button class="roll-nav roll-left J_tabLeft">
					<i class="fa fa-backward"></i>
				</button>
				<nav class="page-tabs J_menuTabs">
				<div class="page-tabs-content">
					<a href="javascript:;" class="active J_menuTab"
						data-id="shoppingtype.jsp">首页</a>
				</div>
				</nav>
				<button class="roll-nav roll-right J_tabRight">
					<i class="fa fa-forward"></i>
				</button>
				<div class="btn-group roll-nav roll-right">
					<button class="dropdown J_tabClose" data-toggle="dropdown">
						关闭操作<span class="caret"></span>

					</button>
					<ul role="menu" class="dropdown-menu dropdown-menu-right">
						<li class="J_tabShowActive"><a>定位当前选项卡</a></li>
						<li class="divider"></li>
						<li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
						<li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
					</ul>
				</div>
				<a
					href="${pageContext.request.contextPath }/background/shoppingtype.jsp"
					class="roll-nav roll-right J_tabExit"><i
					class="fa fa fa-sign-out"></i> 退出</a>
			</div>
			<!-- 一加载就显示数据 -->
			<div class="row J_mainContent" id="content-main">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
					src="${pageContext.request.contextPath }/background/welcomePage.jsp"
					frameborder="0" data-id="shoppingtype.jsp"></iframe>
			</div>

		</div>
		<!--右侧部分结束-->

	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/classPath.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/background/index.js">
		
	</script>
	<script
		src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath }/js/bootstrap.min.js?v=3.3.6"></script>
	<script
		src="${pageContext.request.contextPath }/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/plugins/layer/layer.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/hplus.min.js?v=4.1.0"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/contabs.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/plugins/pace/pace.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/time.js"></script>
</body>
</html>
