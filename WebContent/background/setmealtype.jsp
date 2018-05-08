<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>套餐设置页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/background/baobiao.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
	<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
   
  </head>
  
  <body>
    <div>
      <div class="inquiry">
		<form class="navbar-form" method="post" action="${pageContext.request.contextPath }/combos/getCombolist.action">
			<input name="method" value="query" class="input-text" type="hidden">
			<div class="form-group">
				<span class="poster"> 
				  <label>请输入套餐名称：</label>
				  <input type="text" id="ComboName" name="ComboName" class="form-control" value="${queryComboName }" />
				</span>
			</div>
			<button type="submit" class="btn  btn-primary">
			  <i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索
			</button>
		 <input type="hidden" name="pageIndex" value="1"/>
		<span class="increasedHead">
		  <a href="${pageContext.request.contextPath }/background/addsetmealtype.jsp">
		  <img alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png" >
		  <i class="raise">新增</i>
		  </a>
		</span>
		</form>
	</div>
      <div class="among">
      <table class="discolorationNumber" style="text-align: center;">
        <tr>
          <td>编号</td>
          <td>套餐名称</td>
          <td>操作</td>
        </tr>
        <c:forEach items="${ComboList }" var="cmb">
        <tr>
          <td><c:out value="${cmb.comboId }"></c:out> </td>
          <td><c:out value="${cmb.comboName }"></c:out></td>
          <td>
            <a href="${pageContext.request.contextPath }/combos/getUpdatecombo.action?comboId=${cmb.comboId}">
              <img alt="修改" src="${pageContext.request.contextPath }/img/zd.png">
            </a>
            <a href="javascript:deleteCombo('${cmb.comboId }');" >
              <img alt="删除" src="${pageContext.request.contextPath }/img/schu.png">
            </a>
          </td>
        </tr>
        </c:forEach>
      </table>
     </div>
     <div class="pager">
        <input type="hidden" id="totalPageCount" value="${totalPageCout}"/>
        <c:import url="combopage.jsp">
		  	<c:param name="totalCount" value="${totalCout}"/>
		  	<c:param name="currentPageNo" value="${currentPageNo}"/>
		  	<c:param name="totalPageCount" value="${totalPageCout}"/>
	 	</c:import>
     </div>
     
     
  </div>
   
    
    <script type="text/javascript">  
      function deleteCombo(comboId){
    	  if(confirm("确定要删除吗？")==true){
    		  alert("删除成功");
    	  window.location.href="${pageContext.request.contextPath }/combos/getdelcombo.action?comboId="+comboId;
    	  }
      }
 	</script>
  </body>
</html>
