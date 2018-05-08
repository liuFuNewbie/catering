
var flag = false;
$(function(){
	//菜名的焦点事件
	$(".menuName").blur(function(){
		var menuName = $(this).val();
		if(menuName == null || menuName == ''){
			$(this).attr("placeholder","菜名不能为空！");
			flag = false;
		}
	});
	$(".menuName").focus(function(){
		$(this).removeAttr("placeholder");
		flag = true;
	});
	
	//单价的焦点事件
	$(".unitPrice").blur(function(){
		var unitPrice = $(this).val();
		if(unitPrice == null || unitPrice == ''){
			$(this).attr("placeholder","单价不能为空！");
			flag = false;
		}else if(isNaN(unitPrice)){
			$(this).val('');
			$(this).attr("placeholder","单价必须是数字！");
			flag = false;
		}
	});
	$(".unitPrice").focus(function(){
		$(this).removeAttr("placeholder");
		flag = true;
	});
	
	//成本的焦点事件
	$(".cost").blur(function(){
		var cost = $(this).val();
		if(cost == null || cost == ''){
			$(this).attr("placeholder","成本不能为空！");
			flag = false;
		}else if(isNaN(cost)){
			$(this).val('');
			$(this).attr("placeholder","成本必须是数字！");
			flag = false;
		}
	});
	$(".cost").focus(function(){
		$(this).removeAttr("placeholder");
		flag = true;
	});
	
	//单位的焦点事件
	$(".unit").blur(function(){
		var unit = $(this).val();
		if(unit == null || unit == ''){
			$(this).attr("placeholder","单位不能为空！");
			flag = false;
		}
	});
	$(".unit").focus(function(){
		$(this).removeAttr("placeholder");
		flag = true;
	});
	
	//折扣的焦点事件
	$(".discount").blur(function(){
		var discount = $(this).val();
		if(discount == null || discount == ''){
			$(this).attr("placeholder","折扣不能为空！");
			flag = false;
		}else if(isNaN(discount) || discount>10){
			$(this).val('');
			$(this).attr("placeholder","折扣必须是0~10的数字！");
			flag = false;
		}
	});
	$(".discount").focus(function(){
		$(this).removeAttr("placeholder");
		flag = true;
	});
	
	//描述的焦点事件
	$(".describe").blur(function(){
		var describe = $(this).val();
		if(describe == null || describe == ''){
			$(this).attr("placeholder","描述不能为空！");
			flag = false;
		}
	});
	$(".describe").focus(function(){
		$(this).removeAttr("placeholder");
		flag = true;
	});
	
	//详情图片虚拟input的焦点事件
	var imgpath;
	var imglength;
	$(".imgPath").focus(function(){
		imgpath=$(this).val();
		imglength = imgpath.length;
	});
	//详情图片虚拟input的change事件
	$(".imgPath").on("input propertychange",function(){
		var imglength1 = $(this).val().length;
		if(imglength1>imglength){
			$(this).val(imgpath);
		}else if(imglength1 < imglength){
			$(this).val("未选择任何文件（可选项）");
			$(this).attr("title","未选择任何文件");
			$(this).siblings(".imgtitle").attr("title","未选择任何文件");
			$(this).siblings(".imgtitle").val('');
		}
	});
	
	//菜的主图和详情图的change事件
	$(".imgfile").on("change",function(){
		var filetext =	$(this).val();
		filetext = filetext.substring(filetext.lastIndexOf("\\")+1,filetext.length);
	    if(!/\.(jpg|jpeg|png|JPG|JPEG|PNG)$/.test(filetext)){
	    	$(this).siblings(".imgPath").val('');
	    	$(this).siblings(".imgPath").attr("placeholder","图片上传格式必须是jpg|jpeg|png类型！");
	    	$(this).attr("title",'图片上传格式必须是jpg|jpeg|png类型！');
	    	$(this).siblings(".imgPath").attr("title",'图片上传格式必须是jpg|jpeg|png类型！');
	    	flag = false;
	    }else{
	    	$(this).siblings(".imgPath").val(filetext);
	    	$(this).attr("title",filetext);
	 	    $(this).siblings(".imgPath").attr("title",filetext);
	 	    flag = true;
	    }
	});
	
	//表单提交的点击事件
	$(".btnSubmit").click(function(){
		if($(".imgone").val() == "未选择任何文件"){
			flag=false;
		}
		if(flag==false){
			alert("数据提交不完整！");
			return false;
		}else{
			return true;
		}
	});
})