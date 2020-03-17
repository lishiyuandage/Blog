<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String baseUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/"; %>
<!DOCTYPE html>
<html>
	<head>
	<base href="<%=baseUrl %>">
		<meta charset="utf-8" />
		<title>博客首页</title>
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="css/materialize.min.css" />
		<link rel="stylesheet" type="text/css" href="css/index/layout.css"/>
		<link rel="stylesheet" type="text/css" href="css/index/color.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>
	<body class="green">
		<header class="navbar-fixed">
			<ul id="bigClass" class="dropdown-content ">
			</ul>
			<nav class="nav-extended blue-grey darken-4">
				<div class="nav-wrapper">
					<embed src="img/logo-noback.svg" height="65"  class="brand-logo" type="image/svg+xml" pluginspage="http://www.adobe.com/svg/viewer/install/" />
					<ul id="bigList" class="right hide-on-med-and-down">
						
					</ul>
				</div>
				<div id="smallList" class="nav-content hide-on-med-and-down">
						
			    </div>
			    <a  data-activates="slide-out" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="material-icons">menu</i></a>
			</nav>
			
		</header>
		<ul id="slide-out" class="side-nav green">
		    <li>
			    <div>
			      <a><span class="white-text name"><h4>分类</h4></span></a>
			    </div>
		    </li>
		    <li><a class="subheader grey-text text-lighten-4">大分类</a></li>
		    <li>
		    	<ul id="bigListSlide">
		    		
		    	</ul>
		    </li>
		    <li><div class="divider"></div></li>
		    <li><a class="subheader grey-text text-lighten-4">小分类</a></li>
		    <li>
		    	<ul id="smallListSlide">
		    		
		    	</ul>
			</li>
		  </ul>
		<main>
			<div class="blog-search container hoverable">
				<nav class="yellow darken-2  z-depth-0">
					<div class="nav-wrapper">
						<form id="searchByKey">
					        <div class="input-field">
					          <input id="search" type="search" required/>
					          <label class="label-icon" for="search"><i class="material-icons">search</i></label>
					          <i class="material-icons">close</i>
					        </div>
				    	</form>
					</div>
				</nav>
			</div>
			
			<div  id='progree' class='progress  hide'><div class='indeterminate'></div></div>
			<div class="container">
				<div class="row">
					<div class="col l8">
					    <div id='listArticle'>
					    	
					    </div>
					    <div  id='slip'  class='col l12 center hide'></div>
					</div>
					<div class="col l4">
						<ul id="listWords"  class="collapsible popout" data-collapsible="accordion">
						</ul>
						<div class="card z-depth-2 ">
						    <div class="collection with-header">
						    	<li class="collection-header"><h5>Ta这个网站</h5></li>
						        <a class="collection-item">说明：这是李大哥的个人博客</a>
						        <a href="#!" class="collection-item">联系：lee_dage@163.com</a>
						        <a href="#!" class="collection-item">友链申请：发送主题为博客友链申请的邮件给我，内容为你要加入的链接 </a>
						        <a href="#!" class="collection-item">声明：我的博客只代表我个人，我不想伤害任何人，所以我拒绝你传播；友链拒绝黄赌毒</a>
						     </div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<footer class="page-footer yellow darken-4">
			<div class="container">
	            <div class="row">
	              <div class="col l6 s12">
	                <h5 class="white-text">致谢</h5>
	                <p class="grey-text text-lighten-4">感谢Alvin Wang、Alan Chang、Alex Mark和Kevin Louie开源的materializecss前端框架<br />感谢spring 、mybatis等等框架的开发者和组织</p>
	              </div>
	              <div class="col l4 offset-l2 s12">
	                <h5 class="white-text">Link</h5>
	                <ul>
	                  <li><a class="grey-text text-lighten-3" href=”https://materializecss.com/“ target="_blank">Materialize</a></li>
	                  <li><a class="grey-text text-lighten-3" href="http://www.mybatis.org/"  target="_blank">mybatis</a></li>
	                  <li><a class="grey-text text-lighten-3" href="http://spring.io/"  target="_blank">Spring</a></li>
	                  <li><a class="grey-text text-lighten-3" href="https://pagehelper.github.io/"  target="_blank">pagehelper</a></li>
	                </ul>
	              </div>
	            </div>
          	</div>
            <div class="footer-copyright">
	            <div class="container">
	            © 2019 Copyright bigbrotherLee
	            <a class="grey-text text-lighten-4 right" href="index.jsp">i love u</a>
            </div>
          </div>
		</footer>
		<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/materialize.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/utils/EventElement.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/utils/material-init.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/index/init.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/utils/slip_page.min.js" type="text/javascript" charset="utf-8"></script>
		
	</body>
</html>