<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品详细信息修改页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
		
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/animate.min.css">
	<style type="text/css">
		.imgPath{
			width:65.8%;
			height:85%;
			position:absolute;
			top:4px;
			left:29.5%;			
			border:0px;
			outline:none;
			cursor: default;
		}
	</style>

  </head>
  
  <body>
     <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h4>
                          	&nbsp;&nbsp;报表管理&nbsp;&nbsp;》&nbsp;&nbsp;营业报表&nbsp;&nbsp;》&nbsp;&nbsp;商品信息&nbsp;&nbsp;》&nbsp;&nbsp;修改
                        </h4>
                    </div>
                    <br/>
                    <div class="ibox-content">
                    	<form class="form-horizontal m-t" id="signupForm" class="updForm" action="${pageContext.request.contextPath }/menuAction/updateMenuById.action" method="post" enctype="multipart/form-data">
                    		<input type="hidden" name="menuId" value="${menu.menuId }">
                    		<div class="form-group">
                                <label class="col-sm-2 control-label">菜名：</label>
                                <div class="col-sm-3">
                                    <input id="menuName" name="menuName" value="${menu.menuName }"  class="form-control menuName" type="text">
                                </div>
                                <label class="col-sm-2 control-label">类别名称：</label>
                                <div class="col-sm-4">
                                    <select id="navName" name="navId" class="form-control navselect">
								        	<c:forEach var="navigation" items="${navigationList }" varStatus="status">
								        	    <option class="animation_select mavption" data-animation="bounceInRight" value="${navigation.navId }" <c:if test="${navigation.navId == menu.navId}"> selected="selected"</c:if>>${navigation.navName }</option>
								            </c:forEach>
								    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单价：</label>
                                <div class="col-sm-3">
                                    <input id="unitPrice"  name="unitPrice" value="${menu.unitPrice }" class="form-control unitPrice" type="text">
                                </div>
                                <label class="col-sm-2 control-label">套餐名称：</label>
                                <div class="col-sm-4">
                                    <select id="comboName" name="comboId" class="form-control">
                                    	<c:forEach var="combo" items="${comboList }" varStatus="status">
                                    		<option value="${combo.comboId }" <c:if test="${combo.comboId == menu.comboId}"> selected="selected"</c:if>>${combo.comboName }</option>
                                    	</c:forEach>
								    </select>
                                </div>
                                
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">成本：</label>
                                <div class="col-sm-3">
                                    <input id="cost" name="cost" value="${menu.cost }" class="form-control cost" type="text">
                                </div>
                                <label class="col-sm-2 control-label">菜的主图：</label>
                                <div class="col-sm-4">
                                    <input id="imgPathOne" name="attachs" title="${menu.imgPathOne }" class="form-control imgfile" type="file" >
                                    <input readonly="readonly" name="imgPathOne" autocomplete="off" value="${menu.imgPathOne }" title="${menu.imgPathOne }" type="text" class="imgPath">
                                </div>
                                
                            </div>
                            <div class="form-group">                               
                                <label class="col-sm-2 control-label">单位：</label>
                                <div class="col-sm-3">
                                    <input id="unit" name="unit" value="${menu.unit }" class="form-control unit" type="text">
                                </div>
                                <label class="col-sm-2 control-label">详情图片：</label>
                                <div class="col-sm-4">           
                                    <c:choose>
                                    	<c:when test="${menu.imgPathTwo != null}">
                                    		<input id="imgPathTwo" name="attachs" title="${menu.imgPathTwo }" class="form-control imgfile imgtitle" type="file" >
                                    		<input value="${menu.imgPathTwo }" name="imgPathTwo" autocomplete="off" title="${menu.imgPathTwo }" type="text" class="imgPath imgtwo">
                                    	</c:when>
                                    	<c:otherwise>
                                    		<input id="imgPathTwo" name="attachs" title="未选择任何文件" class="form-control imgfile imgtitle" type="file" >
                                    		<input value="未选择任何文件（可选项）" name="imgPathTwo" autocomplete="off"  title="未选择任何文件" type="text" class="imgPath imgtwo">
                                    	</c:otherwise>
                                    </c:choose>                 
                                </div>                              
                            </div>
                            <div class="form-group">
                                
                                <label class="col-sm-2 control-label">打折：</label>
                                <div class="col-sm-3">
                                    <input id="discount" name="discount" value="${menu.discount }" class="form-control discount" type="text" placeholder="0">
                                </div>
                                <label class="col-sm-2 control-label">详情图片：</label>
                                <div class="col-sm-4">
                                    <c:choose>
                                    	<c:when test="${menu.imgPathThree != null}">
                                    		<input id="imgPathThree" name="attachs" title="${menu.imgPathThree }"  class="form-control imgfile imgtitle" type="file">
                                    		<input value="${menu.imgPathThree }" name="imgPathThree" autocomplete="off"  title="${menu.imgPathThree }" type="text" class="imgPath imgtwo">
                                    	</c:when>
                                    	<c:otherwise>
                                    		<input id="imgPathThree" name="attachs" title="未选择任何文件"  class="form-control imgfile imgtitle" type="file">
                                    		<input value="未选择任何文件（可选项）" name="imgPathThree" autocomplete="off"  title="未选择任何文件" type="text" class="imgPath imgthree">
                                    	</c:otherwise>
                                    </c:choose>  
                                </div>
                            </div>
                            <div class="form-group">                               
                                <label class="col-sm-2 control-label">描述：</label>
                                <div class="col-sm-3">
                                    <textarea style="max-width:145%;max-height:145px;min-width:90%;min-height:85px;" id="describe" name="describe" class="form-control describe" rows="" cols="">${menu.describe }</textarea>
                                </div>
                                <label class="col-sm-2 control-label"></label>
                                <div class="col-sm-4" style="margin-top:2%;">
                                    <button class="btn btn-primary" type="reset">重置</button>
                                    <button style="margin-left:15%" class="btn btn-primary btnSubmit" type="submit">提交</button>
                                    <a href="${pageContext.request.contextPath }/background/shoppinginfo.jsp">
                                    	<button style="margin-left:15%" id="btnReturn" class="btn btn-primary" type="button">返回</button>
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
    <!-- 表单验证 -->
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <script src="${pageContext.request.contextPath }/js/background/updshoppinginfo.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/background/return.js"> </script>
  </body>
</html>
