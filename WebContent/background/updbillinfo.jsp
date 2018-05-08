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
    
    <title>账单明细修改页面</title>
    
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
                          报表管理&nbsp;&nbsp;》&nbsp;&nbsp;营业报表&nbsp;&nbsp;》&nbsp;&nbsp;账单明细&nbsp;&nbsp;》&nbsp;&nbsp;修改
                        </h4>
                    </div>
                    <br/>
                    <div class="ibox-content">
                        <form action="${pageContext.request.contextPath }/billAction/getUpdateBillInfo.action" method="post" class="form-horizontal m-t" id="signupForm">
                          <c:forEach items="${marketBylist }" var="bill">
                            <input name="marketId" type="hidden" value="${bill.marketId }">
                            <input name="menuId" type="hidden" value="${bill.menuId }">
                            <input name="materialId" type="hidden" value="${bill.materialId }">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名：</label>
                                <div class="col-sm-4">
                                    <input name="memberId" type="hidden" value="${bill.memberId }">
                                    <input value="${bill.memberName }" id="memberName" name="memberName" class="form-control" type="text">
                                    <span class="help-block m-b-none"></span>
                                </div>
                                <label class="col-sm-2 control-label">套餐类型名称：</label>
                                <div class="col-sm-3">
                                    <select id="ComboType" name="ComboType" class="form-control">
								        <c:forEach items="${listCombos }" var="comboss">
								          <option value="${comboss.comboId }">${comboss.comboName }</option>
								        </c:forEach>
								    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">会员编号：</label>
                                <div class="col-sm-4">
                                    <input disabled="disabled" value="${bill.account }" id="account" name="account" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                </div>
                                <label class="col-sm-2 control-label">消费金额：</label>
                                <div class="col-sm-3">
                                    <input value="${bill.totalMoney }" id="totalMoney" name="totalMoney" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">优惠状态：</label>
                                <div class="col-sm-4">
                                    <input value="${bill.discount }" id="discount" name="discount" class="form-control" type="text">
                                </div>
                                <label class="col-sm-2 control-label">收款方式：</label>
                                <div class="col-sm-3">
                                    <select id="payType" name="payType" class="form-control">
								        <option value="1">微信</option>
								        <option value="2">支付宝</option>
								        <option value="3">现金</option>
								    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注：</label>
                                <div class="col-sm-4">
                                    <input value="${bill.describe }" id="describe" name="describe" class="form-control" type="text">
                                </div>
                                <label class="col-sm-2 control-label">收款人：</label>
                                <div class="col-sm-3">
                                	<select id="employee" name="employee" class="form-control">
								        <c:forEach items="${listEmployees }" var="employeesName">
								          <option value="${employeesName.empId }">${employeesName.empName }</option>
								        </c:forEach>
								    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-4">
                                    <button class="btn btn-primary" type="reset">重置</button>
                                    <button class="btn btn-primary" type="submit">提交</button>
                                    <a href="${pageContext.request.contextPath }/billAction/getBillInfolist.action">
                                      <button class="btn btn-primary" type="button">返回</button>
                                    </a>
                                </div>
                            </div>
                          </c:forEach>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath }/js/plugins/validate/jquery.validate.min.js"></script>
    <!-- 表单验证 -->
    <script src="${pageContext.request.contextPath }/js/demo/form-addbillinfo-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
  </body>
</html>
