<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<meta name="screen-orientation" content="portrait">
<title>点餐页面</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	background-color: #EFE6D5;
	visibility: hidden;
}

.content {
	font-size: .9rem;
}

@media ( min-width :768px) {
	.content {
		font-size: 1.5rem;
	}
}

.top {
	padding: 1.8% 0
}

.top img {
	width: 16%;
	height: 80%;
	border-radius: 20%;
	margin-left: 2%;
	vertical-align: middle;
}

.body {
	margin: 0;
	padding: 0;
	width: 100%;
}

.left {
	width: 25%;
	height: 100%;
	float: left;
	background: rgba(240, 235, 235, .5);
}

.left ul {
	list-style-type: none;
	height: 100%;
	overflow: scroll;
}

.left ul li {
	height: 10%;
}

.left ul li a {
	color: #778899;
	text-decoration: none;
	height: 100%;
	display:-webkit-box;
	-webkit-box-pack:center;
	-webkit-box-align:center;
}

.left .numLable {
	visibility:hidden;
	text-align:center;
	display:block;
	color: white;
	background-color: rgba(255, 0, 0, 0.8);
	width: 20%;
	border-radius: 100%;
	font-size: 70%;
	font-weight: 600;
	position: relative;
	left: 4%;
	bottom: 10%;
}

.right {
	float: right;
	width: 75%;
	height: 100%;
	background-color: rgba(253, 250, 250, .8);
}

.right-con {
	height:100%;
	margin-left: 5%;
	overflow: auto;
}

.right-con h3 {
	margin-top:1.5%;
	color: rgba(246, 63, 63, 1);
}
.right-con ul li {
	list-style-type: none;
	padding-top: 10px;
}

.right-con ul li dt {
	width: 35%;
	float: left;
}
.right-con ul li dd {
	margin-top:3%;
	width: 57%;
	margin-right:6%;
	float:right;
}

.clear {
	clear: both;
}

.right-con ul li dt img {
	width: 100%;
	border-radius: 5%;
	height: 100%;
}

.right-con dl {
	position: relative;
}

.right-con dd .sells {
	font-size: .8%;
}

.right-con dl .price {
	line-height: 170%;
	color: rgba(246, 63, 63, 1);
}

.right-con dd span {
	margin-left: 2%;
}

.right-con .addend {
	text-align: right;
}

.right-con .addend img {
	width: 16%;
	height: 16%;
	vertical-align: middle;
}

.addend .jian {
	display: none;
}

.addend label {
	display: none;
}

.right-con dl dd .discount {
	background-color: crimson;
	color: white;
	display: inline-block;
	float: right;
	transform: rotateZ(15deg);
	padding: 1%;
	font-size: 80%;
	border-radius: 25%;
}

.nav_visited {
	background-color: rgba(253, 250, 250, .8);
}

.nav_visited>a {
	color: rgba(246, 63, 63, 1) !important;
}

.bottom {
	background-color: rgba(0, 0, 0, 0.3);
	position: relative;
	z-index: 10;
}
.bottom img{
	margin-left:5%;
	height: 80%;
}
.bottom button {
	float: right;
	height: 60%;
	margin-right: 5%;
	color: #fff;
 	background-color: #337ab7;
  	border-color: #2e6da4;
	border: none;
  	border-radius: 4px;
  	font-size: 130%;
}
.bottom button:focus {
	outline:none;
	border-color:transparent;
	box-shadow:none;
}
#menuCarContext{
	width: 100%;
	background-color: rgba(0, 0, 0, 0.3);
	visibility: hidden;
	position: absolute;
}
#menuCarContext table{
	width: 100%;
	color:white;
	text-align: center;
}
#menuCarContext table tr{
	line-height: 280%;
}
#menuCarContext table tbody tr .del{
	cursor: pointer;
}
#menuCarContext span{
	color:white;
	display: inline-block;
	margin-top: 20px;
	margin-left: 5%;
}
#backgroundDiv{
	width: 100%;
	height:100%;
	position: absolute;
	top:0;
	left:0;
	background-color: rgba(0, 0, 0, 0.5);
	display: none;
}
#isExist{
 	color: red;
 	display: inline-block;
 	visibility: hidden;
}
</style>

</head>

<body>
	<input type="hidden" id="classpath" value="${pageContext.request.contextPath }"/>
	<div class="content">
		<input type="hidden" value='${requestScope.navList }' id="navList"/>
		<input type="hidden" value='${requestScope.menuList }' id="menuList"/>
		<input type="hidden" value='' id="menuList"/>
		<div class="top">
			<img src="${pageContext.request.contextPath }/img/20180314022355.jpg" />&nbsp;&nbsp;微点餐
		</div>
		<div class="body">
			<div class="left">
				
			</div>
			<div class="right">
				<div class="right-con">
				 	
				</div>
			</div>
		</div>
		<form action="${pageContext.request.contextPath }/menuAction/payment.action" method="post"  name="payment">
		<div class="bottom">
			<img alt="已点餐" id="menuCar" src="${pageContext.request.contextPath }/img/gouwuche2.png">
			<input type="hidden" name="payMoney"/>
			<button type="submit" id="pay">支&nbsp;付</button>
		</div>
		<div id="backgroundDiv"></div>
			<div id="menuCarContext">
				<span>会员号：<input type="text" id="membership" placeholder="会员请输入" /></span><label id="isExist">*会员不存在</label>
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
					<tfoot>
						<tr>
							<td colspan="2" align="right">会员价：<span>0</span></td>
							<td colspan="2">总价：<span>0</span></td>
							<td>清空</td>
						</tr>
					</tfoot>
				</table>
			</div>
			</form>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/classPath.js"></script>
	<script type="text/javascript">
		//获取屏高度
		var winHeight = document.documentElement.clientHeight;
		//获取.top
		var topHeight = document.getElementsByClassName("top")[0];
		//获取.body
		var bodyHeight = document.getElementsByClassName("body")[0];
		//设置高度
		bodyHeight.style.height = (winHeight - topHeight.clientHeight) * 0.9
				+ "px";
		
		//获取更目录
		var classPath = getPath();
		//读取数据
		var navLeft = document.getElementsByClassName("left")[0];
		var rightContent = document.getElementsByClassName("right-con")[0];
		var navList = document.getElementById('navList').value;
		var menuList = document.getElementById('menuList').value;
		var imgArr = new Array();
		if(navList != ''){
			var navJson = JSON.parse(navList);
			var navElement = '<ul>';
			for (var i = 0; i < navJson.length; i++) {
				navElement+='<li><a href="#menu'+i+'">'+navJson[i]['navName']+'<label class="numLable">0</label></a></li>';
			}
			navElement+='</ul>';
			navLeft.innerHTML = navElement;
			if(menuList != ''){
				var menuJson = JSON.parse(menuList);
			    var menuElement = '<div>';
				for (var i = 0; i < navJson.length; i++) {
					menuElement+='<ul class="sign"><li><h3 id="menu'+i+'">'+navJson[i]['navName']+'</h3></li>';
					for (var j = 0; j < menuJson.length; j++) {
						if(navJson[i]['navId']==menuJson[j]['navId']){
							menuElement+='<li><dl>';
							imgArr.push(classPath+'/'+menuJson[j]['imgPathOne']);
							menuElement+='<dt><img src="'+classPath+'/img/haohaochi.png" class="rigthImg"/></dt>';
							menuElement+='<dd><span>'+menuJson[j]['menuName']+'</span>'
								if(menuJson[j]['discount']!=0){
									menuElement+='<span class="discount">会员<label>'+menuJson[j]['discount']+'</label>折</span>';
								}	
							menuElement+='</dd>';
							menuElement+='<dd class="price">￥<label>'+menuJson[j]['unitPrice']+'</label>/'+menuJson[j]['unit']+'</dd>';
							
							menuElement+='<dd class="addend"><img src="'+classPath+'/img/subtract.png" class="jian" />&nbsp;<label>0</label>&nbsp; <img src="'+classPath+'/img/add.png" class="jia" /></dd>';
							menuElement+='<div class="clear"></div>';
							menuElement+='</dl></li>';
						}
					}
					menuElement+='</ul>';
				}
				menuElement+='</div>';
				rightContent.innerHTML = menuElement;
			}
		}
	    //导航条
		var navLi = navLeft.getElementsByTagName("li");
		navLi[0].classList.add("nav_visited");
		var navPre = 0;
		for (var i = 0; i < navLi.length; i++) {
			navLi[i].index = i;
			navLi[i].onclick = function() {
				navLi[navPre].classList.remove("nav_visited");
				navLi[this.index].classList.add("nav_visited");
				navPre = this.index;
			}
		}

		//显示添加份数
		var numLable = document.getElementsByClassName("numLable");
		var numHeight = 0;
		for (var i = 0; i < numLable.length; i++) {
			numHeight = numLable[i].offsetWidth;
			if (numHeight > 30) {
				numLable[i].style.width = 30 + "px";
				numLable[i].style.height = 30 + "px";
				numLable[i].style.lineHeight = 30 + "px";
			} else {
				numLable[i].style.height = numLable[i].offsetWidth + "px";
				numLable[i].style.lineHeight = numLable[i].offsetWidth + "px";
			}
		}
		
		//滑动事件
		var navLeftUl = navLeft.getElementsByTagName('ul')[0];
		var oneDiv = rightContent.getElementsByTagName('div')[0];
		var sign = document.getElementsByClassName("sign");
		var direction = 0;
		rightContent.onscroll = function() {
			if(rightContent.scrollTop+rightContent.clientHeight>=oneDiv.clientHeight){
				if(sign[sign.length-1].clientHeight>=rightContent.clientHeight){
					navLi[navPre].classList.remove("nav_visited");
					navLi[sign.length-1].classList.add("nav_visited");
					navPre = sign.length-1;
				}else{
					navLi[navPre].classList.remove("nav_visited");
					navLi[sign.length-2].classList.add("nav_visited");
					navPre = sign.length-2;
				}
			}
			if(rightContent.scrollTop<=20){
				navLi[navPre].classList.remove("nav_visited");
				navLi[0].classList.add("nav_visited");
				navPre = 0;
			}
			if(direction < rightContent.scrollTop) {
				if(navPre != sign.length-1 && topHeight.clientHeight > sign[navPre + 1].offsetTop - rightContent.scrollTop) {
					navLi[navPre].classList.remove("nav_visited");
					navLi[navPre + 1].classList.add("nav_visited");
					navPre = navPre + 1;
				}
			} else {
				if(navPre != 0 && topHeight.clientHeight < sign[navPre].offsetTop - rightContent.scrollTop) {
					navLi[navPre].classList.remove("nav_visited");
					navLi[navPre - 1].classList.add("nav_visited");
					navPre = navPre - 1;
				}
			}
			//图片加载
			direction = rightContent.scrollTop;
			var countResult = Math.floor((rightContent.scrollTop-(navPre)*rigthLiTilte)/rigthLiContext);
			imgPath(countResult-2,offsetEnd+countResult);
			//设定左边导航条的scrollTop
			if(navPre>8){
				navLeftUl.scrollTop += navLi[0].offsetHeight;
			}else if(navPre<2){
				navLeftUl.scrollTop -= navLi[0].offsetHeight;
			}
		}
		//设置图片的高度
		var rigthLi = rightContent.getElementsByTagName('li');
		var rigthLiIndexOne = rigthLi[1].clientHeight-10+'px';
		var rightDt = rightContent.getElementsByTagName('dt');
		for (var i = 0; i < rightDt.length; i++) {
			rightDt[i].style.height = rigthLiIndexOne;
		}
		//图片延迟加载
		var rigthLiTilte=Math.ceil(rigthLi[0].offsetHeight);
		var rigthLiContext=Math.ceil(rigthLi[1].offsetHeight);
		var rigthImg = document.getElementsByClassName('rigthImg');
		var offsetEnd = Math.ceil(rightContent.clientHeight/rigthLiContext);
		function imgPath(start,end){
			for (var i = start; i <= end; i++) {
				if(i >= rigthImg.length){
					return;
				}
				if(i < 0){
					continue;
				}
				if(rigthImg[i].getAttribute('src')==(classPath+'/img/haohaochi.png')){
					rigthImg[i].setAttribute('src',imgArr[i]);
				}
			}
		}
		//初始图片延迟加载
		imgPath(0,offsetEnd);
		//减
		var text = 0;
		var element = null;
		var jian = document.getElementsByClassName("jian");
		for (var i = 0; i < jian.length; i++) {
			jian[i].index = i;
			jian[i].onclick = function() {
				//获取菜的总份数
				var numLableObj = numLable[parseInt(gainElementAttr(jian[this.index]).substring(4))];
				numLableObj.innerHTML=parseInt(numLableObj.innerHTML)-1;
				if(parseInt(numLableObj.innerHTML)==0){
					numLableObj.style.visibility = 'hidden';
				}
				element = jian[this.index].nextElementSibling;
				text = parseInt(element.innerText) - 1;
				if (text <= 0) {
					jian[this.index].style.display = "none";
					element.style.display = "none";
				}
				element.innerHTML = text;
				//生成菜谱表格
				isDiscount = jia[this.index].parentNode.previousElementSibling.previousElementSibling.firstElementChild.nextElementSibling?
						jian[this.index].parentNode.previousElementSibling.previousElementSibling.firstElementChild.nextElementSibling.firstElementChild.innerHTML:'暂无折扣';
				addByDelElementTable({'id':this.index+'',
					'menuName':jian[this.index].parentNode.previousElementSibling.previousElementSibling.firstElementChild.innerHTML,
					'price':jian[this.index].parentNode.previousElementSibling.firstElementChild.innerHTML,
					'discount':isDiscount,
					'totality':text,
					'operator':'sub'});
			}
		}
		//加法
		var jia = document.getElementsByClassName("jia");
		for (var i = 0; i < jia.length; i++) {
			jia[i].index = i;
			jia[i].onclick = function() {
				//获取菜的总份数
				var numLableObj = numLable[parseInt(gainElementAttr(jia[this.index]).substring(4))];
				numLableObj.innerHTML=parseInt(numLableObj.innerHTML)+1;
				if(parseInt(numLableObj.innerHTML)>0){
					numLableObj.style.visibility = 'visible';
				}
				element = jia[this.index].previousElementSibling;
				text = parseInt(element.innerText) + 1;
				if (text == 1) {
					//显示减号
					jian[this.index].style.display = "inline-block";
					element.style.display = "inline-block";
				}
				element.innerHTML = text;
				//生成菜谱表格
				isDiscount = jia[this.index].parentNode.previousElementSibling.previousElementSibling.firstElementChild.nextElementSibling?
						jia[this.index].parentNode.previousElementSibling.previousElementSibling.firstElementChild.nextElementSibling.firstElementChild.innerHTML:'暂无折扣';
				addByDelElementTable({'id':this.index+'',
					'menuName':jia[this.index].parentNode.previousElementSibling.previousElementSibling.firstElementChild.innerHTML,
					'price':jia[this.index].parentNode.previousElementSibling.firstElementChild.innerHTML,
					'discount':isDiscount,
					'totality':text,
					'operator':'add'});
			}
		}
		
		//获取菜的总份数
		function gainElementAttr(e){
			if(e.parentNode){
				return e.parentNode.parentNode.parentNode.parentNode.firstElementChild.firstElementChild.getAttribute('id');
			}else{
				return e.parentElement.parentElement.parentElement.parentElement.firstElementChild.firstElementChild.getAttribute('id');
			}
		}
		//底部计算
		var bottom = document.getElementsByClassName("bottom")[0];
		bottom.style.height = (winHeight * 0.09) + "px";
		//点餐车按钮
		var menuCar = document.getElementById('menuCar');
		menuCar.style.marginTop=(bottom.clientHeight-menuCar.clientHeight)/2+'px';
		//支付按钮
		var pay = document.getElementById('pay');
		pay.style.marginTop=(bottom.clientHeight-pay.clientHeight)/2+'px';
		pay.style.width=pay.clientHeight*2+'px';
		//点餐内容以及计算
		var menuCarContext = document.getElementById('menuCarContext');
		var menuCarContextHeight = menuCarContext.clientHeight;
		menuCarContext.style.bottom = bottom.clientHeight+'px';
		//生成菜谱表格
		var tbody = menuCarContext.getElementsByTagName('tbody')[0];
		var elementTable = '';
		//计算会员价及总价格还有清空按钮
		var tfootTr = menuCarContext.getElementsByTagName('tfoot')[0].getElementsByTagName('tr')[0];
		var memberPrice = tfootTr.firstElementChild.firstElementChild;
		var totalPrice = tfootTr.firstElementChild.nextElementSibling.firstElementChild;
		var empty = tfootTr.lastElementChild;
		var isDiscount = '';
		//背景div
		var backgroundDiv = document.getElementById('backgroundDiv');
		//点餐车按钮点击事件
		menuCar.onclick = function(){
			if(menuCarContext.style.visibility  == 'visible'){
				menuCarContext.style.visibility = 'hidden'; 
				backgroundDiv.style.display = 'none'; 
			}else{
				menuCarContext.style.visibility = 'visible';
				backgroundDiv.style.display = 'block';
				if(menuCarContext.clientHeight>=winHeight/2){
					menuCarContext.style.height=winHeight/2+'px';
					menuCarContext.style.overflow='scroll';
				}
			}
		}
		//背景div点击事件
		backgroundDiv.onclick = function(){
			menuCarContext.style.visibility = 'hidden'; 
			backgroundDiv.style.display = 'none'; 
		}
		//生成菜谱表格
		var idTd = document.getElementsByClassName('id');
		var isAdd = false;
		function addByDelElementTable(variableJson){
			var discount = isNaN(variableJson.discount)? '10':variableJson.discount;
			for (var i = 0; i < idTd.length; i++) {
				if(idTd[i].innerHTML==variableJson.id){
					if(variableJson.totality==0){
						tbody.removeChild(idTd[i].parentNode);
					}else{
						idTd[i].nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML=variableJson.totality;
					}
					if('add'==variableJson.operator){
						totalPrice.innerHTML = Math.round((parseFloat(totalPrice.innerHTML)+parseFloat(variableJson.price))*100)/100;
						memberPrice.innerHTML = Math.round((parseFloat(memberPrice.innerHTML)+parseFloat(variableJson.price)*parseFloat(discount)/10)*100)/100;
					}else{
						totalPrice.innerHTML = Math.round((parseFloat(totalPrice.innerHTML)-parseFloat(variableJson.price))*100)/100;
						memberPrice.innerHTML = Math.round((parseFloat(memberPrice.innerHTML)-parseFloat(variableJson.price)*parseFloat(discount)/10)*100)/100;
					}
					isAdd = true;
					break;
				}
			}
			if(!isAdd){
				elementTable = '<tr>';
				elementTable += '<td class="id" style="display: none;">'+variableJson.id+'</td>';
				elementTable += '<td>'+variableJson.menuName+'<input type="hidden" name="menuNames" value="'+variableJson.menuName+'"/></td>';
				elementTable += '<td>'+variableJson.price+'</td>';
				elementTable += '<td>'+variableJson.discount+'</td>';
				elementTable += '<td>'+variableJson.totality+'</td>';
				elementTable += '<td class="del">删除</td>';
				elementTable += '</tr>';
				tbody.innerHTML += elementTable;
				//总价格
				totalPrice.innerHTML = Math.round((parseFloat(totalPrice.innerHTML)+parseFloat(variableJson.price))*100)/100;
				//会员价
				memberPrice.innerHTML = Math.round((parseFloat(memberPrice.innerHTML)+parseFloat(variableJson.price)*parseFloat(discount)/10)*100)/100;
				tbodyTrHeight = tbody.firstElementChild.clientHeight;
			}
			isAdd = false;
			delectElement();
		}
		//删除点餐信息
		var tbodyTrHeight ='';
		var delElement = document.getElementsByClassName('del');
		function delectElement(){
			var totality = 0;
			var discountText = '';
			var discount = '';
			var price = 0;
			for (var i = 0; i < delElement.length; i++) {
				delElement[i].index=i;
				delElement[i].onclick=function(){
					//获取总份数
					totality = parseInt(delElement[this.index].previousElementSibling.innerHTML);
					//获取折扣内容并且判断
					discountText = delElement[this.index].previousElementSibling.previousElementSibling.innerHTML
					discount = parseFloat(isNaN(discountText)? '10':discountText);
					//获取价格
					price = parseFloat(delElement[this.index].previousElementSibling.previousElementSibling.previousElementSibling.innerHTML);
					//总价格
					totalPrice.innerHTML = Math.round((parseFloat(totalPrice.innerHTML)-price*totality)*100)/100;
					//会员价
					memberPrice.innerHTML = Math.round((parseFloat(memberPrice.innerHTML)-price*totality*discount/10)*100)/100;
					//获取索引值并且赋值为0
					var jianIndex = parseInt(delElement[this.index].parentNode.firstElementChild.innerHTML);
					jian[jianIndex].style.display='none';
					jian[jianIndex].nextElementSibling.style.display='none';
					jian[jianIndex].nextElementSibling.innerHTML=0;
					//获取菜的总份数
					var numLableObj = numLable[parseInt(gainElementAttr(jian[jianIndex]).substring(4))];
					numLableObj.innerHTML=parseInt(numLableObj.innerHTML)-totality;
					if(parseInt(numLableObj.innerHTML)==0){
						numLableObj.style.visibility = 'hidden';
					}
					
					//删除tr
					tbody.removeChild(delElement[this.index].parentNode);
					//menuCarContext高度
					if(tbodyTrHeight*(delElement.length+1)+menuCarContextHeight<winHeight/2){
						menuCarContext.style.height='';
					}
					
					delectElement();
				}
			}
		}
		empty.onclick = function(){
			var jianIndex = 0;
			var numLableObj = null;
			for (var i = 0; i < idTd.length; i++) {
				//获取索引值并且赋值为0
				jianIndex = parseInt(idTd[i].innerHTML);
				jian[jianIndex].style.display='none';
				jian[jianIndex].nextElementSibling.style.display='none';
				jian[jianIndex].nextElementSibling.innerHTML=0;
				//获取菜的总份数
				numLableObj = numLable[parseInt(gainElementAttr(jian[jianIndex]).substring(4))];
				numLableObj.innerHTML=0;
				if(parseInt(numLableObj.innerHTML)==0){
					numLableObj.style.visibility = 'hidden';
				}
			}
			menuCarContext.style.height='';
			//总价格
			totalPrice.innerHTML = '0';
			//会员价格
			memberPrice.innerHTML = '0';
			tbody.innerHTML='';
		}
		//验证会员号是否存在
		var membership =document.getElementById('membership');
		var isExist =document.getElementById('isExist');
		var isAccount=0;
		membership.onblur=function(){
			if(membership.value==''){
				isAccount=0;
				isExist.style.visibility = 'hidden';
			}else{
				if(/^\d+$/.test(membership.value)){
					var xmlhttp;
					if (window.XMLHttpRequest)
					{
						//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
						xmlhttp=new XMLHttpRequest();
					}
					else
					{
						// IE6, IE5 浏览器执行代码
						xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					}
					xmlhttp.onreadystatechange=function()
					{
						if (xmlhttp.readyState==4 && xmlhttp.status==200)
						{
							if(xmlhttp.responseText>0){
								isAccount=2;
								isExist.style.visibility = 'hidden';
							}else{
								isAccount=1;
								isExist.style.visibility = 'visible';
							}
						}
					}
					xmlhttp.open("GET",document.getElementById('classpath').value+'/member/'+membership.value+'/selectIsAccount.action',true);
					xmlhttp.send();
				}else{
					alert('请输入数字！');					
				}
			}
		}
		//确认支付
		var payment = document.getElementsByName('payment')[0];
		var payMoney = document.getElementsByName('payMoney')[0];
		payment.onsubmit=function(){
			if(delElement.length>0){
				if(isAccount==1){
					alert('会员输入不正确');
					return false;
				}else if(isAccount==0){
					payMoney.value=totalPrice.innerHTML;
				}else{
					payMoney.value=memberPrice.innerHTML;
				}
			}else{
				alert('请点餐');
				return false;
			}
		}
		//加载完所有节点在显示
		document.addEventListener("DOMContentLoaded", function(){
		    document.body.style.visibility = 'visible'
		});
	</script>
</body>
</html>