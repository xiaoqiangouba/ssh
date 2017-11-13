<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<title>后台管理页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
      <nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<img src="${pageContext.request.contextPath}/img/logo.png" alt="logo" >
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" id="li-11"><span >查看教师账号</span></a></li>
						<li><a href="#" id="li-21"><span ></span>导入教师账号</a></li>
						<li><a href="#" id="li-31"><span ></span>删除教师账号 </a></li>
					</ul>	
				</div>
			</div>
		</nav>
		<div class="jumbotron">
			<div class="container">
				<hgroup>
					<h1>管理员页面管理</h1>
					<h4>更多多功能，敬请期待</h4>
				</hgroup>
			</div>
		</div> 
		<div class="col-xs-12 col-sm-9 "style="background: #eee; width: 100%; height: 600px;border: 1px solid #ccc;" id="div-11">
			<c:if test="${list=='[]'}">
			    <div style="margin-left: 30%; font-size: 30px">目前没有教师信息</div>
			</c:if> 
			<c:forEach items="${list}" var="list">
				<p style="margin-left: 20%">
				   <span style="font-size: 20px;color: #000;">
				   		姓名:${list.name}
				   </span>
				   <span style="font-size: 20px;color: #000; margin-left: 10%;">
				   		密码:${list.password}
				   </span>
				</p>
			</c:forEach>	
		</div>
		<div class="col-xs-12 col-sm-9" style="background: #eee; width: 100%; height: 600px; display: none;border: 1px solid #ccc;"id="div-21">
			<span class="glyphicon glyphicon-plus" style="margin-top: 2%;margin-left: 35%;">
			       	 请管理员添加教师账号和初始密码(.xlsx文件)
			</span> 
			<form  method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/index/administrator" style="margin-top: 2%;margin-left: 30%;">
			    <input type="hidden" name="id" value="${id}" style="width:235px; margin-left: 8%;margin-top: 10px;float: left;height: 31px;" /> 
             	<input type="file" name="file" style="width:235px; margin-left: 8%;margin-top: 10px;float: left;height: 31px;" required="required" />   
              	<input type="submit" name="Submit" value="添   加" class="btn btn-default" style="float: left;margin-top: 10px;float: left;"/>
           </form>
           <p>${administrator}</p>
           <span style="margin-top:1%;margin-left: 2%;float: left;">${viewimport}</span>  
		</div>
		<div class="col-xs-12 col-sm-9" style="background: #eee; width: 100%;display: none; border: 1px solid #ccc;height: 600px;"id="div-31" >
		    <c:if test="${list=='[]'}">
			   <div style="margin-left: 30%; font-size: 30px">目前没有教师信息</div>
			</c:if> 
			<c:if test="${list!='[]'}">
			 	<c:forEach items="${list}" var="list">
				<div style="margin-left: 20%;">
						<div style="font-size: 20px;color: #000; float: left;">
				   			姓名:${list.name}
				        </div>
				  		<div style="font-size: 20px;color: #000; margin-left: 10%;float: left; width:150px; ">
				   			密码:${list.password}
				   		</div>
				   		<div style="font-size: 20px;color: #000; margin-left: 10%;float: left;">
				   			<form action="${pageContext.request.contextPath}/index/delecttea" method="post" style="float: left;">
				            	<input name="name" value="${list.name}" type="hidden">
				   	            <input name="password" value="${list.password}" type="hidden">
				              	<input type="submit" value="删  除" class="btn btn-default" >
			                 </form>
				   		</div>
				   		<br><br>
				</div>
				
			</c:forEach>	
            <h style="font-size: 20px;color: #000; margin-left: 30%;">${delecttea}</h>
			</c:if> 
			
		</div>
        <footer id="footer">
			<div class="container">
				<p>广西科技大学 计软142班 第一组</p>
			</div>
        </footer>
       <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.0.0.min.js"></script>
       <script type="text/javascript">
       $(document).ready(function(){
    	   $('#li-11').click(function(){
    			 $("#div-21").css("display","none");
    			 $("#div-31").css("display","none");
    			 $("#div-11").css("display","block");
    		});
    		$('#li-21').click(function(){
    		 	 $("#div-21").css("display","block");
    		 	 $("#div-31").css("display","none");
    			 $("#div-11").css("display","none");
    		});
    		$('#li-31').click(function(){
    			 $("#div-21").css("display","none");
    			 $("#div-31").css("display","block");
    			 $("#div-11").css("display","none");
    		});
    	   
       });
       	
       </script>
       
</body>
</html>