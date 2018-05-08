<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<link href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/css/sun/inventory.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/background/baobiao.css" />
		<div class="content">
				<div class="inquiry">
					<form class="navbar-form">
						<div class="form-group">
							<span class="poster"> 
							  <label>请输入编号/名称：</label>
							  <input type="text" id="postName" name="postName" class="form-control" />
							</span>
						</div>
						<button type="button" class="btn btn-primary"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
					<span class="increasedHead">
					  <a href="${pageContext.request.contextPath }/background/inventoryadd.jsp">
					  <img alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png" >
					  <i class="raise">新增</i>
					  </a>
					</span>
					</form>
				</div>
			<div class="inventoryinfo">
				<table border="1">
					<tr>
						<td>编号</td>
						<td>仓库类型</td>
						<td>商品名称</td>
						<td>单位</td>
						<td>采购Id</td>
						<td>调拨入库</td>
						<td>报益</td>
						<td>入库小计</td>
						<td>调拨出库</td>
						<td>报损</td>
						<td>领料出货</td>
						<td>出库小计</td>
						<td>总金额</td>
						<td>日期</td>
						<td>备注</td>
						<td>操作</td>
					</tr>
					<tr>
						<td>123</td>
						<td>52</td>
						<td> 解决</td>
						<td>公开</td>
						<td>663</td>
						<td>62</td>
						<td>923</td>
						<td>932</td>
						<td>63</td>
						<td>66</td>
						<td>85</td>
						<td>665</td>
						<td>8888</td>
						<td>566</td>
						<td>145</td>
						<td>
							<a href="${pageContext.request.contextPath }/background/inventorymodify.jsp"><img title="修改" src="${pageContext.request.contextPath }/img/xiugai.png"/></a>&nbsp;&nbsp;&nbsp;
							<a href="#"><img title="删除" src="${pageContext.request.contextPath }/img/schu.png"/></a>
						</td>
					</tr>
			</table>			
			</div>			
		</div>
		