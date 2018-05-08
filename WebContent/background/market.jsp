<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>销售查询页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/background/baobiao.css">
	<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	
  </head>
  <body>
    <div>
      <div class="inquiry">
		<form class="navbar-form" action="${pageContext.request.contextPath }/markets/getmarketlist.action" method="post">
			<div class="form-group">
				<span class="poster"> 
				  <label>请输入商品名称：</label>
				  <input type="text" id="marketName" name="marketName" class="form-control" value="${queryMarketName }" />
				</span>
			</div>
			<input type="hidden" name="pageIndex" value="1"/>
			<button type="submit" class="btn  btn-primary"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
		<span class="increasedHead">
		  <a href="${pageContext.request.contextPath }/markets/getByAddMarket.action">
		  <img alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png" >
		  <i class="raise">新增</i>
		  </a>
		</span>
		</form>
	</div>
      <div class="">
        <table class="discolorationNumber" style="text-align: center;">
          <tr>
	        <td class="number">编号</td>
	        <td>菜名</td>
	        <td class="math">餐桌号</td>
	        <td class="math">成本</td>
	        <td class="math">数量</td>
	        <td class="math">售价</td>
	        <td class="math">盈亏</td>
	        <td class="math">总金额</td>
	        <td>日期</td>
	        <td>员工姓名</td>
	        <td>操作</td>
	      </tr>
	      <c:forEach items="${MarketList }" var="marketes">
	       <tr>
	        <td><c:out value="${marketes.marketId }"></c:out></td>
	        <td><c:out value="${marketes.menuName }"></c:out></td>
	        <td><c:out value="${marketes.tableNo }"></c:out></td>
	        <td><c:out value="${marketes.cost }"></c:out></td>
	        <td><c:out value="${marketes.number }"></c:out></td>
	        <td><c:out value="${marketes.unitPrice }"></c:out></td>
	        <td><c:out value="${marketes.profitLoss }"></c:out></td>
	        <td><c:out value="${marketes.totalMoney }"></c:out></td>
	        <td>
	          <fmt:formatDate value="${marketes.dataTime }" pattern="yyyy-MM-dd"/>
	        </td> 
	        <td><c:out value="${marketes.empName }"></c:out></td>
	        <td>
	          <a href="${pageContext.request.contextPath }/markets/getmarketBylist.action?marketId=${marketes.marketId }">
              <img alt="修改" src="${pageContext.request.contextPath }/img/zd.png">
            </a>
            <a href="javascript:deleteMarket('${marketes.marketId }');" class="shanchu">
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
      function deleteMarket(marketId){
    	  if(confirm("确定要删除吗？")==true){
    		  alert("删除成功");
    	  window.location.href="${pageContext.request.contextPath }/markets/getdelMarketId.action?marketId="+marketId;
    	  }
      }
 	</script>
  </body>
</html>
