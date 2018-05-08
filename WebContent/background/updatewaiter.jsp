<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<div id="all">
	<div class="row">
		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<div class="ibox-title">
						<h4>
							报表管理&nbsp;&nbsp;》&nbsp;&nbsp;员工报表&nbsp;&nbsp;》&nbsp;&nbsp;员工奖励金&nbsp;&nbsp;》&nbsp;&nbsp;修改
						</h4>
					</div>
				</div>
				<div class="ibox-content">
					<form class="form-horizontal m-t" id="signupForm">
						<div class="form-groupe">
							<label class="col-sm-2 control-label">员工姓名：</label>
							<div class="col-sm-4">
								<input id="empName" name="empName" class="form-control"
									type="text"> <span class="help-block m-b-none"></span>
							</div>
						</div>
						<div style="clear: both;"></div>
						<div class="form-groupe">
							<label class="col-sm-2 control-label">职位：</label>
							<div class="col-sm-4">
								<select id="empTypeName" name="empTypeName" class="form-control">
									<option>服务员</option>
									<option>送外卖</option>
									<option>厨师</option>
									<option>洗碗工</option>
								</select>
							</div>
						</div>
						<div style="clear: both;"></div>
						<br>
						<div class="form-groupe">
							<label class="col-sm-2 control-label">奖励金：</label>
							<div class="col-sm-4">
								<input id="money" name="money" class="form-control"
									type="text"> <span class="help-block m-b-none"></span>
							</div>
						</div>
						<div style="clear: both;"></div>
						<div class="form-groupe">
							<label class="col-sm-2 control-label">状态：</label>
							<div class="col-sm-4">
								<select id="pose" name="pose" class="form-control">
									<option value="0">未发放</option>
									<option value="1">已发放</option>
								</select>
							</div>
						</div>
						<div style="clear: both;"></div>
						<br>
						<div class="form-group">
							<div class="col-sm-8 col-sm-offset-4">
								<button class="btn btn-primary" type="reset">重置</button>
								<button class="btn btn-primary" type="submit">提交</button>
								<a
									href="${pageContext.request.contextPath }/background/waiter.jsp">
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
<script
	src="${pageContext.request.contextPath }/js/demo/form-employee-demo.min.js"></script>
<script type="text/javascript"
	src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8">
	
</script>