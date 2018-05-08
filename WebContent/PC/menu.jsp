<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.css" />
<style type="text/css">
body {
	background-color: #EFE6D5;
}

@media ( min-width :1231px) {
	.main {
		margin-top: 10px;
		margin-bottom: 10px;
		width: 85%;
	}
}

@media ( max-width :1230px) {
	.main {
		margin-top: 10px;
		margin-bottom: 10px;
		width: 100%;
	}
}

.tilte {
	border-bottom: 1px solid #DCDCDC;
	margin-bottom: 10px;
	padding-bottom: 10px;
}

.logo {
	text-align: center;
}

.logo img {
	width: 60px;
	height: 40px;
}

.logo span {
	color: brown;
	font-weight: 600;
}

.titleMenu {
	padding: 0;
	background-color: #B79478;
	border-radius: 14px;
	font-size: 16px;
	height: 35px;
}

.titleMenu span {
	color: brown;
	line-height: 35px;
	font-weight: 600;
}

.titleMenu a {
	text-decoration: none;
	line-height: 35px;
	color: white;
}

.titleMenu a:hover {
	color: #DFDFDF;
}

.navSet ul{
	padding: 0;
	margin: 0;
}
.navContent li {
	cursor: pointer;
	border-bottom: 1px solid #BCBCBC;
}

.navContent a {
	color: brown;
	font-size: 16px;
	font-weight: 700;
}

.navContent span {
	float: right;
}

.navContent a:hover {
	transform: scale(1.04);
	background-color: #EC971F !important;
}

.navContent .current a {
	color: white !important;
	background-color: brown !important;
}
.menuCarImg{
	height: 60px;
	width: 60px;
	cursor: pointer;
}
.imgMaxSize {
	width: 160px;
	height: 105px;
}
.imgContent div[class='media'] {
	border-bottom: 1px solid #BCBCBC;
}

.imgContent div[class='media']:hover {
	transform: scale(1.02);
}
.discount {
	background-color: crimson;
	color: white;
	display: inline-block;
	float: right;
	transform: rotateZ(20deg);
	border-bottom: 1px solid #DCDCDC;
	padding: 3px;
	font-size: 12px;
	border-radius: 10px;
}

.discount label {
	margin-bottom: 0;
}

.money {
	font-size: 18px;
	font-weight: 800;
	color: orange;
}

.topMarger {
	margin-top: 8px;
}
.information {
	background-color: #999999;
	padding: 5px 15px;
	border-radius: 15px;
	text-decoration: none;
	color: white;
	cursor: pointer;
	font-weight: 600;
}

.operate {
	background-color: #EC971F;
	padding: 5px 15px;
	margin-right: 30px;
	margin-left: 3px;
	border-radius: 15px;
	text-decoration: none;
	color: white;
	cursor: pointer;
	font-weight: 600;
}

.information:hover, .operate:hover {
	text-decoration: none;
}

.mediaTitle {
	color: brown;
	font-weight: 700;
}

.pageIndex {
	margin-bottom: 0 !important;
}
.pageIndex a{
	margin: 0 3px;
}

.modelContent {
	text-align: center;
}

.modelContent #modelImg {
	width: 280px;
}

.modelLine #modelTitle {
	color: brown;
	font-weight: 700;
	display: inline-block;
	font-size: 20px;
}

.modelLine #modelDiscount {
	background-color: crimson;
	color: white;
	border-bottom: 1px solid #DCDCDC;
	padding: 3px;
	font-size: 10px;
	border-radius: 10px;
}

.modelLine #modelDiscount label {
	margin-bottom: 0;
}

.modelContent .modalMoney {
	font-size: 18px;
	font-weight: 800;
	color: orange;
	margin-top: 10px;
}
#modelImg{
	width:280px;
	height: 205px;
}
.modelNum .modelSub, .modelNum .modelAdd {
	background-color: #EC971F;
	padding: 3px 10px;
	color: white;
	font-size: 18px;
	font-weight: bolder;
	border-radius: 10px;
	cursor: pointer;
	border: none;
}
button:focus {
	outline:none;
	border-color:transparent;
	box-shadow:none;
}
.currentPage{
	background-color: #cdcdcd !important;
	color: white;
}
.currentPage:hover{
	color: white;
}
/* 淡入淡出 */
.animated {
 -webkit-animation-duration: 1s;
 animation-duration: 1s;
 -webkit-animation-fill-mode: both;
 animation-fill-mode: both;
 z-index: 100
}
 @-webkit-keyframes bounceIn {
	 0% {
	      opacity: 0;
		  -webkit-transform: scale(.3);
		  transform: scale(.3)
	   }
	50% {
		opacity: 1;
		-webkit-transform: scale(1.05);
		transform: scale(1.05)
	}
	70% {
		-webkit-transform: scale(.9);
		transform: scale(.9)
	}
	100% {
	   opacity: 1;
	   -webkit-transform: scale(1);
	   transform: scale(1)
	}
}
			
@keyframes bounceIn {
	0% {
		opacity: 0;
		-webkit-transform: scale(.3);
		-ms-transform: scale(.3);
		transform: scale(.3)
	}
	50% {
		opacity: 1;
		-webkit-transform: scale(1.05);
		-ms-transform: scale(1.05);
		transform: scale(1.05)
	}
	70% {
		-webkit-transform: scale(.9);
		-ms-transform: scale(.9);
		transform: scale(.9)
	}
	100% {
		opacity: 1;
		-webkit-transform: scale(1);
		-ms-transform: scale(1);
		transform: scale(1)
	}
}
.bounceIn {
	-webkit-animation-name: bounceIn;
	animation-name: bounceIn;
}
.animation_img{
	width:280px;
	height: 205px;
	display: none;
	margin: 0 auto;
}
#menuCar table {
	width: 100%;
	text-align: center;
}
#menuCar table tr{
	line-height: 280%;
}
#menuCar table th{
	text-align: center;
}
#menuCar table tr .del{
	cursor: pointer;
}
#isExist{
 	color: red;
 	display: none;
}
</style>
</head>
<body>
	<div class="container main">
		<div class="row tilte">
			<div class="col-xs-3 logo">
				<img
					src="${pageContext.request.contextPath }/img/20180314022355.jpg" />&nbsp;&nbsp;&nbsp;&nbsp;<span>微点餐</span>
			</div>
			<div class="col-xs-6">
				<div class="row titleMenu">
					<div class="col-xs-3 text-center">
						<span>菜品推介</span>
					</div>
					<div class="col-xs-3">
						<a href="#">人参炖鸡</a>
					</div>
					<div class="col-xs-3">
						<a href="#">鱼善肉丝</a>
					</div>
					<div class="col-xs-3">
						<a href="#" >海鲜面条</a>
					</div>
				</div>
			</div>
			<div class="col-xs-3 search center-block">
				<div class="input-group">
					<input type="text" id="searchName" class="form-control" placeholder="搜索菜名" /> <span
						class="input-group-btn">
						<button class="btn btn-success" type="button" id="searchBtn">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<div class="navSet">
					<ul class="nav nav-pills nav-stacked navContent">
					<c:forEach items="${requestScope.navList }" var="nav">
						<li data-menuId="${nav.navId }"
						data-path="${pageContext.request.contextPath }/menuAction/${nav.navId }/1/null/selectMenusByPage.action"
						><a>${nav.navName }<span>&gt;</span></a></li>
					</c:forEach>
				</ul>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-2"></div>
					<div class="col-xs-8 text-center">
						<img alt="查看点餐" title="查看点餐" src="${pageContext.request.contextPath }/img/gouwuche1.png" data-target="#menuCar" class="menuCarImg">
					</div>
				</div>
			</div>
			<div class="col-xs-9 imgContent">
				
			</div>
		</div>
	</div>
	<div class="modal fade" id="operate" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<span>点菜总金额：<label id="totalMoney">0</label>元&nbsp;&nbsp;会员总价：<label
						id="totalMemberPrice">0</label>元
					</span>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="modelContent">
						<div class="modelLine">
							<h4 id="modelTitle"></h4>
							&nbsp;&nbsp;<span id="modelDiscount"></span>
						</div>
						<br>
						<img id="modelImg" src="" />
						<br>
						<div class="modalMoney" id="unitPrice">
						</div>
						<br>
						<div class="modelNum">
							<button class="modelSub">&nbsp;&minus;&nbsp;</button>
							&nbsp; <label id="result">1</label>&nbsp;
							<button class="modelAdd">&nbsp;+&nbsp;</button>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<div>
						<button type="button" class="btn btn-warning addMenuCar">加入我的菜单</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="information" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 style="display: inline-block;">描述：</h4>
					<button type="button" class="close closeInterval" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body" id="imgInfo">
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="menuCar" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath }/menuAction/payment.action" method="post"  name="payment">
				<div class="modal-header">
					会员号：<input type="text"  id="membership" placeholder="会员请输入" /><span id="isExist">*会员不存在</span>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div id="tab">
						<table>
						<thead>
							<tr>
								<th>菜名</th>
								<th>价格</th>
								<th>折扣</th>
								<th>份数</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>
					</div>
				</div>
				<div class="modal-footer">
					<div>
						<span>点菜总金额：<label id="totalMoneyCar">0</label>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会员总价：<label
							id="totalMemberPriceCar">0</label>元
						</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="hidden" name="payMoney"/>
						<button type="button" class="btn btn-warning clearMenu">清空所有</button>&nbsp;&nbsp;
						<button type="submit" class="btn btn-warning">支&nbsp;付</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/classPath.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script>
		//记录导航条点击事件li
		var navContentLi = $(".navContent li");
		navContentLi.eq(0).addClass("current");
		var imgContent = $(".imgContent").eq(0);
		//初始化数据
		doAjax(navContentLi.eq(0).attr("data-path"));
		var calssPath = getPath();
		//分页信息
		var pageIndex = null;
		//总页数
		var totalPageCount = 0;
		//当前页数
		var currentPageNo = 1;
		//创建元素节点
		var element = "";
		//描述信息
		var describeContext="";
		//记录导航条编号
		var navId = navContentLi.eq(0).attr("data-menuId");
		//记录导航条索引
		var navIndex =0;
		//菜的编号
		var menuId = 0;
		//点菜按钮(operate模态框)
		var operate = null;
		//减份数(operate模态框)
		var modelSub = $(".modelSub");
		//加份数(operate模态框)
		var modelAdd = $(".modelAdd");
		//总金额(operate模态框)
		var totalMoney = $("#totalMoney");
		//会员金额(operate模态框)
		var totalMemberPrice = $("#totalMemberPrice");
		//菜名(operate模态框)
		var modelTitle = $("#modelTitle");
		//会员折扣(operate模态框)
		var modelDiscount =  $("#modelDiscount");
		//单价(operate模态框)
		var unitPrice =  $("#unitPrice");
		//图片(operate模态框)
		var modelImg =  $("#modelImg");
		//记录单价
		var countPrice = 0;
		//记录折扣
		var countDiscount=0;
		//计数结果
		var res = $("#result");
		//描述信息（information模态框）
		var information=null;
		//显示内容（information模态框）
		var imgInfo = $("#imgInfo");
		//内容（information模态框）
		var imgInfohtml = '';
		//获取图片对象（information模态框）
		var animation_img = null;
		//图片对象索引（information模态框）
		var imgIndex=0;
		//图片切换计算器（information模态框）
		var timer = null;
		//关闭计算器（information模态框）
		var closeInterval = $(".closeInterval");
		//获取菜名
		var menuName = 'null';
		//搜索按钮
		var searchBtn = $("#searchBtn");
		//搜索按钮点击事件
		searchBtn.click(function(){
			menuName = $("#searchName").val();
			navId=0;
			doAjax(calssPath+'/menuAction/0/1/'+encodeURI(menuName)+'/selectMenusByPage.action');
		});
		//点菜的json
		var jsonObj=null;
		/* 导航条点击事件 */
		navContentLi.click(function() {
			navContentLi.eq(navIndex).removeClass("current");
			navId = $(this).attr("data-menuId");
			navIndex = navContentLi.index($(this));
			$(this).addClass("current");
			doAjax($(this).attr("data-path"));
		});
		function doAjax(path) {
			$.ajax({
				url : path,
				type : "get",
				dataType : "json",
				success : function(result) {
					totalPageCount = result[1];
					currentPageNo = result[2];
					/* 菜谱 */
					element = '<div style="height:589px;">'
					$.each(result[0],function(key,val){
						describeContext = val['describe'];
						if(describeContext.length>30){
							describeContext = describeContext.substring(0, 28)+"……";
						}
						element += '<div class="media">';
						element+='<div class="media-left"><img alt="'+val['menuName']+'" class="media-object imgMaxSize" src="'+calssPath+'/'+val['imgPathOne']+'" /></div>';
						element+='<div class="media-body">';
						element+='<div class="row"><div class="col-xs-8"><h4 class="media-heading mediaTitle">'+val['menuName']+'</h4></div>'
						if(val['discount']!=0){
							element+='<div class="col-xs-4"><span class="discount">会员<label>'+val['discount']+'</label>折</span></div>'
						}
						element+='</div>';
						element+='<div class="row topMarger"><div class="col-xs-9"><span>描述：</span><span class="describe">'+describeContext+'</span></div><div class="col-xs-3 text-center"><span><label class="money">'+val['unitPrice']+'</label>元/<small>'+val['unit']+'</small></span></div></div>';
						element+='<div class="row topMarger"><div class="col-xs-offset-8 text-right"><a  data-toggle="modal" data-target="#information" class="information">详情</a> <span style="display:none">'+val['menuId']+'</span><a class="operate" data-toggle="modal" data-target="#operate">点菜</a></div></div>';
						element+= '</div></div>';
					});
					/* 分页按钮 */
					if(totalPageCount>1){
						element+= '</div>';
						element+= '<div class="row pager pageIndex">';
						element+= '<li>当前页码：['+currentPageNo+'/'+totalPageCount+']</li>';
						if(currentPageNo==1){
							element+= '<li><a class="currentPage">上一页</a></li>';
						}else{
							element+= '<li><a href="'+calssPath+'/menuAction/'+navId+'/'+(currentPageNo-1)+'/'+encodeURI(menuName)+'/selectMenusByPage.action">上一页</a></li>';
						}
						if(totalPageCount<=5){
							curr(1,totalPageCount);
						}else{
							if(currentPageNo<=3){
								curr(1,5);
							}else if(currentPageNo<totalPageCount-2){
								curr(currentPageNo-2,currentPageNo+2);
							}else{
								curr(totalPageCount-4,totalPageCount);
							}
						}
						if(currentPageNo==totalPageCount){
							element+= '<li><a class="currentPage">下一页</a></li>';
						}else{
							element+= '<li><a href="'+calssPath+'/menuAction/'+navId+'/'+(currentPageNo+1)+'/'+encodeURI(menuName)+'/selectMenusByPage.action">下一页</a></li>';
						}
						element+= '</div>';
					}
					imgContent.html(element);
					//设置导航条的最大高度
					var navSet = $(".navSet");
					if(navSet.height()>=imgContent.height()*0.80){
						navSet.height(imgContent.height()*0.80);
						navSet.css('overflow-y','scroll');
						navSet.css('overflow-x','hidden');
					}
					//设置页面切换
					pageIndex = $(".pageIndex a[href]");
					pageIndex.click(function(){
						doAjax($(this).attr("href"));
						return false;
					});
					//点菜模态框
					operateFunction(result[0]);
					//描述模态框
					informationFunction(result[0]);
				},
				error : function() {
					alert('数据加载失败');
				}
			});
		}
		//点菜模态框
		function operateFunction(jsonData){
			operate = $(".operate");
			operate.click(function(){
				num=1;
				res.text(num);
				modelDiscount.hide();
				menuId = $(this).prev().text();
				jsonObj=jsonData[operate.index($(this))];
				countPrice=jsonObj['unitPrice'];
				countDiscount=jsonObj['discount'];
				modelTitle.text(jsonObj['menuName']);
				totalMoney.text(countPrice);
				if(countDiscount!=0){
					modelDiscount.show();
					totalMemberPrice.text(Math.round(countPrice*countDiscount/10*100)/100);
					modelDiscount.text('会员'+countDiscount+'折');
				}else{
					modelDiscount.text('');
					totalMemberPrice.text(totalMoney.text());
				}
				unitPrice.html(countPrice+'元/<small>'+jsonObj['unit']+'</small>');
				modelImg.attr('src',calssPath+'/'+jsonObj['imgPathOne']);
			});
		}
		//描述模态框
		function informationFunction(jsonData){
			information = $(".information");
			information.click(function(){
				jsonObj=jsonData[information.index($(this))];
				imgInfohtml='<div><img alt="'+jsonObj['menuName']+'" class="animation_img" alt="'+jsonObj['menuName']+'" src="'+calssPath+'/'+jsonObj['imgPathOne']+'" style="display: block;"/>';
				if(jsonObj['imgPathTwo']!=null)
					imgInfohtml+='<img alt="'+jsonObj['menuName']+'" class="animation_img" alt="'+jsonObj['menuName']+'" src="'+calssPath+'/'+jsonObj['imgPathTwo']+'"/>';
				if(jsonObj['imgPathThree']!=null)
					imgInfohtml+='<img alt="'+jsonObj['menuName']+'" class="animation_img" alt="'+jsonObj['menuName']+'" src="'+calssPath+'/'+jsonObj['imgPathThree']+'"/>';
				imgInfohtml+='</div><br><p>&nbsp;&nbsp;&nbsp;&nbsp;'+jsonObj['describe']+'</p>';
				imgInfo.html(imgInfohtml);
				animation_img = document.getElementsByClassName("animation_img");
				timer = window.setInterval(function() {
					animation_img[imgIndex%animation_img.length].style.display="none";
					animation_img[imgIndex%animation_img.length].className="animation_img";
					animation_img[(imgIndex+1)%animation_img.length].style.display="block";
					animation_img[(imgIndex+1)%animation_img.length].className="animation_img animated bounceIn";
					imgIndex++;
				}, 2000);
			});
		}
		//关闭计算器
		closeInterval.click(function(){
			imgIndex=0;
			window.clearInterval(timer);
		});
		function curr(start,end){
			for (var i = start; i <= end; i++) {
				if(i==currentPageNo){
					element+='<li><a class="currentPage">'+i+'</a></li>';
				}else{
					element+='<li><a href="'+calssPath+'/menuAction/'+navId+'/'+i+'/'+encodeURI(menuName)+'/selectMenusByPage.action">'+i+'</a></li>';
				}
			}
		}
		//计数器
		var num = 1;
		//减法计算
		modelSub.click(function() {
			if (num == 1) {
				return;
			}
			num = num - 1;
			res.text(num);
			totalMoney.text(Math.round((num*countPrice)*100)/100);
			if(countDiscount!=0){
				totalMemberPrice.text(Math.round((num*countPrice*countDiscount/10)*100)/100);
			}else{
				totalMemberPrice.text(totalMoney.text());
			}
		});
		//加法计算
		modelAdd.click(function() {
			num = num + 1;
			res.text(num);
			totalMoney.text(Math.round((num*countPrice)*100)/100);
			if(countDiscount!=0){
				totalMemberPrice.text(Math.round((num*countPrice*countDiscount/10)*100)/100);
			}else{
				totalMemberPrice.text(totalMoney.text());
			}
		});
		//显示购物车
		$('.menuCarImg').click(function(){
			$('#menuCar').modal('show');
			if(del.length>10){
				$('#tab').height(432);
				$('#tab').css('overflow','scroll');
			}else{
				$('#tab').height('');
				$('#tab').css('overflow','');
			}
		});
		//加入购物车
		var elementTable = '';
		var idTd = document.getElementsByClassName('id');
		var del = document.getElementsByClassName('del');
		var tbody = document.getElementsByTagName('tbody')[0];
		var isAdd = false;
		$('.addMenuCar').click(function(){
			$('#operate').modal('hide');
			for (var i = 0; i < idTd.length; i++) {
				if(idTd[i].innerHTML==menuId){
					var copies = idTd[i].nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling;
					copies.innerHTML=parseInt(copies.innerHTML)+parseInt(res.text());
					isAdd = true;
					break;
				}
			}
			if(!isAdd){
				elementTable = '<tr>';
				elementTable += '<td class="id" style="display: none;">'+menuId+'</td>';
				elementTable += '<td>'+modelTitle.text()+'<input type="hidden" name="menuNames" value="'+modelTitle.text()+'"/></td>';
				elementTable += '<td>'+unitPrice.text()+'</td>';
				if(countDiscount!=''){
					elementTable += '<td>'+countDiscount+'</td>';
				}else{
					elementTable += '<td>暂无折扣</td>';
				}
				elementTable += '<td>'+res.text()+'</td>';
				elementTable += '<td class="del">删除</td>';
				elementTable += '</tr>';
				$('#menuCar table tbody').html($('#menuCar table tbody').html()+elementTable);
			}
			$("#totalMoneyCar").text(Math.round((parseFloat(totalMoney.text())+parseFloat($("#totalMoneyCar").text()))*100)/100);
			$("#totalMemberPriceCar").text(Math.round((parseFloat(totalMemberPrice.text())+parseFloat($("#totalMemberPriceCar").text()))*100)/100);
			isAdd = false;
			delectElement();
		});
		//单行删除
		function delectElement(){
			var totality = 0;
			var discountText = '';
			var discount = 0;
			var price = 0;
			for (var i = 0; i < del.length; i++) {
				del[i].index=i;
				del[i].onclick=function(){
					//获取总份数
					totality = parseInt(del[this.index].previousElementSibling.innerHTML);
					//获取折扣内容并且判断
					discountText = del[this.index].previousElementSibling.previousElementSibling.innerHTML
					discount = parseFloat(isNaN(discountText)? '10':discountText);
					//获取价格
					price = parseFloat(del[this.index].previousElementSibling.previousElementSibling.previousElementSibling.innerHTML);
					$("#totalMoneyCar").text(Math.round((parseFloat($("#totalMoneyCar").text())- totality*price)*100)/100);
					$("#totalMemberPriceCar").text(Math.round((parseFloat($("#totalMemberPriceCar").text())-totality*price*discount/10)*100)/100);
					tbody.removeChild(del[this.index].parentNode);
					if(del.length<=10){
						$('#tab').height('');
						$('#tab').css('overflow','');
					}
					delectElement();
				}
			}
		}
		//清空所有
		$('.clearMenu').click(function(){
			$("#totalMoneyCar").text('0');
			$("#totalMemberPriceCar").text('0');
			tbody.innerHTML='';
			$('#tab').height('');
			$('#tab').css('overflow','');
		});
		//验证会员号是否存在
		var membership = $('#membership');
		var isExist = $('#isExist');
		var isAccount=0;
		membership.blur(function(){
			if(membership.val()==''){
				isAccount=0;
				isExist.hide();
			}else{
				if(/^\d+$/.test(membership.val())){
					$.ajax({
						url : calssPath+'/member/'+membership.val()+'/selectIsAccount.action',
						type : "get",
						dataType : "text",
						success : function(result){
							if(result>0){
								isAccount=2;
								isExist.hide();
							}else{
								isAccount=1;
								isExist.show();
							}
						},
						error:function(){
							alert('验证出错！');
						}
					});
				}else{
					alert('请输入数字！');					
				}
			}
		});
		//确认支付
		var payment = $('form[name="payment"]');
		payment.submit(function(){
			if(del.length>0){
				if(isAccount==1){
					alert('会员输入不正确');
					return false;
				}else if(isAccount==0){
					$('input[name="payMoney"]').val($("#totalMoneyCar").text());
				}else{
					$('input[name="payMoney"]').val($("#totalMemberPriceCar").text())
				}
			}else{
				alert('请点餐');
				return false;
			}
		})
	</script>
</body>

</html>