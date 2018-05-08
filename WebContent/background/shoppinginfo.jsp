<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品详细信息页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/background/baobiao.css">
	
	<style type="text/css">
		.discolorationNumber{
			table-layout: fixed;  
   			width: 98% border:0px;  
    		margin: 0px;
		}
		.discolorationNumber tr td{
			text-overflow: ellipsis; /* for IE */  
    	-moz-text-overflow: ellipsis; /* for Firefox,mozilla */  
    	overflow: hidden;  
    	white-space: nowrap;  
		}
	</style>
  </head>
  
  <body>
    <div class="shoppinginfo">
     <div class="inquiry">
		<form class="navbar-form">
			<div class="form-group">
				<span class="poster"> 
				  <select name="type" class="form-control searchType">
				  	<option value="1">商品编号</option>
				  	<option value="2">菜名</option>
				  	<option value="3">创建人</option>
				  </select>
				  <input type="text" id="postName" name="postName" class="form-control postName" />
				</span>
			</div>
			<button type="button" id="search" class="btn  btn-primary searchs"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
		<span class="increasedHead">
		  <a href="${pageContext.request.contextPath }/navigation/getComNavList.action">
		  <img alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png" >
		  <i class="raise">新增</i>
		  </a>
		</span>
		</form>
	</div>
     <div class="info">
     <table class="discolorationNumber menuTable" id="menuTable">
     </table>
     </div>
     <div class="pager">
	</div>
   </div>
   <script type="text/javascript"
		src="${pageContext.request.contextPath }/js/classPath.js"></script>
   <script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
   <script src="${pageContext.request.contextPath }/js/background/shoppinginfo.js"></script>
  </body>
</html>
