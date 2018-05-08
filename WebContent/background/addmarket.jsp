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
    
    <title>销售查询新增页面</title>
    
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
                          报表管理&nbsp;&nbsp;》&nbsp;&nbsp;营业报表&nbsp;&nbsp;》&nbsp;&nbsp;销售查询页面&nbsp;&nbsp;》&nbsp;&nbsp;新增
                        </h4>
                    </div>
                    <br/>
                    <div class="ibox-content">
                        <form action="${pageContext.request.contextPath }/markets/getAddMarket.action" method="post" class="form-horizontal m-t" id="signupForm">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">商品名称：</label>
                                <div class="col-sm-3">
                                    <select name="selectMenu" style="width: 260px;height: 35px;">
                                      <c:forEach items="${listMenu }" var="selectMenuName">
                                        <option value="${selectMenuName.menuId }">${selectMenuName.menuName }</option>
                                      </c:forEach>
                                    </select>
                                </div>
                                <label class="col-sm-2 control-label">数量：</label>
                                <div class="col-sm-4">
                                    <input id="number" name="number" class="form-control" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单价：</label>
                                <div class="col-sm-3">
                                    <input id="unitPrice" name="unitPrice" class="form-control" type="text" class="valid">
                                </div>
                                <label class="col-sm-2 control-label">成本：</label>
                                <div class="col-sm-4">
                                    <input id="cost" name="cost" class="form-control" type="text" class="valid">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label class="col-sm-2 control-label">餐桌号：</label>
                                <div class="col-sm-3">
                                    <input id="tableNo" name="tableNo" class="form-control" type="text" class="valid">
                                </div>
                                <label class="col-sm-2 control-label">员工姓名：</label>
                                <div class="col-sm-3">
                                    <select name="selectEmployee" style="width: 260px;height: 35px;">
                                    <c:forEach items="${listEmployee }" var="selectEmployeeName">
                                        <option value="${selectEmployeeName.empId }">${selectEmployeeName.empName }</option>
                                    </c:forEach>
                                  </select>
                                </div>
                            </div>
                            <div class="form-group">
                            	<label class="col-sm-2 control-label">备注：</label>
                            	<div class="col-sm-3">
                                    <input id="describe" name="describe" class="form-control" type="text" class="valid">
                                </div>
                                <label class="col-sm-2 control-label">会员姓名：</label>
                                <div class="col-sm-3">
                                    <select name="memberNameType" style="width: 260px;height: 35px;">
                                    <c:forEach items="${listMemberName }" var="MemberName">
                                        <option value="${MemberName.memberId }">${MemberName.memberName }</option>
                                    </c:forEach>
                                  </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-4">
                                	<button class="btn btn-primary" type="reset">重置</button>
                                    <button class="btn btn-primary" type="submit">提交</button>
                                    <a href="${pageContext.request.contextPath }/markets/getmarketlist.action">
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
    <script src="${pageContext.request.contextPath }/js/demo/form-market-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
  </body>
</html>
