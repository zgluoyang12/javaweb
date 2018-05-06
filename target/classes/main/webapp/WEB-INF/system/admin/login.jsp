<%@taglib prefix="base" uri="/WEB-INF/tlds/basejs.tld" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base:base  type="jquery,layui_css,layui" title="用户登录"></base:base>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="layui-container fly-marginTop"> 
		<div class="fly-panel fly-panel-user" pad20="">
			 <div class="layui-tab layui-tab-brief" lay-filter="user"> 
			 	<ul class="layui-tab-title"> 
			 		<li class="layui-this">登入</li> 
			 	 </ul> 
			 	<div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;"> 
			 		<div class="layui-tab-item layui-show"> 
				 		<div class="layui-form layui-form-pane">
				 			<form method="post">
						 			 <div class="layui-form-item"> 
						 				<label for="L_email" class="layui-form-label">用户名</label> 
						 				<div class="layui-input-inline"> 
						 					<input type="text" id="username" name="username" required="" lay-verify="required" autocomplete="off" class="layui-input"> 
						 				</div> 
						 			 </div>	
					 				<div class="layui-form-item"> 
					 					<label for="L_pass" class="layui-form-label">密码</label> 
					 					<div class="layui-input-inline"> 
					 						<input type="password" id="password"  name="password" required="" lay-verify="required" autocomplete="off" class="layui-input"> 
					 					</div> 
					 				</div> 
<!-- 					 				<div class="layui-form-item">  -->
<!-- 					 					<label for="L_vercode" class="layui-form-label">验证码</label> -->
<!-- 					 					 <div class="layui-input-inline"> -->
<!-- 					 					 	 <input type="text" id="L_vercode" name="vercode" required="" lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">  -->
<!-- 					 					 </div>  -->
<!-- 					 					 <div class="layui-form-mid">  -->
<!-- 					 					 	<span style="color: #c00;">"100" &gt; "2" 的结果是 true 还是 false？</span>  -->
<!-- 					 					 </div>  -->
<!-- 					 				</div>  -->
					 				<div class="layui-form-item"> 
					 					<button class="layui-btn" id="loginBtn" onclick="login()" >立即登录</button> 
					 				</div>
							</form>
					  </div>
				  </div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		
	});
	
	function login(){
		$.post(ctxPath + "/system/admin/login",{username:$("#username").val(),password:$("#password").val()},function(result){
				if(result.success){
					location.href =ctxPath+"/system/admin/index";
				}else{
					alert(result.msg);
				}
		});
	}
</script>
</html>