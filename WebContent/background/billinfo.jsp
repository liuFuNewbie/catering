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
    
    <title>账单明细页面</title>
    
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
		<form action="${pageContext.request.contextPath }/billAction/getBillInfolist.action" method="post" class="navbar-form">
			<div class="form-group">
				<span class="poster"> 
				  <label>用户姓名：</label>
				  <input value="${queryMemberName }" type="text" id="memberName" name="memberName" class="form-control" />
				</span>
			</div>
			<input type="hidden" name="pageIndex" value="1"/>
			<button type="submit" class="btn  btn-primary"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
		</form>
	</div>
      <div class="billinfo">
        <table class="discolorationNumber" style="text-align: center;">
          <tr>
	        <td>编号</td>
	        <td>用户姓名</td>
	        <td>套餐名称</td>
	        <td>会员编号</td>
	        <td>消费金额</td>
	        <td>优惠状态</td>
	        <td>优惠金额</td>
	        <td>收款方式</td>
	        <td>实际收款</td>
	        <td>收款时间</td>
	        <td>收款人</td>
	        <td class="remarks">备注</td>
	        <td>操作</td>
	      </tr>
	      <c:forEach items="${BillInfoList }" var="bill">
	       <tr>
	        <td><c:out value="${bill.marketId }"></c:out></td>
	        <td><c:out value="${bill.memberName }"></c:out></td>
	        <td><c:out value="${bill.comboName }"></c:out></td>
	        <td><c:out value="${bill.account }"></c:out></td>
	        <td><c:out value="${bill.totalMoney }"></c:out></td>
	        <td><c:out value="${bill.discount }"></c:out></td>
	        <td><c:out value="${bill.saleMoney }"></c:out></td>
	        <td><c:out value="${bill.payName }"></c:out></td>
	        <td><c:out value="${bill.factMoney }"></c:out></td>
	        <td>
	          <fmt:formatDate value="${bill.dataTime }" pattern="yyyy-MM-dd"/>
	        </td>
	        <td>
	          <c:out value="${bill.empName }"></c:out>
	        </td>
	        <td><c:out value="${bill.describe }"></c:out></td>
	        <td>
	          <a href="${pageContext.request.contextPath }/billAction/getBillInfoBylist.action?marketId=${bill.marketId }">
              <img alt="修改" src="${pageContext.request.contextPath }/img/zd.png">
            </a>
            <a href="javascript:deleteMarket('${bill.marketId }');" class="shanchu">
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
    	  window.location.href="${pageContext.request.contextPath }/billAction/getdeleteBillInfo.action?marketId="+marketId;
    	  }
      }
 	</script>
  </body>
</html>
