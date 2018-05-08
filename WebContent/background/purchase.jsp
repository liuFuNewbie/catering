<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sun/common-one.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/background/baobiao.css" />
<div class="content">
	<div class="container">
		<div class="row">
			<div class="inquiry">
				<form class="navbar-form">
					<div class="form-group">
						<span class="poster"> <label>请输入商品名称：</label> <input
							type="text" id="postName" name="postName" class="form-control" />
						</span>
					</div>
					<button type="button" class="btn btn-primary">
						<i><img
							src="${pageContext.request.contextPath }/img/search.png" /></i>搜索
					</button>
					<span class="increasedHead"> <a
						href="${pageContext.request.contextPath }/purchaseAction/getPurchaseAdd.action">
							<img alt="新增"
							src="${pageContext.request.contextPath }/img/tianjia.png">
							<i class="raise">新增</i>
					</a>
					</span>
				</form>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 purchaseInfo">
				<table class="purinfo">
					<tr>
						<td>编号</td>
						<td>商品名称</td>
						<td>数量</td>
						<td>单位</td>
						<td>金额</td>
						<td>日期</td>
						<td>采购状态</td>
						<td>操作</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath }/js/background/purchase.js" type="text/javascript" charset="utf-8"></script>