<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>套餐修改页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
		
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">

  </head>
  
  <body>
     <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
          
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h4>
                          报表管理&nbsp;&nbsp;》&nbsp;&nbsp;营业报表&nbsp;&nbsp;》&nbsp;&nbsp;套餐设置&nbsp;&nbsp;》&nbsp;&nbsp;修改
                        </h4>
                    </div>
                    <br/>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="signupForm" action="${pageContext.request.contextPath }/combos/Updatecombo.action" method="post">
                            <c:forEach items="${mealtypebyId }" var="upstmeal">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">套餐名称：</label>
                                <input type="hidden" name="comboId" value="${upstmeal.comboId }"/>
                                <div class="col-sm-5">
                                    <input id="ComboName" name="ComboName" class="form-control" type="text" value=" ${upstmeal.comboName }">
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            </c:forEach>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-4">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                    <a href="${pageContext.request.contextPath }/combos/getCombolist.action">
                                      <button class="btn btn-primary" type="button">返回</button>
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
    <script src="${pageContext.request.contextPath }/js/plugins/validate/jquery.validate.min.js"></script>
    <!-- 表单验证 -->
    <script src="js/demo/form-validate-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
  </body>
</html>
