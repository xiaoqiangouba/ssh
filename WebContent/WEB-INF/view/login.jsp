<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>软件工程管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>
<body class="body">
    <!-- <div class="div-top" > -->
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner" role="listbox">
	        <div class="item active">
		        <img src="${pageContext.request.contextPath}/img/110.jpg"width="100%" height="100%">
	        </div>
        </div>
 	</div>
 	<div style=" width:350px;height:250px;z-index: 10000;position:absolute; top: 38%; left: 37%;" id="div-form">
 		<div class="container" style="width:100%;height:100%;z-index: 10000;position: absolute;">
			        <form action="${pageContext.request.contextPath}/login/login" method="post" >
 						<div class="input-group"style="margin:8% 0 0 22%;">
 							<span class="input-group-addon" id="basic-addon1">
 								<span class="glyphicon glyphicon-user"></span>
 					    	</span>
  							<input type="text" class="form-control" placeholder="用户名,六个汉字以内 " aria-describedby="basic-addon1" style="width:80%; " name="name" required="required" onblur="Checkloin()" id="loginname">
						</div>
						<div class="input-group"style="margin:5% 0 0 22%;">
							<span class="input-group-addon" id="basic-addon1">
 								<span class="glyphicon glyphicon-lock"></span>
 					   		 </span>
  							<input type="password" class="form-control" placeholder="密码，6至14数字和英文字母" aria-describedby="basic-addon1" style="width:80%;" name="password" required="required">
						</div>
			    		<input type="radio" name="type" value="学生" style="margin:5% 0 0 22%;"  checked="checked"/><span style="color:white;font-family: '黑体';">学  生</span>  
               			<input type="radio" name="type" value="教师" style="margin:5% 0 0 10%;"/><span style="color:white;font-family: '黑体';">教  师</span>
                		<input type="radio" name="type" value="游客 " style="margin:5% 0 0 10%;"/><span style="color:white;font-family: '黑体';">游  客</span>
                		<input type="submit" value="登  录" class="btn btn-default" style="margin:5% 0 0 32%; width: 40%; ">
    				</form>
    				<p style="margin:3% 0 0 32%; color: red;">${viewLogin}</p> 
    	</div>
     </div>
    
   <script type="text/javascript">
  /*  $('#button_Res').click(function(){
	   $(".ResBox").css("display","block");
   });
   $('#login').click(function(){
	   $(".ResBox").css("display","none");
   });
   function CheckUsn(){
	   var user = $("#name").val();
	   var regU = /^[\u4E00-\u9FA5]{1,6}$/;
	   var cus= regU.test(user);
	   var ul="${pageContext.request.contextPath}/login/Registered";
	   var ages={"name":user,"time":new Date()};
	   user=$.trim(user);
	   if(user){
		   if(!cus){
			   $("#span_no").css("display","block"); 
			   $("#span_yes").css("display","none");
			   $("#span_no1").css("display","none"); 
		   }else{
			   $("#span_no").css("display","none");
			   $.post(ul,ages,function(data){
	            	if(data=="用户名已存在"){
	            		 $("#span_yes").css("display","none"); 
	            		 $("#span_no1").css("display","block"); 
	            		 $("#span_no").css("display","none"); 
	  	  		    }else{
	  	  		         $("#span_no1").css("display","none"); 
	  	  		         $("#span_no").css("display","none"); 
	  	  		    	 $("#span_yes").css("display","block");
	  	  		    }  
	        });
		   }  
	   }else{
		   $("#span_no").css("display","none");
		   $("#span_no1").css("display","none");
		   $("#span_yes").css("display","none");
	   }
	   
   }; */
   //登陆用户名验证
   function Checkloin(){
	   var user = document.getElementById("loginname").value;
	   var regU = /^[\u4E00-\u9FA5]{1,6}$/;
	   var cus= regU.test(user);
	   user=$.trim(user);
	   if(user){
		   if(!cus) { 
			   $("#loginname").css("border","2px solid red");
		    }	  
	   }else{
		   $("#loginname").css("border","0 solid red");
	   }
   }
  /*  function Check() {
		 //验证密码格式
		    var cont=0,contt=0;
			var password = $("#password").val();
			var password1 = $("#password1").val();
			var regP= /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){5,16}$/;  
		    var cps= regP.test(password);
		    var ccps= regP.test(password1);
		    password=$.trim(password);
		    password1=$.trim(password1);
		    if(password){
		    	if(!cps) {  
			    	 $("#span_noo").css("display","block"); 
					 $("#span_yess").css("display","none");
			    	 $("#span_noo1").css("display","none"); 
			    	 $("#span_nooo1").css("display","none"); 
					 cont=0;
			    }else{
			    	 $("#span_noo").css("display","none"); 
					 $("#span_yess").css("display","block");
					 $("#span_noo1").css("display","none"); 
					 cont=1;
			    }
		    }else{
		    	 $("#span_noo").css("display","none"); 
				 $("#span_yess").css("display","none");
		    	 $("#span_noo1").css("display","none");
		    }
		    if(password1){
		    	 if(!ccps) {  
			    	 $("#span_nooo").css("display","block"); 
					 $("#span_yesss").css("display","none");
					 $("#span_noo1").css("display","none"); 
			    	 $("#span_nooo1").css("display","none");
					 contt=0;
			    }else{
			    	 $("#span_nooo").css("display","none"); 
					 $("#span_yesss").css("display","block");
					 $("#span_nooo1").css("display","none");
					 contt=1;
			    }
		    }else{
		    	 $("#span_nooo").css("display","none"); 
				 $("#span_yesss").css("display","none");
				 $("#span_nooo1").css("display","none"); 
				 
		    }
		    if( contt==1&&cont==1){
		    	if(password==password1&&password!=null&&password1!=""&&password1!=null&&password!=""){
			    	 $("#span_yess").css("display","block");
			    	 $("#span_yesss").css("display","block");
			    	 $("#span_noo").css("display","none"); 
			    	 $("#span_nooo").css("display","none"); 
			    	 $("#span_noo1").css("display","none"); 
			    	 $("#span_nooo1").css("display","none"); 
			       } else {
			    	 $("#span_yesss").css("display","none");
			    	 $("#span_yess").css("display","none");
			    	 $("#span_noo").css("display","none"); 
			    	 $("#span_nooo").css("display","none"); 
			    	 $("#span_noo1").css("display","block"); 
			    	 $("#span_nooo1").css("display","block"); 
			    	 
			     }
		    }	    
   }
   $('#button_Ress').click(function(){
		   var name=document.getElementById("name").value;
		   var password=document.getElementById("password").value;
		   var password1=document.getElementById("password1").value;
		   var ul="${pageContext.request.contextPath}/login/Registered";
		   password=$.trim(password);
		   password1=$.trim(password1);
		   name=$.trim(name);
	       var ages={"name":name,"password":password,"time":new Date()};
	          if((password!=null&&password1!=null&&name!=null)&&(password==password1)){
		    	   $.post(ul,ages,function(data){
		              if(data=="用户注册成功"){
		            		alert("用户注册成功");
		  	  		    }else{
		  	  		    alert("用户注已存在");
		  	  		    } 
		        });
	          }
   }); */
		
   </script>
</body>
</html>