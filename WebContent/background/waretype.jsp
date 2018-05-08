<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sun/common-one.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/background/baobiao.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/background/baobiao.css">
    <div class="content">
			<div class="container">
				<div class="row">
					<div class="inquiry">
					<form class="navbar-form">
						<div class="form-group">
							<span class="poster"> 
							  <select name="type"  class="form-control type">
							  	<option value="warehouseId">仓库编号</option>
							  	<option value="warehouseName">仓库名称</option>
							  </select>
							  <input type="text" id="postName" name="postName" class="form-control" />
							</span>
						</div>
						<button type="button" class="btn btn-primary seek"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
					<span class="increasedHead">
					  <a href="${pageContext.request.contextPath }/warehouseTypeAction/getWaretypeadd.action">
					  <img alt="新增" src="${pageContext.request.contextPath }/img/tianjia.png" >
					  <i class="raise">新增</i>
					  </a>
					</span>
					</form>
				</div>
					<div class="col-lg-12 col-md-12 col-sm-12 purchaseInfo">
						<table class="wartable">
								<tr>
									<td>编号</td>
									<td>类型名称</td>
									<td>操作</td>
								</tr>
								<c:forEach items="${warehouseTypeList}" var="ware">
									<tr class="wartr">
										<td>${ware.warehouseId}</td>
										<td>${ware.warehouseName}</td>
										<td>
											<a class="modifyWare" href="javascript:;" warehouseId=${ware.warehouseId } warehouseName=${ware.warehouseName }><img title="修改" src="${pageContext.request.contextPath }/img/xiugai.png"/></a>&nbsp;&nbsp;&nbsp;
											<a class="deleteWare" href="javascript:;" warehouseId = ${ware.warehouseId } warehouseName = ${ware.warehouseName }><img title="删除" src="${pageContext.request.contextPath }/img/schu.png"/></a>
										</td>
									</tr>
								</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function() {
				
				//搜索部分
				$(".seek").on("click",function(){
					var postName = $("#postName").val();  //input值
					if(postName == "%"){
						seekAjax(null,null); //ajax方法
					}else{
						var type = $(".type").val(); //选中类型
						if(type == "warehouseId"){
							if(postName == null || postName == ""){
								alert("请输入要搜索的仓库编号！");
							}else{
								if(isNaN(postName)){
									alert("请输入是数字的仓库编号查询");
								}else{
									seekAjax(postName,null); //ajax方法
								}
							}
						}else if(type == "warehouseName"){
							 if(postName == null || postName == ""){
								 alert("请输入要搜索的仓库名称！");
							 }else{
								 seekAjax(null,postName); //ajax方法
							 }
						}
					}
				});
				
				//ajax方法
				function seekAjax(warehouseId,warehouseName){
					$.ajax({
						type:"GET",
						url:"${pageContext.request.contextPath }/warehouseTypeAction/getwarhousebyidorname.action",
						data:{"warehouseId":warehouseId,"warehouseName":warehouseName},
						dataType:"JSON",
						success:function(data){
							showWarInfo(data); //显示数据
						}
					});
				}
				
				//显示数据
				function showWarInfo(data){
					$(".wartr").remove();
					var $str = "";
					for(var num=0;num<data.list.length;num++){
						 $str+="<tr class='wartr'><td>"+data.list[num].warehouseId+"</td>"	
						 $str+="<td>"+data.list[num].warehouseName+"</td>"
						 $str+="<td><a class='modifyWare' href='javascript:;' warehouseId = '"+data.list[num].warehouseId+"' warehouseName = '"+data.list[num].warehouseName+"'><img title='修改' src='${pageContext.request.contextPath }/img/xiugai.png' /></a>&nbsp;&nbsp;&nbsp;<a class='deleteWare' href='javascript:;' warehouseId = '"+data.list[num].warehouseId+"' warehouseName = '"+data.list[num].warehouseName+"'><img title='删除'src='${pageContext.request.contextPath }/img/schu.png' /></a></td></tr>"
					}
					$(".wartable").append($str);
				}
				
				
				var wareObj = null;
				$(".wartable").on("click",".deleteWare",function(){
					wareObj = $(this);
					if(confirm("是否删除该《"+wareObj.attr("warehouseName")+"》 仓库吗？")){
					   deleteByWareId(wareObj);
					}
				});//询问是否删除
				
				function deleteByWareId(Obj){//删除数据库数据
					$.ajax({
						type:"GET",
						url:"${pageContext.request.contextPath }/warehouseTypeAction/delware/"+Obj.attr("warehouseId")+".action",
						data:'',
						dataType:"text",
						success:function(data){
							if(data == "true"){
								Obj.parents("tr").remove();
								window.location.href="${pageContext.request.contextPath }/warehouseTypeAction/getAllWarehouseType.action";
							}
						}
					});
				}
				
				//访问修改页面
				$(".wartable").on("click",".modifyWare",function(){
					var obj = $(this);
					window.location.href="${pageContext.request.contextPath }/warehouseTypeAction/getupdateware.action?warehouseId="+obj.attr("warehouseId")+"&warehouseName="+obj.attr("warehouseName");
				});
			  });
       </script>