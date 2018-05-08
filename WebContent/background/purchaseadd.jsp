<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>采购订单新增</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
		
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/animate.min.css">

  </head>
  
  <body>
     <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h4>
                          &nbsp;&nbsp;报表管理&nbsp;&nbsp;》&nbsp;&nbsp;往来业务&nbsp;&nbsp;》&nbsp;&nbsp;新增
                        </h4>
                    </div>
                    <br/>
                     <div class="ibox-content">
                        <form class="form-horizontal m-t" id="signupForm" method="post" action="${pageContext.request.contextPath }/purchaseAction/insertPurSave.action">
                            <div class="form-groupe">
                                <label class="col-sm-2 control-label">商品名称：</label>
                                <div class="col-sm-3">
                                    <input id="shoppingName" name="shoppingName" class="form-control" type="text">
                                    <span class="help-block m-b-none"></span>
                                </div>
                                <label class="col-sm-2 control-label">数量：</label>
                                <div class="col-sm-4">
                                    <input id="number" name="number" class="form-control" type="text">
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单位：</label>
                                <div class="col-sm-3">
                                     <input id="unit" name="unit" class="form-control" type="text">
                                     <span class="help-block m-b-none"></span>
                                </div>
                                <label class="col-sm-2 control-label">金额：</label>
                                <div class="col-sm-4">
                                    <input id="money" name="money" class="form-control" type="text">
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">采购状态：</label>
                                <div class="col-sm-3">
                                    <select class="form-control" name="state" id="state">
                                    	<option value="0" selected="selected">未交付</option>
                                    	<option value="1">已交付</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-4">
                                    <button class="btn btn-primary" type="reset">重置</button>
                                    <button class="btn btn-primary" type="button" id="purAdd">提交</button>
                                    <a href="${pageContext.request.contextPath }/background/purchase.jsp">
                                      <button class="btn btn-primary" type="button" id="back">返回</button>
                                    </a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
    <%-- <script src="${pageContext.request.contextPath }/js/plugins/validate/jquery.validate.min.js"></script>
    <!-- 表单验证 -->
    <script src="${pageContext.request.contextPath }/js/demo/form-purchase-demo.min.js"></script> --%>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
     <script type="text/javascript">
       $(function(){
    	   var flay = true;
    	    
    	    $("#shoppingName").focus(function(){
    	    	$("#shoppingName").next().html("");
    	    });
    	    
    	    $("#number").focus(function(){
    	    	$("#number").next().html("");
    	    });
    	    
    	    $("#unit").focus(function(){
    	    	$("#unit").next().html("");
    	    });
    	    
    	    $("#money").focus(function(){
    	    	$("#money").next().html("");
    	    });
    	    
    	    $("#purAdd").on("click",function(){
     		   var shoppingName = $("#shoppingName").val();
     		   var number =$("#number").val();
     		   var number =$("#unit").val();
     		   var number =$("#money").val();
     		   if(shoppingName == null || shoppingName.length <= 0 || shoppingName == ""){
     			  $("#shoppingName").next().html("商品名称不能为空").css("color","red");
         		   return false;
     		   }else if(number == null || number.length <= 0 || number == ""){
     			  $("#number").next().html("商品数量不能为空").css("color","red");
     			  return false;
     		   }else if(number<=0){
     			  $("#number").next().html("商品数量不能等于小于0").css("color","red");
     			  return false;
     		   }else if(unit == null || unit.length <= 0 || unit == ""){
     			  $("#unit").next().html("商品单位不能为空").css("color","red");
     			  return false;
     		   }else if(money == null || money.length <= 0 || money == ""){
     			  $("#money").next().html("金额不能为空").css("color","red");
     			  return false;
     		   }else if(money <= 0){
     			  $("#money").next().html("金额不能小于等于0").css("color","red");
     		   }else{
     			  if(confirm("是否确认提交数据")){
  				    $("#signupForm").submit();
  				}
     		   }
     	   });
    	    
    	    
    	    
    	  //返回上一级页面
     	   $("#back").on("click",function(){
     		   history.back(-1);
     	   });
    	    
       });
    </script>
  </body>
</html>
