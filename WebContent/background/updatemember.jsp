<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>好好吃餐厅后台管理系统-会员修改</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                    <div class="ibox-title">
                        <h4>
                          会员管理&nbsp;&nbsp;》&nbsp;&nbsp;会员卡管理&nbsp;&nbsp;》&nbsp;&nbsp;修改
                        </h4>
                    </div>
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="signupForm" action="${pageContext.request.contextPath }/member/updatemember.action" method="post">
							<div class="form-group">
							<input type="hidden" value="${member.memberId}" name="memberId" id="memberId" />
								<label class="col-sm-2 control-label">会员姓名：</label>
								<div class="col-sm-3">
									<input  id="memberName" name="memberName" class="form-control"
										type="text" value="${member.memberName}">
									<span class="help-block m-b-none"></span>
								</div>

								<label class="col-sm-2 control-label">会员账号：</label>
								<div class="col-sm-4">
									<input readonly="readonly" id="account" name="account" class="form-control"
										type="text" value="${member.account}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">性别：</label>
								<div class="col-sm-3">
									<select id="gender" name="gender" class="form-control">
								        <option>男</option>
								        <option>女</option>
								    </select>
								</div>
								<label class="col-sm-2 control-label">出生日期：</label>
								<div class="col-sm-4">
									<input id="birthdate" name="myBirthdate" class="laydate-icon form-control layer-date" type="date" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">电话号码：</label>
								<div class="col-sm-3" >
									<input id="phone" name="phone" class="form-control"
										type="text" value="${member.phone}">
										<span class="help-block m-b-none"></span>
								</div>
								<label class="col-sm-2 control-label">会员卡状态：</label>
								<div class="col-sm-4">
									<select id="state" name="state" class="form-control">
										<option value="0">未激活</option>
										<option value="1">已激活</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">余额：</label>
								<div class="col-sm-3">
									<input id="balance" name="balance" class="form-control"
										type="text" value="${member.balance}" >
								</div>
								<label class="col-sm-2 control-label">会员卡类型：</label>
								<div class="col-sm-4">
									<select id="cardId" name="cardId" class="form-control">
										<option value="1">大众会员</option>
								        <option value="2">黄金会员</option>
								        <option value="3">钻石会员</option>
									</select>
								</div>
							</div>
							<div class="form-group">
                                <div class="col-sm-8 col-sm-offset-4">
                                    <button class="btn btn-primary" type="reset">重置</button>
                                    <button class="btn btn-primary" type="submit">提交</button>
                                    <a href="${pageContext.request.contextPath }/member/getMemberlist.action">
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