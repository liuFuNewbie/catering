<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sun/inventory-common.css" />
<div class="content">
			<form>
				<div class="container">
					<div class="row frominfo">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="bianhao">
										编号
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="bianhao" id="bianhao" />
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="diaobochuku">
										调拨出库
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="diaobochuku" id="diaobochuku" />
								</div>
							</div>
						</div>
					</div>
					<div class="row frominfo">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="cangku">
										仓库类型
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<select>
										<option>请选择</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="baosun">
										报损
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="baosun" id="baosun" />
								</div>
							</div>
						</div>
					</div>
					<div class="row frominfo">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="shoop">
										商品名称
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="shoop" id="shoop"/>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="lingliaochuku">
										领料出库
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="lingliaochuku" id="lingliaochuku" />
								</div>
							</div>
						</div>
					</div>
					<div class="row frominfo">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="danwei">
										单位
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="danwei" id="danwei"/>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="chukuxiaoji">
										出库小计
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="chukuxiaoji" id="chukuxiaoji" />
								</div>
							</div>
						</div>
					</div>
					<div class="row frominfo">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="caigou">
										采购ID
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="caigou" id="caigou"/>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="zonjine">
										总金额
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="zonjine" id="zonjine" />
								</div>
							</div>
						</div>
					</div>
					<div class="row frominfo">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="tiaoboruku">
										调拨入库
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="diaoboruku" id="diaoboruku"/>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="riqi">
										日期
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="riqi" id="riqi" />
								</div>
							</div>
						</div>
					</div>
					<div class="row frominfo">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="baoyi">
										报益
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="baoyi" id="baoyi"/>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="beizhu">
										备注
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<textarea name="beizhu" style="width: 175px;"></textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="row frominfo">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 text-right">
									<label for="rukuxiaoji">
										入库小计
									</label>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" name="rukuxiaoji" id="rukuxiaoji"/>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6"></div>
					</div>
					<div class="row frominfo">
						<div class="col-lg-12 col-md-12 col-sm-12 text-center">
							<input class="anniu" type="submit" value="保存" />
							<a href="${pageContext.request.contextPath }/background/inventory.jsp">
                              <input class="anniu" type="button" value="返回" />
                            </a>
						</div>
					</div>
				</div>
			</form>		
		</div>