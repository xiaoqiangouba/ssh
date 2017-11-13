<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>软件工程管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">

</head>
<body>

<c:forEach items="${viewLogin}" var="viewLogin">
	<c:if test="${fn:contains(viewLogin, '同学')}">
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
						<li><a href="#" id="li-1"><span ></span> 成绩查询</a></li>
						<li><a href="#" id="li-2"><span ></span>上传报告</a></li>
						<li><a href="#" id="li-3"><span ></span>选题 </a></li>
						<li><a href="#" id="li-4"><span ></span>修改密码</a></li>
					</ul>	
				</div>
			</div>
		</nav>
		<div class="jumbotron">
			<div class="container">
				<hgroup>
					<h1>${viewLogin}进入系统</h1>
					<h4>更多多功能，敬请期待</h4>
				</hgroup>
			</div>
		</div>                                   
		<div class="col-xs-12 col-sm-9 "style="background: #eee; border: 1px solid #ccc;width: 100%; height: 60%;" id="div-1">

			<c:if test="${studentsubject=='[null]'}">
				<div style=" width: 100%; height:600px;" class="jumbotron">
					<h1>
						<span class="glyphicon glyphicon-open" aria-hidden="true" style="color: red; font-size: 25px;margin-top: 10%;margin-left: 30%; ">你还没有选提目</span>
					</h1>
			     	 			
			    </div>
			</c:if >
			<c:if test="${studentsubject!='[null]'}">
			    <c:if test="${leagueList=='[null]' }">
			    	<div style=" width: 100%; height:600px;" class="jumbotron">
						<c:forEach items="${studentsubject}" var="studentsubject">
							<h1 style="font-size: 20px; color: #000;margin-top: 10%;margin-left: 35%;">题名:${studentsubject}</h1>
					        <h1 style="font-size: 20px; color: #000;margin-left: 35%;">分数:老师未给成绩</h1>
						</c:forEach>
			   		 </div>
			    </c:if>	
				<c:if test="${leagueList!='[null]' }">
			    	<div style=" width: 100%; height:600px;" class="jumbotron">
						<c:forEach items="${studentsubject}" var="studentsubject">
							<h1 style="font-size: 20px; color: #000;margin-top: 10%;margin-left: 35%;">题名:${studentsubject}</h1>
					        <h1 style="font-size: 20px; color: #000;margin-left: 35%;">分数:${leagueList}</h1>
						</c:forEach>
			   		 </div>
			    </c:if>	
			</c:if>
		</div>
		<div class="col-xs-12 col-sm-9" style="background: #eee; border: 1px solid #ccc; width: 100%; height: 600px; display: none;"id="div-2">
			<span class="glyphicon glyphicon-open" aria-hidden="true" style="font-size: 25px;margin-top: 10%;margin-left: 30%; ">
			   请上传你的报告书
			</span>	
			<form  method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/index/uploadReport" style="margin-top: 2%;margin-left: 30%;">
            	<input type="file" name="file" style="width:235px; float: left; " required="required" />
            	<span class="glyphicon glyphicon-pencil" style="float: left;">
			       	 报告书命名请以小组名加名称
			    </span> 
            	<input type="hidden" value="${id}" name="id"> 
            	<br> 
              	<input type="submit" name="Submit" value="上     传" class="btn btn-default" style="margin-top: 10px; width: 120px;"/> 	
                <p style="margin-top: 10px;">${vi}</p>
            </form>	
            <div class="container" style=" width: 80%; height: 300px;">
            	<div class="container" style=" width: 80%; height: 280px;">
            		<span class="glyphicon glyphicon-pencil" style="float: left; font-size: 20px;color: #000;margin-left: 10%;">
			       	 	填写你的实训进度
			        </span>
			        <form action="">
			        	<input type="hidden" value="${id}" id="in1">
			        	<textarea rows="100" cols="100" style="width: 80%;margin-left: 10%;margin-top: 10px; height: 150px;" id="text">
			            </textarea> 
			            <input type="button" name="Submit" value="提     交" class="btn btn-default" style="margin-top: 10px; width: 120px; margin-left: 42%;" id="bu"/>
			        </form>
			       
            	</div>
            </div>
		</div>
		<div class="col-xs-12 col-sm-9" style="background: #eee; width: 100%; height: auto;display: none; border: 1px solid #ccc;"id="div-3">
			<c:if test="${question=='[]'}">
				<div style=" width: 100%; height:600px;" class="jumbotron">
					<h1>
						<span class="glyphicon glyphicon-warning-sign" aria-hidden="true" style="color: red; font-size: 25px;margin-top: 10%;margin-left: 30%; ">老师还没有上传题目，题库为空</span>
					</h1>
			    </div>
			</c:if>
			<c:if test="${question!='[]'}">
				<div style=" width: 100%; height:600px;" class="jumbotron">
				<p style="margin-left:25%;font-size: 20px;color: #000;">题   名</p>
					<div style="width:80%;margin-left: 10%; ">
						<div style="width: 50%;float: left;">
							<c:forEach items="${question}" var="question">
								<form action="${pageContext.request.contextPath}/index/xuan" method="post" style="text-align: center;font-size: 15px;color: #000;margin-top: 5px;">
				   					<input type="hidden" value="${id}" name="id">
				   					<input type="hidden" value="${question.title}"name="tit_name">
				   					<p>${question.title}</p>
				   					<input type="submit" name="Submit" value="选    题" class="btn btn-default" style=" width: 100px;"/> 
				  			 	</form>
				  			</c:forEach>
				  			
						</div>
					</div>
					${suanti}
				<div style=" width:300px;float: left;">
				<p style="font-size: 15px;color: #000;"><span class="glyphicon glyphicon-pencil"></span>填写小组成员</p>
					 <div class="input-group" style="margin-top: 10px;">
  							<span class="input-group-addon" id="basic-addon1" style="font-size: 10px;color: #000; ">小组人数</span>
 							<input type="text" id="js_add_num" name="js_add_num" size="4" onkeyup="addtextarea(this.value)" style="width:172px;"/>
					 </div>
					 <form id="inputs" action="" method="post">
						
					
					 </form>
				</div>
			</div>
			</c:if>
		</div>
		<div class="col-xs-12 col-sm-9" style="background: #eee; width: 100%; height: 600px;display: none; border: 1px solid #ccc;"id="div-4">
			<div style=" margin-top:10%;margin-left:40%; width: 50%; float: left; " class="col-xs-12 col-sm-9">
				<form action="" method="post" >
				    <input type="hidden" value="${id}" id="in">
 					<div class="input-group" style="width: 400px;">
 						<span class="input-group-addon" id="basic-addon1">
 							<span class="glyphicon glyphicon-lock"></span>
 					    </span>
  						<p>
  							<input type="password" style="width: 250px;" class="form-control" placeholder="密码,6至14数字和英文字母 " aria-describedby="basic-addon1"  name="password1" required="required" id="input1" onblur="Checkloin()">
  							<span class="glyphicon glyphicon-ok" style="color:#00db00; display:none ;" id="span_yes"></span>
  							<span style="color:red;display: none;font-size: 15px;" id="span_no">密码格式不正确</span>
  						</p>
					</div>	
					<div class="input-group" style="width: 400px; margin-top:2%;">
 						<span class="input-group-addon" id="basic-addon1">
 							<span class="glyphicon glyphicon-lock"></span>
 					    </span>
  						<input type="password" style="width: 250px;" class="form-control" placeholder="确认密码,6至14数字和英文字母" aria-describedby="basic-addon1"  name="password" required="required" id="input2" onblur="Checkloin()">
						<span class="glyphicon glyphicon-ok" style="color:#00db00; display:none ; " id="span_yess"></span>
  						<span style="color:red;display: none;font-size: 15px;" id="span_noo">两次密码不一致</span>
					</div>
                	<input type="button" value="确    定" class="btn btn-default" style="margin:2% 0 0 12%; width: 120px; display: none; " id="button-ps">
    			</form>	
    			<p>${viewpassword}</p>
			</div>	
		</div>
			
	</c:if>
	<c:if test="${fn:contains(viewLogin, '教师')}">
	    <input value="${viewLogin}" id="viewLogin" type="hidden">
	   
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
						<li><a href="#" id="li-11"><span ></span>上传题目</a></li>
						<li><a href="#" id="li-21"><span ></span>导入学生账号</a></li>
						<li><a href="#" id="li-31"><span ></span>查看报告并评分 </a></li>
						<li><a href="#" id="li-51"><span ></span>修改密码</a></li>
					</ul>	
				</div>
			</div>
		</nav>
		<div class="jumbotron">
			<div class="container">
				<hgroup>
					<h1>${viewLogin}进入系统</h1>
					<h4>更多多功能，敬请期待</h4>
				</hgroup>
			</div>
		</div> 
		<div class="col-xs-12 col-sm-9 "style="background: #eee; width: 100%; height: 600px;border: 1px solid #ccc;" id="div-11">
			<span class="glyphicon glyphicon-plus" style="margin-top: 2%;margin-left: 35%;">
			       	 请教师上传题目(.xlsx文件)
			</span> 
			<form  method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/index/importss" style="margin-top: 2%;margin-left: 30%;">
			    <input type="hidden" name="id" value="${id}" style="width:235px; margin-left: 8%;margin-top: 10px;float: left;height: 31px;" /> 
             	<input type="file" name="file" style="width:235px; margin-left: 8%;margin-top: 10px;float: left;height: 31px;" required="required" />   
              	<input type="submit" name="Submit" value="上  传" class="btn btn-default" style="float: left;margin-top: 10px;float: left;"/>
           </form>
           <span style="margin-top:1%;margin-left: 2%;float: left;">${viewimport}</span>  	
		</div>
		<div class="col-xs-12 col-sm-9" style="background: #eee; width: 100%; height: 600px; display: none;border: 1px solid #ccc;"id="div-21">
			<span class="glyphicon glyphicon-plus" style="margin-top: 2%;margin-left: 35%;">
			       	 请教师添加学生账号和初始密码(.xlsx文件)
			</span> 
			<form  method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/index/import" style="margin-top: 2%;margin-left: 30%;">
			    <input type="hidden" name="id" value="${id}" style="width:235px; margin-left: 8%;margin-top: 10px;float: left;height: 31px;" /> 
             	<input type="file" name="file" style="width:235px; margin-left: 8%;margin-top: 10px;float: left;height: 31px;" required="required" />   
              	<input type="submit" name="Submit" value="导入" class="btn btn-default" style="float: left;margin-top: 10px;float: left;"/>
           </form>
           <span style="margin-top:1%;margin-left: 2%;float: left;">${viewimport}</span>  
		</div>
		<div class="col-xs-12 col-sm-9" style="background: #eee; width: 100%;display: none; border: 1px solid #ccc;"id="div-31">
			<c:if test="${listt=='[]'}">
				<div style=" width: 100%; height:600px;" class="jumbotron">
					<h1>
						<span class="glyphicon glyphicon-alert" aria-hidden="true" style="color: red; font-size: 25px;margin-top: 10%;margin-left: 30%; ">还没学生上传报告</span>
					</h1>
			     	 			
			    </div>
			</c:if>
			<div style=" width: 100%; height:600px;" class="jumbotron">
				<c:forEach items="${listt}" var="list">
					<h1 style="font-size: 20px; color: #000;margin-top:10px;margin-left: 20%;">
						报告书:<a href="${pageContext.request.contextPath}/index/download?fileName=${list[0]}">${list[1]}</a>
						<span style="margin-left: 5%;">
							同学:${list[3]}
						</span>
						<span style="margin-left: 30px;">
							进度:${list[2]}
						</span>
							<form action="" method="post" style="margin-left: 10%;margin-top: 10px;">
								<input type="hidden" value="${list[0]}" id="ff">
								<input type="text" value="" id="fenshu"  required="required" style="height:30px;width: 120px; ">
								<input type="button" value="打  分" id="butt-df" class="btn btn-default" style="width:80px ;">
							</form>
					</h1>
				</c:forEach>
			</div>
		</div>
		<div class="col-xs-12 col-sm-9" style="background: #fff; width: 100%; height: 600px;display: none;"id="div-51">
			<div style=" margin-top:10%;margin-left:40%; width: 50%; float: left; " class="col-xs-12 col-sm-9">
				<form action="" method="post" >
				    <input type="hidden" value="${id}" id="in">
 					<div class="input-group" style="width: 400px;">
 						<span class="input-group-addon" id="basic-addon1">
 							<span class="glyphicon glyphicon-lock"></span>
 					    </span>
  						<p>
  							<input type="password" style="width: 250px;" class="form-control" placeholder="密码,6至14数字和英文字母 " aria-describedby="basic-addon1"  name="password1" required="required" id="input1" onblur="Checkloin()">
  							<span class="glyphicon glyphicon-ok" style="color:#00db00; display:none ;" id="span_yes"></span>
  							<span style="color:red;display: none;font-size: 15px;" id="span_no">密码格式不正确</span>
  						</p>
					</div>	
					<div class="input-group" style="width: 400px; margin-top:2%;">
 						<span class="input-group-addon" id="basic-addon1">
 							<span class="glyphicon glyphicon-lock"></span>
 					    </span>
  						<input type="password" style="width: 250px;" class="form-control" placeholder="确认密码,6至14数字和英文字母" aria-describedby="basic-addon1"  name="password" required="required" id="input2" onblur="Checkloin()">
						<span class="glyphicon glyphicon-ok" style="color:#00db00; display:none ; " id="span_yess"></span>
  						<span style="color:red;display: none;font-size: 15px;" id="span_noo">两次密码不一致</span>
					</div>
                	<input type="button" value="确    定" class="btn btn-default" style="margin:2% 0 0 12%; width: 120px; display: none;" id="button-ps1">
    			</form>	
    			<p>${viewpassword}</p>
			</div>		
		</div>
	</c:if>
</c:forEach>
<footer id="footer">
			<div class="container">
				<p>广西科技大学 计软142班 第一组</p>
			</div>
</footer>


<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
function Checkloin(){
	var password = $("#input1").val();
	var password1 = $("#input2").val();
	var regP= /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){5,16}$/;  
    var cps= regP.test(password);
    password=$.trim(password);
    password1=$.trim(password1);
    if(password){
    	 if(!cps){	 
    		 $("#span_no").css("display","block");
    		 $("#span_yes").css("display","none");
    		 $("#input1").css("border","2px solid red");
    		 $("#span_noo").css("display","none");
    		 $("#input2").css("1px solid #ccc");
    		 $("#span_yess").css("display","none");
    		 $("#button-ps").css("display","none");
    	    }else{
    	    	 $("#span_no").css("display","none");
    	    	 $("#span_yes").css("display","block");
    	    	 $("#input1").css("border","1px solid #eee");
    	    	 $("#span_noo").css("display","none");
        		 $("#input2").css("border","1px solid #eee");
        		 $("#span_yess").css("display","none");
        		 $("#button-ps").css("display","none");
    	    }
    }else{
    	 $("#span_no").css("display","none");
		 $("#span_yes").css("display","none");
		 $("#input1").css("border","1px solid #ccc");
		 $("#span_noo").css("display","none");
		 $("#input2").css("border","1px solid #ccc");
		 $("#span_yess").css("display","none");
		 $("#button-ps").css("display","none");
    }  
   if(password1){
    
    		if(password==password1){
       	   	 $("#span_yes").css("display","block");
       	   	 $("#span_yess").css("display","block");
       	   	 $("#span_no").css("display","none");
       		 $("#span_noo").css("display","none");
       		 $("#input1").css("border","1px solid #ccc");
       		 $("#input2").css("border","1px solid #ccc");
       	     $("#button-ps").css("display","block");
       	     $("#button-ps1").css("display","block");
       	      }
       	     else{
       	    	     $("#span_yes").css("display","none");
       	    	   	 $("#span_yess").css("display","none");
       	    	   	 $("#span_no").css("display","none");
       	    		 $("#span_noo").css("display","block");
       	    		 $("#input1").css("border","2px solid red");
       	    		 $("#input2").css("border","2px solid red");
       	    		 $("#button-ps").css("display","none");
    	}
    }
      
}


$(document).ready(function(){
	$('#li-1').click(function(){
		 $("#div-2").css("display","none");
		 $("#div-3").css("display","none");
		 $("#div-1").css("display","block");
		 $("#div-4").css("display","none");
	});
	$('#li-2').click(function(){
		 $("#div-2").css("display","block");
		 $("#div-3").css("display","none");
		 $("#div-1").css("display","none");
		 $("#div-4").css("display","none");
	});
	$('#li-3').click(function(){
		 $("#div-2").css("display","none");
		 $("#div-3").css("display","block");
		 $("#div-1").css("display","none");
		 $("#div-4").css("display","none");
	});
	$('#li-4').click(function(){
		 $("#div-2").css("display","none");
		 $("#div-3").css("display","none");
		 $("#div-1").css("display","none");
		 $("#div-4").css("display","block");
	});
	$('#li-11').click(function(){
		 $("#div-21").css("display","none");
		 $("#div-31").css("display","none");
		 $("#div-11").css("display","block");
		 $("#div-51").css("display","none");
	});
	$('#li-21').click(function(){
	 	 $("#div-21").css("display","block");
	 	 $("#div-31").css("display","none");
		 $("#div-11").css("display","none");
		 $("#div-51").css("display","none");
	});
	$('#li-31').click(function(){
		 $("#div-21").css("display","none");
		 $("#div-31").css("display","block");
		 $("#div-11").css("display","none");
		 $("#div-51").css("display","none");
	});
	$('#li-51').click(function(){
		 $("#div-21").css("display","none");
		 $("#div-31").css("display","none");
		 $("#div-11").css("display","none");
		 $("#div-51").css("display","block");
	});
});



function addtextarea(x){
	 if(x==""){
	  count=0;
	 }else{
	  count=x;
	 }
	 var inputs = document.getElementById("inputs");
	 
	    while(inputs.hasChildNodes()) //每次动态添加应该更新内容，当div下还存在子节点时 循环继续
	     {
	     inputs.removeChild(inputs.firstChild);
	     }
	    var button = document.createElement('input');
	  for (var i=0;i<count-1;i++){ 
		  var info_i = document.createElement("span");
		  var username = document.createElement("input"); //文本输入框节点
		  inputs.appendChild(document.createElement("br"));
		  info_i.innerHTML="组员名字：";//提示
		  username.type="text";
		  username.name="name_"+i;
		  username.id="zuyuan_"+i;//给这个input赋予id值  
		  inputs.appendChild(info_i);
		  inputs.appendChild(username);
		  inputs.appendChild(document.createElement("br"));
		  
		  
		  var in_i = document.createElement("span");
		  var banji=document.createElement("input"); //文本输入框节点
		  in_i.innerHTML="班级名称：";//提示
		  banji.type="text";
		  banji.name="banji"+i;
		  banji.id="banji_"+i;
		  inputs.appendChild(in_i);
		  inputs.appendChild(banji);
		  inputs.appendChild(document.createElement("br"));
		  
	  }  
	  
	  if(count>0){
		  inputs.appendChild(document.createElement("br"));
		  var zuzhang=document.createElement("input");
		  var zuzhang_in = document.createElement("span");
		  zuzhang_in.innerHTML="组长名称：";//提示
		  zuzhang.type="text";
		  zuzhang.name="zuzhang_"+i;
		  zuzhang.id="zuyuan_"+i; 
		  inputs.appendChild(zuzhang_in);
		  inputs.appendChild(zuzhang);
		  inputs.appendChild(document.createElement("br"));
		  var b=document.createElement("input");
		  var banji_in = document.createElement("span");
		  banji_in.innerHTML="班级名称：";//提示
		 
		  b.type="text";
		  b.name="banji"+i;
		  b.id="banji_"+i;
		  inputs.appendChild(banji_in);
		  inputs.appendChild(b);
		  button.type = 'button';
		  button.value="提  交";
		  button.id="button-1";
		  button.style="width:120px; margin-left: 26%;margin-top:10px; height: 30px;";
		  inputs.appendChild(button);
	  }
	 
	  $("#button-1").click(function(){
		  
			 var n=$('#js_add_num').val();
			 var arr1 = new Array(n);
			 var arr2 = new Array(n);
		     var name;
		     var i;
			 for ( i=0;i<n;i++){
				 arr2[i]=$('#zuyuan_'+i).val();
				 arr1[i]=$('#banji_'+i).val();
				
			 }
			 var ages={"n":n,"a":arr1.toString(),"b":arr2.toString(), "time":new Date()};
			 var ur="${pageContext.request.contextPath}/index/xuanti";
			 $.post(ur,ages,function(data){
				 
		          alert(data);
		       	});
		});
	 }

$(document).ready(function(){
	$('#button-ps').click(function(){
		var type=$('#viewLogin').val();
		var id=$("#in").val();
		var password = $("#input1").val();
		var ur="${pageContext.request.contextPath}/index/change";
		var ages={"password":password,"id":id,"time":new Date()};
	       $.post(ur,ages,function(data){
	          alert(data);
	       	});
	       		
	});
	$('#button-ps1').click(function(){
		var type=$('#viewLogin').val();
		var id=$("#in").val();
		var password = $("#input1").val();
		var ur="${pageContext.request.contextPath}/index/teacher";
		var ages={"password":password,"id":id,"time":new Date()};
	       $.post(ur,ages,function(data){
	          alert(data);
	       	});
	       		
	});
	
	$('#bu').click(function(){
		var id=$('#in1').val();
		var name=$('#text').val();
		name=$.trim(name);
		if(name){
			var ur="${pageContext.request.contextPath}/index/progress";
			var ages={"name":name,"id":id,"time":new Date()};
			$.post(ur,ages,function(data){
		          alert(data);
		       	});
		}
	});
	
	$('#butt-df').click(function(){
		var id=$('#ff').val();
		var name=$('#fenshu').val();
		name=$.trim(name);
		if(name){
			var ur="${pageContext.request.contextPath}/index/score";
			var ages={"name":name,"id":id,"time":new Date()};
			$.post(ur,ages,function(data){
		          alert(data);
		       	});
		}
	});
	
	
});

</script>

</body>
</html>