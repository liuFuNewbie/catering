<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>好好吃餐厅后台管理系统-打印小票</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>
<body>
	<div style="border:3px #cdcdcd solid;width: 360px; margin: auto; margin-top: 20px;" >
		<table  align="center">
			<tr><td colspan="6" align="center"><h3>好好吃餐厅</h3></td></tr>
			<tr style="color: red"><td>名称:</td><td colspan="3" width="60px"></td><td width="60px">数量:</td><td>价格:</td></tr>
			<tr><td>酸菜鱼</td><td colspan="3" ></td><td>1</td><td>35</td></tr>
			<tr><td>大盘鸭</td><td colspan="3"></td><td>2</td><td>15</td></tr>
			 <tr><td>梅菜扣肉</td><td colspan="3"></td><td>2</td><td>25</td></tr>
			 <tr><td>盐水虾</td><td colspan="3"></td><td>1</td><td>25</td></tr>
			 <tr><td>冬瓜排骨汤</td><td colspan="3"></td><td>1</td><td>30</td></tr>
			 <tr><td>麻辣小龙虾</td><td colspan="3"></td><td>1</td><td>68</td></tr>
			 <tr><td>&nbsp;</td></tr>
			 <tr><td colspan="6" align="center">============19:43:35===========</td></tr>
			 <tr><td>&nbsp;</td></tr>
			 <tr><td colspan="5">合计：</td><td colspan="">213</td></tr>
			 <tr><td>送货地址：</td><td colspan="5" style="color:red ">长兴街道西路58号</td></tr>
			 <tr><td>联系人号码：</td><td colspan="5" style="color:red ">13534533633</td></tr>
			 <tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr>
			 <tr><td height="4" align="center" colspan="6"> <button onclick="print1()" type="button" class="btn">确认打票</button></td></tr>
		</table>
	</div>
	
	<script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
    <script type="text/javascript">
    	function print1(){
    		window.print();
    	}
       
    </script>
</body>
</html>