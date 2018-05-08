<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>仓库类型新增页面</title>
    
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
                          &nbsp;&nbsp;报表管理&nbsp;&nbsp;》&nbsp;&nbsp;仓库报表&nbsp;&nbsp;》&nbsp;&nbsp;仓库类型&nbsp;&nbsp;》&nbsp;&nbsp;新增
                        </h4>
                    </div>
                    <br/>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="signupForm" method="post" action="${pageContext.request.contextPath }/warehouseTypeAction/insertWaretSave.action">
                            <div class="form-group">
                                <label class="col-sm-3 control-label" id="warename">仓库类型名称：</label>
                                <div class="col-sm-5">
                                    <input id="warehouseName" name="warehouseName" class="form-control" type="text">
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-4">
                                    <button class="btn btn-primary" id="addWare" type="button">提交</button>
                                    <a>
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
   <%--  <script src="${pageContext.request.contextPath }/js/plugins/validate/jquery.validate.min.js"></script> --%>
    <!-- 表单验证 -->
    <%-- <script src="${pageContext.request.contextPath }/js/demo/form-warehousetype-demo.min.js"></script> --%>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <script type="text/javascript">
       $(function(){
    	   
    	   $("#warehouseName").focus(function(){
    		   $("#warename").css("color","#3c763d");
			   $("#warehouseName").css({"border-color":"#3c763d"}).next().html("");
    	   });//获取焦点
    	   
    	   $("#addWare").on("click",function(){
    		   var warehouseName = $("#warehouseName").val();
    		   if(warehouseName == null || warehouseName == "" || $.trim(warehouseName) == ""){
    			   $("#warename").css("color","red");
    			   $("#warehouseName").css({"border-color":"red"}).next().html("请输入仓库名称").css("color","red");
        		   return false;
        	   }else{
        		   $.ajax({//异步查询是否存在同一个仓库名
        			   type:"GET",
        			   url:"warehouseTypeAction/waretypeExist.action?warehouseName="+warehouseName,//请求的url
        				dataType:"text",//ajax接口（请求url）返回的数据类型
        				success:function(data){//data：返回数据（json对象）
        					if(data != null){
        					if(data == "false"){//仓库已存在，错误提示
        						$("#warename").css("color","red");
        						$("#warehouseName").css({"border-color":"red"}).next().html("该仓库名称已存在").css("color","red");
        					    return false;
        					}else if(data == "true"){//仓库可用，正确提示
        						if(confirm("是否确认提交数据")){
        						    $("#signupForm").submit();
        						}
        					}}
        				}
        		   });
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
