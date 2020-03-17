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
		<link rel="stylesheet" type="text/css" href="css/selectivity-jquery.css"/>
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/manager/init.min.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>
	<body>
		<header>
			<nav class="nav-extended">
				<div class="nav-content">
			      <ul class="tabs tabs-transparent">
			      </ul>
			   </div>
			</nav>
			<ul class="side-nav fixed center z-depth-3 deep-orange white-text" style="transform: translateX(0px);">
				<li>
					<ul id="menu" class="collapsible collapsible-accordion">
					<li ><h4>菜单</h4></li>
					<li><a class="btn orange z-depth-0 waves-effect">文章管理</a></li>
					<li><a class="btn orange z-depth-0 waves-effect">标签管理</a></li>
					<li><a class="btn orange z-depth-0 waves-effect">分类管理</a></li>
					<li><a class="btn orange z-depth-0 waves-effect">words</a></li>
					<li><a class="btn orange z-depth-0 waves-effect">个人信息</a></li>
				</ul>
				</li>
			</ul>
		</header>
		<main>
			<div class="container">
				<div class="row">
				</div>
			</div>
		</main>
		<footer>
			<div class="fixed-action-btn">
				<a href="user/logout" class="btn-floating btn-large waves-effect waves-light red" title="退出登录"><i class="material-icons">clear</i></a>
			</div>
		</footer>		
		<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/materialize.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/selectivity-jquery.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/utils/slip_page.min.js"></script>
		<script type="text/javascript" src="js/utils/EventElement.min.js" ></script>
		<script src="js/utils/material-init.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/utils/markdown-editor.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/init.js" ></script>
		<script src="js/manage/tag.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/manage/class-big.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/manage/class-small.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/manage/info.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/manage/words.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/manage/menu.js" ></script>
		<script src="js/manage/article-manage.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
