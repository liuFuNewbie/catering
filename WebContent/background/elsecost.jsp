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
<div id="all">
	<div class="inquiry">
		<form class="navbar-form navbar-right" action="${pageContext.request.contextPath }/else/getelsecostlist.action" method="post">
			<div class="form-group">
				<label>类型：</label> 
				<select id="costName" name="costName" class="form-control" value="${querycostName }">
			        <option value="">查询全部</option>
			       	<option value="1">成本支出</option>
			       	<option value="2">费用支出</option>
			       	<option value="3">资产支出</option>
			       	<option value="4">负债支出</option>
			       	<option value="5">权益支出</option>
			    </select>
			    <input type="hidden" name="pageIndex" value="1"/>
			</div>
			<button type="submit" class="btn  btn-primary"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
			<span class="increased">
			<a href="${pageContext.request.contextPath }/else/getselelsecost.action">
			<img alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png" >
			<i class="increasedName">新增</i></a></span>
		</form>
	</div> 
	<div class="tables">
		<table>
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>金额</td>
				<td>日期</td>
				<td>类型编号</td>
				<td>员工编号</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${requestScope.list }" var="mem">
			<fmt:formatDate value="${mem.createDate }" pattern="yyyy-MM-dd" var="dates"/>
        <tr>
          <td>${mem.costId }</td>
          <td>${mem.costName }</td>
          <td>${mem.money }</td>
          <td>${dates }</td>
          <td>${mem.name }</td>
          <td>${mem.empName }</td>
          <td>
			<a href="${pageContext.request.contextPath }/else/getupdateElsecost.action?costId=${mem.costId}"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a>
			<a href="javascript:;" costId = '${mem.costId }' class="delCost" ><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>
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
	<script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/layer/layer.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/hplus.min.js?v=4.1.0"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/contabs.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/pace/pace.min.js"></script>
	
	<script>
	   $(function(){
		   
		   var delObj = null; //获取当前点击对象
		   $(".delCost").on("click",function(){
			   delObj = $(this);
			if(confirm("是否删除该数据吗？")){
				$.ajax({
					type:"GET",
					url:"${pageContext.request.contextPath }/else/deleteelsecostid.action",
					data:{"costId":delObj.attr("costId")},
					dataType:"text",
					success:function(data){
						if(data == "true"){
							delObj.parents("tr").remove();
						}
					}
				});
			}
		   });
		   
	   });
	</script>
