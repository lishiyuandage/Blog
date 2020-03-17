<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%String baseUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/"; %>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=baseUrl%>">
		<meta charset="UTF-8">
		<title>editor</title>
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="css/materialize.min.css" />
		<link rel="stylesheet" type="text/css" href="css/simplemde.min.css"/>
		<link rel="stylesheet" href="styles/default.min.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<style type="text/css">
			.CodeMirror, .CodeMirror-scroll {
			  min-height:600px;
			}
		</style>
	</head>
	<body>
			<div class="container">
				<div class="row">
					<div class="col l12">
						<h5>${article.articleTitle}：</h5>
					</div>
					<div class="col l12">
							<input type="hidden" name="articleId"  id="articleId"  value="${article.articleId}">
							<textarea id="mdeditor" name="" rows="100" cols=""></textarea>	
							<!-- 插入图片模态 -->
							<div id="imageUpload" class="modal">
								<div class="modal-content">
									<h4>图片上传</h4>
									<div class="file-field input-field">
										<div class="btn">
											<span>文件</span>
											<input type="file" id="file"/>
										</div>
										<div class="file-path-wrapper">
											<input class="file-path validate" type="text">
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button id="addImg" class=" modal-action modal-close waves-effect waves-green btn">上传</button>
									<a class="modal-action modal-close waves-effect waves-green btn-flat">取消</a>
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
									<button class="modal-action modal-close waves-effect waves-green btn">添加</button>
									<a  class=" modal-action modal-close waves-effect waves-green btn-flat">取消</a>
								</div>
							</div>
					  </div>
					  <div class="col l12 ">
					  	<div class="switch col l3">
				        	<label>隐藏文章：</label>
					    	<label>
					     		 是
					      	<input id="hiddenArticle"  ${article.articleHide==true? null:"checked" }  type="checkbox">
					      	<span class="lever"></span>
					      		否
					    	</label>
					  	</div>
					  	 <div class="switch col l3">
				        	<label>关闭评论：</label>
					    	<label>
					     		 是
					      	<input id="closeCommit"  ${article.articleClose==true? "checked":null} type="checkbox">
					      	<span class="lever"></span>
					      		否
					    	</label>
					  	</div>
					  	<button id="updateArticle"  class="btn right">保存</button>
					  </div>
				</div>
			</div>
		<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/highlight.pack.js"></script>
		<script type="text/javascript" src="js/utils/EventElement.min.js" ></script>
		<script type="text/javascript" src="js/manage/menu.js" ></script>
		<script src="js/utils/material-init.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/utils/markdown-editor.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/materialize.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/marked.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/simplemde.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/init.js" ></script>
		<script type="text/javascript">
			var simplemde = editorFullInit();
			 $(document).ready(function() {
			 	initMaterial();
			 	$.get({
					url:"article/get/${article.articleId}",
					success:function(article){
						simplemde.value(article.articleContent);
					}
				});
			  });
			 $("#addImg").click(uploadFile);
			 $("#updateArticle").click(function(){
					var hiddenArticle=!document.getElementById("hiddenArticle").checked;
					var closeCommit=document.getElementById("closeCommit").checked;
					var articleContent=simplemde.value();
					var articleId=$("#articleId").val();
					$.post({
						url:"article/update",
						data:{
							_method:"put",
							articleId:articleId,
							articleContent:articleContent,
							articleHide:hiddenArticle,
							articleClose:closeCommit
						},
						success:function(){
							Materialize.toast("已保存",2000,"rounded teal lighten-2");
						},
						error:function(){
							Materialize.toast("出错",2000,"rounded teal lighten-2");
						}
					});
			 });
		</script>
	</body>
</html>