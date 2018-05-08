<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付方式新增页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
		
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/background/addshoppingtype.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/animate.min.css">
  </head>
  
  <body>
     <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
          
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h4>
                            &nbsp;&nbsp;报表管理&nbsp;&nbsp;》&nbsp;&nbsp;营业报表&nbsp;&nbsp;》&nbsp;&nbsp;支付类别&nbsp;&nbsp;》&nbsp;&nbsp;新增
                        </h4>
                    </div>
                    <br/>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="payForm" action="${pageContext.request.contextPath }/paytype/insertPayType.action" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">支付类别名称：</label>
                                <div class="col-sm-5">
                                    <input id="payName" name="payName" class="form-control" type="text">                                
                                </div>
                                <div class="error" id="error">
                                	<span class="mismark" id="mismark">✘</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" id="btnPay" type="button">提交</button>&nbsp;&nbsp;&nbsp;
                                      <button class="btn btn-primary" id="btnReturn" type="button">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath }/js/plugins/validate/jquery.validate.min.js"></script>
    <!-- 表单验证 -->
    <script src="${pageContext.request.contextPath }/js/demo/form-validate-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/background/addpayoffmode.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/background/return.js"> </script>
  </body>
</html>
