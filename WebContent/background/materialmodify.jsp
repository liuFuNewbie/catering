<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sun/common-two.css" />
    <div class="content">
			<form>
				<table>
					<tr>
						<td>
							编号
						</td>
						<td>
							<input type="text" name="bianhao" />
						</td>
					</tr>
					<tr>
						<td>
							商品名称
						</td>
						<td>
							<input type="text" name="shoop" />
						</td>
					</tr>
					<tr>
						<td>
							单价
						</td>
						<td>
							<input type="text" name="danjia" />
						</td>
					</tr>
					<tr>
						<td>
							数量
						</td>
						<td>
							<input type="text" name="shuliang" />
						</td>
					</tr>
					<tr>
						<td>
							金额
						</td>
						<td>
							<input type="text" name="jine" />
						</td>
					</tr>
					<tr>
						<td>
							仓库类型
						</td>
						<td>
							<select>
								<option>请选择</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							日期
						</td>
						<td>
							<input type="text" name="riqi" />
						</td>
					</tr>
					<tr>
						<td>
							经手人
						</td>
						<td>
							<input type="text" name="jingshouren" />
						</td>
					</tr>
					<tr>
						<td>
							备注
						</td>
						<td>
							<textarea name="beizhu"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="anniu" style="text-align: center;">
							<input type="submit" value="保存" />
							<a href="${pageContext.request.contextPath }/background/material.jsp">
                              <input type="button" value="返回" />
                            </a>
						</td>
					</tr>
				</table>
			</form>
		</div>