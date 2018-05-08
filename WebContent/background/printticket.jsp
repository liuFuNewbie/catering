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
    
    <title>打印账单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <link href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
   
</head>

<body>
    <div style="border:3px #cdcdcd solid;width: 360px; margin:auto; margin-top: 20px;" >
		<table  align="center">
			<tr><td colspan="6" align="center"><h3>好好吃餐厅</h3></td></tr>
			<tr style="color: red"><td>名称:</td><td colspan="3" width="60px"></td><td width="60px">数量:</td><td>价格:</td></tr>
			<tr><td>糖醋排骨</td><td colspan="3" ></td><td>1</td><td>35</td></tr>
			<tr><td>可乐鸡翅</td><td colspan="3"></td><td>1</td><td>25</td></tr>
			 <tr><td>大米饭</td><td colspan="3"></td><td>4</td><td>2</td></tr>
			 <tr><td>香辣土豆片</td><td colspan="3"></td><td>1</td><td>10</td></tr>
			 <tr><td>板栗炖鸡汤</td><td colspan="3"></td><td>1</td><td>25</td></tr>
			 <tr><td>剁椒鱼头</td><td colspan="3"></td><td>1</td><td>15</td></tr>
			 <tr><td>&nbsp;</td></tr>
			 <tr><td colspan="6" align="center">===========19:43:35===========</td></tr>
			 <tr><td>&nbsp;</td></tr>
			 <tr><td colspan="5">合计：</td><td colspan="">118</td></tr>
			 <tr><td>收款总金额：</td><td colspan="3">120</td><td>找回：</td><td>2</td></tr>
			 <tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr>
			 <tr>
			   <td height="4" align="center" colspan="6"> 
				 <button onclick="print1()" type="button" class="btn">确认打票</button>
			   </td>
			 </tr>
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
