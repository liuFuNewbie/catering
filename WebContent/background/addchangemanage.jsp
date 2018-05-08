<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 新增交班管理 -->
 <link href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
 <link href="${pageContext.request.contextPath }/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
 <link href="${pageContext.request.contextPath }/css/styles.css" rel="stylesheet">
 <style>
     .places{background: lavender;height: 40px;line-height: 40px;margin-bottom: 20px;position: relative;left: -80px;}
	.places img{margin: 0px 15px;}
	.place{color: lightskyblue;font-weight: bolder;}
 </style>
 	<div id="all">
 			<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
                         <label class="col-sm-2"></label>
                        <div class="col-sm-8">
                        	 <div class="places"><img alt="位置" src="${pageContext.request.contextPath }/img/home.png">你现在所在的位置是：<span class="place">新增交班管理页面</span></div>
                         </div>
                    </div>
					<div class="ibox-content">
					<form class="form-horizontal m-t" id="signupForm">
						<div class="form-group">
							<label class="col-sm-3 control-label">挂账金额：</label>
							<div class="col-sm-8">
								<input id="buyerMoney" name="buyerMoney" type="text">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">优惠金额：</label>
							<div class="col-sm-8">
								<input id="preferentialMoney" name="preferentialMoney"
									type="text">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">前班结余：</label>
							<div class="col-sm-8">
								<input id="Beforcash" name="Beforcash" type="text">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">交班员工：</label>
							<div class="col-sm-8">
								<input id="handemployee" name="handemployee" type="text">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">接班员工：</label>
							<div class="col-sm-8">
								<input id="takeemployee" name="takeemployee" type="text">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">密码：</label>
							<div class="col-sm-8">
								<input id="password" name="password" type="password">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">备注：</label>
							<div class="col-sm-8">
								<input id="remarks" name="remarks" type="text"
									aria-required="true" aria-invalid="true" class="error">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-8 col-sm-offset-3">
								<button class="btn btn-primary" type="submit">提交</button>
								<a href="${pageContext.request.contextPath }/background/changemanage.jsp">
                                 <input class="btn btn-primary" type="button" value="返回" />
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
 
		<script src="${pageContext.request.contextPath }/js/content.min.js?v=1.0.0"></script>
		<script src="${pageContext.request.contextPath }/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/plugins/validate/messages_zh.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/demo/form-validate-demo.min.js"></script>
		<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>