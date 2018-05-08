<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 交班管理 -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath }/css/styles.css" rel="stylesheet">
  <style>
 .inquiry{border: 1px solid transparent;margin: 10px 0px;}
 </style>
<div id="all">
	<div class="inquiry">

		<form class="navbar-form navbar-right">
			<div class="form-group">
				<label>员工名：</label><input type="text" class="form-control"
					id="employeeName" name="employeeName" />
			</div>
	<button type="button" class="btn  btn-primary"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
		<span class="increased"><a href="${pageContext.request.contextPath }/background/addchangemanage.jsp"><img alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png" ><i class="increasedName">新增</i></a></span></form>
	</div>
	<div class="tables">
		<table border="1px solid #DCDCDC">
			<tr >
				<td>编号</td>
				<td>挂账金额</td>
				<td>优惠金额</td>
				<td>前班结余</td>
				<td>实际结余</td>
				<td>交班员工</td>
				<td>接班员工</td>
				<td>密码</td>
				<td>备注</td>
				<td>操作</td>
			</tr>
			<tr>
				<td>1</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>张三</td>
				<td>李四</td>
				<td>12345678</td>
				<td>总统套房</td>
				<td><a href="${pageContext.request.contextPath }/background/updatechangemanage.jsp"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a><a href="#"><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>
			</tr>
			<tr>
				<td>1</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>张三</td>
				<td>李四</td>
				<td>12345678</td>
				<td>总统套房</td>
				<td><a href="${pageContext.request.contextPath }/background/updatechangemanage.jsp"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a><a href="#"><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>
			</tr>
			<tr>
				<td>1</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>张三</td>
				<td>李四</td>
				<td>12345678</td>
				<td>总统套房</td>
				<td><a href="${pageContext.request.contextPath }/background/updatechangemanage.jsp"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a><a href="#"><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>
			</tr>
			<tr>
				<td>1</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>张三</td>
				<td>李四</td>
				<td>12345678</td>
				<td>总统套房</td>
				<td><a href="${pageContext.request.contextPath }/background//updatechangemanage.jsp"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a><a href="#"><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>
			</tr>
			<tr>
				<td>1</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>张三</td>
				<td>李四</td>
				<td>12345678</td>
				<td>总统套房</td>
				<td><a href="${pageContext.request.contextPath }/background/updatechangemanage.jsp"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a><a href="#"><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>
			</tr>
			<tr>
				<td>1</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>张三</td>
				<td>李四</td>
				<td>12345678</td>
				<td>总统套房</td>
				<td><a href="${pageContext.request.contextPath }/background/updatechangemanage.jsp"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a><a href="#"><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>
			</tr>
			<tr>
				<td>1</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>100</td>
				<td>张三</td>
				<td>李四</td>
				<td>12345678</td>
				<td>总统套房</td>
				<td><a href="${pageContext.request.contextPath }/background/updatechangemanage.jsp"><img alt="修改" src="${pageContext.request.contextPath }/img/zd.png"></a><a href="#"><img alt="删除" src="${pageContext.request.contextPath }/img/schu.png"></a></td>
			</tr>
		</table>
	</div>
	<div class="pager">
		<ul class="clearfix">
			<li>当前页码：[16/20]</li>
			<li><a href="#">上一页</a></li>
			<li class="current"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">下一页</a></li>
		</ul>
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
	<script type="text/javascript">
$(function() {
	$("table tr:even").css("background","#dcdcdc");
  });
</script>