<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系我们的页面</title>

<style type="text/css">
.contacts{
  margin: 35px 20px;
  padding: 0px;
}
.left{
  width: 35%;
  text-align:center;
}
.left p{
text-align:left;
}
.left .times{
color: #999999;
}
.right{
  width: 60%;
  float: right;
  text-align:center;
}
.base{
  height: 180px;
  background-color: black;
  color: white;
  margin-top: 50px;
  text-align: center;
  line-height: 35px;
  padding-top: 10px;
}
</style>
</head>
<body>
	<div class="contacts">
		<div class="right">
		<img alt="公司地址图" src="${pageContext.request.contextPath }/img/gongsidizhi.jpg" />
		</div>
		<div class="left">
		  <img class="img" alt="图片" src="${pageContext.request.contextPath }/img/lianXi.png">
		  <p>联系电话：0871-63572236</p>
		  <p class="times">服务时间：周一至周五 08:30-17:00（节假日除外）</p>
		  <p>传真号码：0871-67180233</p>
		  <p>技术服务QQ：1965048247</p>
		  <p>业务咨询微信：suishoudian</p>
		  <p>微信公众号：cyooy3160</p>
		  <p>电子邮件：service@cyooy.com</p>
		</div>
		
		<div class="base">
			<p>
			版权所有Copyright@ 广州海华利网络科技有限公司 粤ICP备14005828号<br/>
客户服务热线：020-28908162 15360453282 <br/>
传真：020-84399526 邮箱：gzhlsoft@163.com <br/>
全国各城市均有销售服务点，详细联系方式，请咨询本公司
			</p>
		</div>
	</div>
</body>
</html>