<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%String baseUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/"; %>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=baseUrl%>">
		<title>管理页面</title>
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="css/materialize.min.css" />
		<link rel="stylesheet" type="text/css" href="css/simplemde.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
		<link rel="stylesheet" href="styles/default.min.css">
		<link rel="stylesheet" type="text/css" href="css/manager/init.min.css"/>
		<script src="js/highlight.pack.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>
	<body>
		<header>
			<nav class="nav-extended">
				<div class="nav-content">
			      <ul class="tabs tabs-transparent">
			        <li class="tab"><a class="active" href="#test1">用户列表</a></li>
			      </ul>
			   </div>
			</nav>
			<div id="addUserModal"  class="modal ">
				  <div class="modal-content ">
				    <h4>添加用户</h4>
				    <p>
						<div class="input-field">
							<i class="material-icons prefix">account_circle</i>
				            <input id="addUserCode"  type="text"  class="validate"  name="addUserCode">
				            <label for="addUserCode">Code</label>
				        </div>
				        <div class="input-field">
							<i class="material-icons prefix">title</i>
				            <input id="addUserName"  type="text"  class="validate"  name="addUserName">
				            <label for="addUserName">用户名</label>
				        </div>
				         <div class="input-field">
							<i class="material-icons prefix">email</i>
				            <input id="addUserEmail"  type="email" class="validate" name="addUserEmail">
				            <label for="addUserEmail">用户邮箱</label>
				        </div>
					</p>
				  </div>
				  <div class="modal-footer">
				    <button class=" modal-action modal-close waves-effect waves-green btn-flat blue"  id="addUser">添加</button>
				    <button class=" modal-action modal-close waves-effect waves-green btn-flat">关闭</button>
				  </div>
				</div>
			<ul class="side-nav fixed center z-depth-3 deep-orange white-text" >
				<li>
					<ul class="collapsible collapsible-accordion">
						<li ><h4>菜单</h4></li>
						<li><a class="btn orange z-depth-0 waves-effect waves-light">人员管理</a></li>
					</ul>
				</li>
			</ul>
		</header>
		<main>
			<div class="container">
				<div class="row">
					<div class="col l12">
						<h4>用户管理：<a class="btn-floating right" href="#addUserModal"><i class="material-icons">add</i></a></h4>
					</div>
					<div class="col l12" style="margin-top: 5px;">
						<nav class="deep-orange darken-2   z-depth-0 ">
							<div class="nav-wrapper hoverable">
								<form  id="searchByKey"  action="user/search" >
							        <div class="input-field">
							          <input id="search" type="search" required name="key">
							          <label class="label-icon" for="search"><i class="material-icons">search</i></label>
							          <i class="material-icons">close</i>
							        </div>
						    	</form>
							</div>
						</nav>
					</div>
					<div class="col l12">
						<div class="col l12">
							<div class="input-field col l5">
								<i class="material-icons prefix">account_circle</i>
					            <input id="last_name" type="text" class="validate" name="userCode">
					            <label for="last_name">Code</label>
					        </div>
					        <div class="input-field col l5">
								<i class="material-icons prefix">title</i>
					            <input id="last_name"   name="userName"  type="text"  class="validate">
					            <label for="last_name">昵称</label>
					        </div>
					       <div class="input-field col l5">
								<i class="material-icons prefix">bookmark</i>
							    <select class="icons"  name="userSex">
							      <option value=""  disabled selected>选择性别</option>
							      <option value="false"  class="circle">女</option>
							      <option value="true"  class="circle">男</option>
							    </select>
							    <label>性别</label>
						  </div>
					        <div class="input-field col l5">
								<i class="material-icons prefix">email</i>
					            <input id="last_name" type="email" class="validate" name="userEmail">
					            <label for="last_name">邮箱</label>
					        </div>
					        <button class="btn input-field right"  id="conditionSearch">条件筛选</button>
						</div>
						<div  id="progree" class="progress  hide">
					      <div class="indeterminate"></div>
					  </div>
						<ul  id="list"  class="collapsible hide" data-collapsible="expandable">
						</ul>
						<div  id="slip"  class="col l12 center hide">
						</div>
					</div>
				</div>
			</div>
		</main>		
		<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/utils/EventElement.min.js"></script>
		<script type="text/javascript" src="js/utils/slip_page.min.js"></script>
		<script src="js/materialize.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/marked.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/simplemde.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/init.js" ></script>
		<script type="text/javascript" src="js/manage/user-manage.min.js"></script>
		<script type="text/javascript">
			 $(document).ready(function() {
			 	$(".modal").modal();
			    $('select').material_select();
			  });
		</script>
	</body>
</html>
