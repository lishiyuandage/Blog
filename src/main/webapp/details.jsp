<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String baseUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/"; %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=baseUrl %>">
		<title>文章详情</title>
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
		<link rel="stylesheet" href="css/materialize.min.css" />
		<link rel="stylesheet" type="text/css" href="css/simplemde.min.css"/>
		<style type="text/css">
			.collection {border: none;}
		</style>
	</head>
	<body>
		<header class="navbar">
			<nav class="blue-grey darken-4">
				<div class="nav-wrapper">
					<embed src="img/logo-noback.svg" height="65"  class="brand-logo hide-on-med-and-down" type="image/svg+xml" pluginspage="http://www.adobe.com/svg/viewer/install/" />
					<a class="brand-logo center" id="articleTitle"></a>
				</div>
			</nav>
		</header>
		<main>
			<div class="container">
				<div class="row">
					<div class="col l12 m12">
						<div class="card-panel z-depth-3">
							<div id="mdedtor">
							
							</div>
						</div>
						<div class="card-panel z-depth-3 ">
							<ul class="collection">
						      <li class="collection-item" id="tags">标签：</li>
						      <li class="collection-item container row">
						      	<div class="col l3">
						      		小分类：<a id="smallClass" href="" class="blue-text"></a> 
						      	</div>
						      	<div class="col l3">
						      		创建时间：<span id="createDate"></span>
						      	</div>
						      	<div class="col l3">
						      		作者：<a id="articleAuthor" ></a>
						      	</div>
						      	<div class="col l3">
						      		阅读量：<span id="articleSee" class="badge"></span>
						      	</div>
						      </li>
						   </ul>
						   <ul id="comments" class="collection with-header">
						       
						    </ul>
						</div>
						<div class="card-panel">
						    <div class="container row">
						    	<div class="input-field col l4">
									<i class="material-icons prefix">verified_user</i>
						            <input id="otherName" type="text" class="validate">
						            <label for="link">你的名字</label>
						        </div>
						        <div class="input-field col l4">
									<i class="material-icons prefix">email</i>
						            <input id="otherEmail" type="email" class="validate">
						            <label for="link_name">你的Email</label>
						        </div>
						        <div class="input-field col l4">
									<i class="material-icons prefix">info_outline</i>
						            <input id="otherConnect" type="text" class="validate">
						            <label for="otherConnect">你的其他联系方式</label>
						        </div>
						    </div>
						    <textarea id="mdeditor" ></textarea>	
						    <a id="addComment" class="btn">添加评论</a>
						</div>
					</div>
				</div>
			</div>
			<div id="addLink" class="modal">
				<div class="modal-content">
					<h4>添加链接</h4>
					<p>
						<div class="input-field">
							<i class="material-icons prefix">link</i>
				            <input id="link" type="text" class="validate">
				            <label for="link">你要添加的链接</label>
				        </div>
				        <div class="input-field">
							<i class="material-icons prefix">info_outline</i>
				            <input id="link_name" type="text" class="validate">
				            <label for="link_name">该链接的名称</label>
				        </div>
					</p>
				</div>
				<div class="modal-footer">
					<button onclick="insertLink()" class=" modal-action modal-close waves-effect waves-green btn">添加</button>
					<a class=" modal-action modal-close waves-effect waves-green btn-flat">取消</a>
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
		<script src="js/materialize.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/marked.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/simplemde.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/init.js" ></script>
		<script src="js/utils/material-init.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/utils/material-init.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/utils/markdown-editor.js" type="text/javascript" charset="utf-8"></script>
		<script>
		var key=location.href.substring(location.href.lastIndexOf("/")+1);
		Date.prototype.Format = function (fmt) { //author: meizz 
		    var o = {
		        "M+": this.getMonth() + 1, //月份 
		        "d+": this.getDate(), //日 
		        "h+": this.getHours(), //小时 
		        "m+": this.getMinutes(), //分 
		        "s+": this.getSeconds(), //秒 
		        "q+": Math.floor((this.getMonth() + 3) / 3), 
		        "S": this.getMilliseconds() //毫秒 
		    };
		    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		    for (var k in o)
		    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		    return fmt;
		}
			var simplemde = editorSimpleInit();
		  $(function(){
			   $.get({
				   url:"article/get/"+key,
				   success:function(data){
					   $('#mdedtor').append(marked(data.articleContent));
					   $('#articleTitle').append(data.articleTitle);
					   $('#smallClass').attr("href","article/small/"+data.small.smallId);
					   $('#smallClass').append( data.small.smallName) ;
					   $('#createDate').append( new Date(data.articleCreateDate).Format("yyyy-MM-dd")) ;
					   $('#articleAuthor').append( data.user.userName) ;
					   $('#articleAuthor').attr("href","article/author/"+data.user.userId) ;
					   $('#articleSee').append(data.articleSee);
					   var tagView=$("#tags");
					   var tagList=data.tags;
					   for(let tag of tagList){
						   tagView.append('<a href="article/tag/'+tag.tagId+'" class="chip teal lighten-1 white-text">'+tag.tagName+'</a>');
					   }
					   var comments=data.comments;
					   var commentView=$("#comments");
					   commentView.append('<li class="collection-header"><h5>文章评论：</h5></li>');
					   for(let index in comments){
						   if(parseInt(index)<=3){
							   commentView.append(' <li class="collection-item">'+marked(comments[index].commentContent)+'</li>');
						   }
					   }
					   initMaterial();
				   }
		   });});
		  $("#addComment").click(function(){
			  var reg=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			  var otherName=$.trim($("#otherName").val());
			  if($.isEmptyObject(otherName)){
				  Materialize.toast("你的名字不能为空",2000,"rounded red lighten-2");
				  return;
			  }
			  var otherEmail=$("#otherEmail").val();
			  if(!otherEmail.match(reg)){
				  Materialize.toast("请输入正确格式的Email地址",2000,"rounded red lighten-2");
				  return;
			  }
			 
			  var otherConnect=$("#otherConnect").val();
			  var commentContent=simplemde.value();
			  var commentArticle=key;
			  if($.isEmptyObject(commentContent)){
				  Materialize.toast("评论内容不能为空",2000,"rounded red lighten-2");
				  return;
			  }
			  if(commentContent.length>150){
				  Materialize.toast("评论内容不能多于150字符",2000,"rounded red lighten-2");
				  return;
			  }
			  $.post({
				  url:"comment/add",
				  data:{
					  commentContent:commentContent,
					  commentOtherEmail:otherEmail,
					  commentOtherName:otherName,
					  commentOtherConnect:otherConnect,
					  commentArticle:commentArticle
				  },
				  success:function(){
					  Materialize.toast("添加评论成功",2000,"rounded teal lighten-2");
				  },
				  error:function(){
					  Materialize.toast("添加失败",2000,"rounded red lighten-2");
				  }
			  });
		  });
		 </script> 
	</body>
</html>
