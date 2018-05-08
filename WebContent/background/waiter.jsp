<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="${pageContext.request.contextPath }/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath }/css/styles.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/background/baobiao.css" />
<!-- 服务员提成首页 -->
	<div id="all">
	<div class="inquiry">
 		<form class="navbar-form navbar-right">
			<div class="form-group">
				<label><select name="type" id="type" class="form-control">
									<option value="empName">员工姓名</option>
									<option value="empTypeName">职位</option>
									<option value="pose">状态</option>
								</select></label><input type="text" id="surname" name="surname" class="form-control"/>
			</div>
			<button type="button" class="btn  btn-primary seek"><i><img src="${pageContext.request.contextPath }/img/search.png"/></i>搜索</button>
 		</form>
	</div>
	<div class="tables">
		<table class="emptable">
			<tr>
				<td>员工编号</td>
				<td>员工姓名</td>
				<td>职位</td>
				<td>奖金</td>
				<td>状态</td>
				<td>日期</td>
 				<td>操作</td>
			</tr>
		</table>
	</div>
	<div class="pager">
		<ul class="clearfix">
			
			<li>当前页码：[<i class="currentPageNo"></i>/<i class="totalCount"></i>]</li>
			<li><a href="javascript:;" class="last">上一页</a></li>
			<li><a href="javascript:;" class="next">下一页</a></li>
		</ul>
	</div>
 </div>
<script src="${pageContext.request.contextPath }/js/jquery.min.js?v=2.1.4"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/layer/layer.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/hplus.min.js?v=4.1.0"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/contabs.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins/pace/pace.min.js"></script>
	<script type="text/javascript">
	    $(function() {
	    	var empName,employeeTypeName,pose;
			$.ajax({
				type:'POST',
				url:'${pageContext.request.contextPath }/employee/getemployeelist.action',
				dataType:"json",   
	            success: function(data){
	               showEmpInfo(data);
	            }
			});//加载查询数据
			
			var empObj = null;
			$(".emptable").on("click",".delEmp",function(){
				empObj = $(this);
				$.ajax({
					type:"GET",
					url:"${pageContext.request.contextPath }/markets/existempidinfo.action",
					data:{"empId":empObj.attr("empId")},
					dataType:"text",
					success:function(data){
						if(data == "true"){
							alert("该员工 《 "+empObj.attr("empName")+" 》 有其他数据关联，不可删除！");
						}else if(data == "false"){
							if(confirm("是否删除该员工《  "+empObj.attr("empName")+"  》 的奖金信息吗？")){
							   deleteByempIdAjax(empObj);
							}
						}
					}
				});//查询该员工是否有其他记录信息
			});//根据当前选中的对象编号，询问是否删除
			
			function deleteByempIdAjax(empObj){
				$.ajax({
					type:"GET",
					url:"${pageContext.request.contextPath }/employee/deleteempbyid.action",
					data:{"empId":empObj.attr("empId")},
					dataType:"text",
					success:function(data){
						if(data == "true"){
							seekAjax(null,null,null,1);//ajax方法
						}
					}
				});
			}//删除员工奖金信息
			
			$(".seek").on("click",function(){
				var type = $("#type").val(); //下拉框值
				var seekVal = $("#surname").val(); //input值
				if(seekVal == "%"){
					empName = null;
					employeeTypeName = null;
					pose = null;
					seekAjax(null,null,null,1);//ajax方法
				}else{
				if(type=="empName"){
					if(seekVal==null || seekVal == ""){
						alert("请输入要搜索的员工姓名！");
					}else{
						empName = seekVal;
						employeeTypeName = null;
						pose = null;
						seekAjax(seekVal,null,null,1);//ajax方法
					}
				}else if(type=="empTypeName"){
					if(seekVal==null || seekVal == ""){
						alert("请输入要搜索的员工职位！");
					}else{
						empName = null;
						employeeTypeName = seekVal;
						pose = null;
						seekAjax(null,seekVal,null,1);//ajax方法
					}
				}else if(type=="pose"){
					if(seekVal==null || seekVal == ""){
						alert("请输入要搜索的状态！");
					}else{
						if(seekVal == "未发放"){
							empName = null;
							employeeTypeName = null;
							pose = 0;
							seekAjax(null,null,pose,1);//ajax方法
						}else if(seekVal == "已发放"){
							empName = null;
							employeeTypeName = null;
							pose = 1;
							seekAjax(null,null,pose,1);//ajax方法
						}
					}
				}
				}
			});//搜索按钮
			
			function seekAjax(empName,employeeTypeName,pose,currentPageNo){
				var sendVal = {"empName":empName,"employeeTypeName":employeeTypeName,"pose":pose,"currentPageNo":currentPageNo};
				$.ajax({
					type:'POST',
					url:'${pageContext.request.contextPath }/employee/getemployeelist.action',
					data:sendVal,
					dataType:"json",   
		            success: function(data){
		               showEmpInfo(data);
		            }
				});
			}//搜索ajax查询方法
			
			$(".last").on("click",function(){
				var currentPageNo = parseInt($(".currentPageNo").html()); //当前页
				var totalCount = parseInt($(".totalCount").html()); //总页数
				if(currentPageNo == 1){
					alert("已经是第一页了");
				}else{
					currentPageNo = currentPageNo-1;
					seekAjax(empName,employeeTypeName,pose,currentPageNo);//ajax方法
				}
			});//上一页点击数据
			
			$(".next").on("click",function(){
				var currentPageNo = parseInt($(".currentPageNo").html()); //当前页
				var totalCount = parseInt($(".totalCount").html()); //总页数
				if(currentPageNo == totalCount){
					alert("已经是最后一页了");
				}else{
					currentPageNo = currentPageNo+1;
					seekAjax(empName,employeeTypeName,pose,currentPageNo);//ajax方法
				}
			});//下一页点击数据
			
			//显示数据
			function showEmpInfo(data){
				$(".emptr").remove();
				var $str = "";
				$.each(data[0],function(key,val){
					$str+="<tr class='emptr'>"
						$str+="<td>"+val['empId']+"</td>"
						$str+="<td>"+val['empName']+"</td>"
						$str+="<td>"+val['employeeTypeList'][0]['empTypeName']+"</td>"
						$str+="<td>"+val['bonus']+"</td>"
						if(val['pose'] == 0){
						$str+="<td>未发放</td>"
						}
						if(val['pose'] == 1){
						$str+="<td>已发放</td>"	
						}
						$str+="<td>"+dateFormat(val['createDate']['time'])+"</td>"
						$str+="<td><a class='delEmp' href='javascript:;' empId = '"+val['empId']+"' empName = '"+val['empName']+"'><img title='删除' src='${pageContext.request.contextPath }/img/schu.png'></a></td>"
						$str+="</tr>"
				});
				$(".emptable").append($str);
				$(".currentPageNo").html(data[2]); //当前页
				$(".totalCount").html(data[1]);//总页数
				//当前页数为1时隐藏掉上下页，反之
				if(data.sumPage == 1){
					$(".pager").css("display","none");
				}else{
					$(".pager").css("display","block");
				}
			}
			
			//时间转换
			function dateFormat(longTypeDate){  
			    var dateType = "";  
			    var month = "";  
			    var day = "";  
			    var date = new Date(longTypeDate);
			    month = date.getMonth() + 1; //getMonth()得到的月份是0-11  
			    if(month<10){  //如果月份小于10月前面补个0
			        month = "0" + month;  
			    }  
			    day = date.getDate();  
			    if(day<10){  //如果天数小于10天数前补0
			        day = "0" + day;  
			    }  
			    dateType = date.getFullYear()+"-"+month+"-"+day;//yyyy-MM-dd格式日期
			    return dateType;
			} //时间long类型转换date类型
	    });
</script>