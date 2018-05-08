<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- 员工岗位信息管理-->
<link href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/styles.css" rel="stylesheet">
<div id="all">
	<div class="inquiry">
		<form class="navbar-form navbar-right" action="${pageContext.request.contextPath }/member/getMemberlist.action" method="post">
			<div class="form-group">
				<label>姓名：</label><input type="text" id="MemberName" name="MemberName" class="form-control" value="${queryComboName }"/>
			</div>
			<input type="hidden" name="pageIndex" value="1"/>
			<button type="submit" class="btn  btn-primary">
			<i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索
			</button>
			<span class="increased">
			<a href="${pageContext.request.contextPath }/background/addmember.jsp">
			<img alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png" >
			<i class="increasedName">新增</i></a></span>
		</form>
	</div>
	<div class="tables">
		<table >
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>会员账号</td>
				<td>性别</td>
				<td>卡类型</td>
				<td>积分</td>
				<td>余额</td>
				<td>消费总额</td>
				<td>生日</td>
				<td>联系电话</td>
				<td>开卡日期</td>
				<td>状态</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${requestScope.list }" var="mem">
			<fmt:formatDate value="${mem.birthdate }" pattern="yyyy-MM-dd" var="dates"/>
			<fmt:formatDate value="${mem.createDate }" pattern="yyyy-MM-dd" var="datess"/>
        <tr>
          <td>${mem.memberId }</td>
          <td>${mem.memberName }</td>
          <td>${mem.account }</td>
          <td>${mem.gender }</td>
          <td>${mem.cardId }</td>
          <td>${mem.integral }</td>
          <td>${mem.balance }</td>
          <td>${mem.totalConsumption }</td>
          <td>${dates}</td>
          <td>${mem.phone }</td>
          <td>${datess}</td>
          <td>${mem.state }</td>
          <td>
			<a href="${pageContext.request.contextPath }/member/getUpdatemember.action?memberId=${mem.memberId}"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a>
			<a href="javascript:;" memberId = '${mem.memberId }' class="delCost" ><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a>
			<a href=""> <img onclick="guashi()" alt="挂失" src="${pageContext.request.contextPath }/img/shangsuo.png">
			<img onclick="jiegau()" alt="解挂" src="${pageContext.request.contextPath }/img/kaisuo.png"> </a>
		  </td>
        </tr>
        </c:forEach>
		</table>
	</div>
	<div class="pager">
       <input type="hidden" id="totalPageCount" value="${requestScope.totalPageCout}"/>
        <c:import url="memberpage.jsp">
		  	<c:param name="totalCount" value="${requestScope.totalCout}"/>
		  	<c:param name="currentPageNo" value="${requestScope.currentPageNo}"/>
		  	<c:param name="totalPageCount" value="${requestScope.totalPageCout}"/>
	 	</c:import>
	 </div>
	 
  </div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/background/updmember.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${pageContext.request.contextPath }/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath }/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath }/js/plugins/layer/layer.min.js"></script>
<script src="${pageContext.request.contextPath }/js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/contabs.min.js"></script>
<script src="${pageContext.request.contextPath }/js/plugins/pace/pace.min.js"></script>
<script src="${pageContext.request.contextPath }/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath }/js/form-validate-demo.min.js"></script>
<script type="text/javascript">

	
	function guashi() {
		var r = confirm("确定要挂失吗？");
		if(r == true) {
			alert("挂失成功！");
		} else {
			alert("挂失已取消。。。");
		}
	};

	function jiegau() {
		var r = confirm("确定要解挂吗？");
		if(r == true) {
			alert("解挂成功！");
		} else {
			alert("解挂已取消。。。");
		}
	};

</script>
<script>
	   $(function(){
		   var delObj = null; //获取当前点击对象
		   $(".delCost").on("click",function(){
			   delObj = $(this);
			if(confirm("是否删除该数据吗？")){
				$.ajax({
					type:"GET",
					url:"${pageContext.request.contextPath }/member/delmember.action",
					data:{"memberId":delObj.attr("memberId")},
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
  