<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String baseUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/"; %>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=baseUrl %>">
		<meta charset="UTF-8">
		<title>登录</title>
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="css/materialize.min.css" />
		<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/materialize.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/utils/EventElement.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/login.min.js" ></script>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>
	<body>
		<div class="container" style="margin-top: 100px;">
			<div class="row">
				<div class="col l6 s12 m5 offset-m2 offset-l3">
					<div class="card z-depth-4">
						<form action="user/login" method="post">
							<div class="card-content">
								<div class="card-title center">
									<h4>登录</h4>
								</div>
								<div class="input-field">
									<i class="material-icons prefix">account_circle</i>
									<input type="text" name="userCode" id="userName" value=""  class="validate"/>
									<label for="userName">用户名</label>
								</div>
								<div class="input-field">
									<i class="material-icons prefix">lock</i>
									<input type="password" name="userPassword" id="userPassword" value=""  class="validate"/>
									<label for="userPassword">密码</label>
								</div>
								<p class="center">
							      <input name="userType" checked type="radio" id="user" />
							      <label for="user">作者</label>
							      <input name="userType" type="radio" id="admin" />
							      <label for="admin">管理</label>
							    </p>
							    <p class="center">
							    	<button type="submit" class="btn">登录</button>
							    </p>
							</div>	
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				Materialize.updateTextFields();
			});
		</script>
	</body>
</html>