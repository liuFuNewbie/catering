<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>好好吃餐厅后台管理系统-其他费用修改</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                    <div class="ibox-title">
                        <h4>
                          其他费用&nbsp;&nbsp;》&nbsp;&nbsp;其他费用&nbsp;&nbsp;》&nbsp;&nbsp;修改
                        </h4>
                    </div>
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="signupForm" action="${pageContext.request.contextPath }/else/updateElsecost.action" method="post">
							<div class="form-group">
							<%-- <input type="hidden" value="${elsecost.costId}" name="costId" id="costId" /> --%>
								<label class="col-sm-2 control-label">编号：</label>
								<div class="col-sm-3">
									<input readonly="readonly" id="costId" name="costId" class="form-control"
										type="text" value="${elsecost.costId}">
								</div>
								<label class="col-sm-2 control-label">名称：</label>
								<div class="col-sm-4">
									<input  id="costName" name="costName" class="form-control"
										type="text" value="${elsecost.costName}">
									<span class="help-block m-b-none"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">类型编号：</label>
								<div class="col-sm-3">
									<select id="costTypeId" name="costTypeId" class="form-control">
								       	<option value="1">成本支出</option>
								       	<option value="2">费用支出</option>
								       	<option value="3">资产支出</option>
								       	<option value="4">负债支出</option>
								       	<option value="5">权益支出</option>
								    </select>
								</div>
								<label class="col-sm-2 control-label">日期：</label>
								<div class="col-sm-4">
									<input id="birthdate" name="myBirthdate" class="laydate-icon form-control layer-date" type="date" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">金额：</label>
								<div class="col-sm-3" >
									<input id="money" name="money" class="form-control"
										type="text" value="${elsecost.money}">
										<span class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">员工姓名：</label>
								<div class="col-sm-4">
									<select id="empId" name="empId" class="form-control">
										 <c:forEach items="${listEmployee }" var="selectEmployeeName">
                                        <option value="${selectEmployeeName.empId }">${selectEmployeeName.empName }</option>
                                    </c:forEach>
									</select>
								</div>
							</div>
							 <div class="form-group"></div>
							 <div class="form-group"></div>
							 <div class="form-group"></div>
							<div class="form-group">
                                <div class="col-sm-7 col-sm-offset-5">
                                    <button class="btn btn-primary" type="reset">重置</button>
                                    <button class="btn btn-primary" type="submit">提交</button>
                                    <a href="${pageContext.request.contextPath }/else/getelsecostlist.action">
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
    <script src="${pageContext.request.contextPath }/js/demo/form-member-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>