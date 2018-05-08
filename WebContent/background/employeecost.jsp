<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- 员工岗位信息管理-->
<link href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath }/css/styles.css" rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/background/baobiao.css">
  <style>
 .inquiry{border: 1px solid transparent;margin: 10px 0px;}
 </style>
<div id="all">
	<div class="inquiry">
		<form class="navbar-form navbar-right" action="${pageContext.request.contextPath }/employee/getEmployeelist.action" method="post"> 
			<div class="form-group">
				<span class="poster"> <label>姓名：</label><input type="text"
					id="empName" name="empName" class="form-control" value="${queryemlName }" />
				</span> 
			</div>
			<input type="hidden" name="pageIndex" value="1"/>
			<button type="submit" class="btn  btn-primary"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
		</form>
	</div>
	<div class="tables">
		<table>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>日期</td>
				<td>工资</td>
				<td>奖金</td>
			</tr>
				<c:forEach items="${requestScope.list }" var="mem">
				<fmt:formatDate value="${mem.createDate }" pattern="yyyy-MM-dd" var="dates"/>
        <tr>
          <td>${mem.empId }</td>
          <td>${mem.empName }</td>
          <td>${mem.gender }</td>
          <td>${dates }</td>
          <td>${mem.salary }</td>
          <td>${mem.bonus }</td>
        </tr>
        </c:forEach>
		</table>
	</div>
	<div class="pager">
		 <input type="hidden" id="totalPageCount" value="${requestScope.totalPageCout}"/>
        <c:import url="employeepage.jsp">
		  	<c:param name="totalCount" value="${requestScope.totalCout}"/>
		  	<c:param name="currentPageNo" value="${requestScope.currentPageNo}"/>
		  	<c:param name="totalPageCount" value="${requestScope.totalPageCout}"/>
	 	</c:import>
	</div>
</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/layer/layer.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/hplus.min.js?v=4.1.0"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/contabs.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/pace/pace.min.js"></script>
