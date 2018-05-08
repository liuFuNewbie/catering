<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sun/common-one.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/background/baobiao.css" />
    <div class="content">
			<div class="container">
				<div class="row">
					<div class="inquiry">
					<form class="navbar-form">
						<div class="form-group">
							<span class="poster"> 
							  <label>请输入编号和或名称：</label>
							  <input type="text" id="postName" name="postName" class="form-control" />
							</span>
						</div>
						<button type="button" class="btn btn-primary"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
					<span class="increasedHead">
					  <a href="${pageContext.request.contextPath }/background/breakageadd.jsp">
					  <img alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png" >
					  <i class="raise">新增</i>
					  </a>
					</span>
					</form>
				</div>
					<div class="col-lg-12 col-md-12 col-sm-12 purchaseInfo">
						<table border="1">
							<thead>
								<tr>
									<td>编号</td>
									<td>商品名称</td>
									<td>单据类型</td>
									<td>单位</td>
									<td>单价</td>
									<td>数量</td>
									<td>金额</td>
									<td>仓库类型</td>
									<td>日期</td>
									<td>经手人</td>
									<td>备注</td>
									<td>操作</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>222</td>
									<td>订单</td>
									<td>33</td>
									<td>56</td>
									<td>965</td>
									<td>525</td>
									<td>52</td>
									<td>56</td>
									<td>965</td>
									<td>525</td>
									<td>52</td>
									<td>
										<a href="${pageContext.request.contextPath }/background/breakagemodify.jsp"><img title="修改" src="${pageContext.request.contextPath }/img/xiugai.png"/></a>&nbsp;&nbsp;&nbsp;
										<a href="#"><img title="删除" src="${pageContext.request.contextPath }/img/schu.png"/></a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>