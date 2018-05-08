<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加会员信息页面</title>
    
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
                           会员管理&nbsp;&nbsp;》&nbsp;&nbsp;会员卡管理&nbsp;&nbsp;》&nbsp;&nbsp;添加
                        </h4>
                    </div>
                    <br/>
                     <div class="ibox-content">
                       <form class="form-horizontal m-t" id="signupForm" action="${pageContext.request.contextPath }/member/getaddmember.action" method="post">
							<div class="form-group">
								<label class="col-sm-2 control-label">会员姓名：</label>
								<div class="col-sm-3">
									<input id="memberName" name="memberName" class="form-control"
										type="text">
									<span class="help-block m-b-none"></span>
								</div>

								<label class="col-sm-2 control-label">会员账号：</label>
								<div class="col-sm-4">
									<input readonly="readonly" id="account" name="account" class="form-control"
										type="text" value="">
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
									<input id="myBirthdate" name="myBirthdate"
										class="laydate-icon form-control layer-date" type="date" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">电话号码：</label>
								<div class="col-sm-3">
									<input id="phone" name="phone" class="form-control"
										type="text">
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
										type="text">
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
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
    $(function (){
		 var num="";
			for ( var i = 0; i < 7; i++) {
				num+=Math.floor(Math.random()*10);
			} 
			document.getElementById("account").value=num;
			});
    </script>  
    <script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath }/js/plugins/validate/jquery.validate.min.js"></script>
    <!-- 表单验证 -->
    <script src="${pageContext.request.contextPath }/js/demo/form-member-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
  </body>
</html>
