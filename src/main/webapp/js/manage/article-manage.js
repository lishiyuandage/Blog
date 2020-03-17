$(document).ready(article);

//切换菜单
function changeManage(){
	var element=getEventTarget(event);
	var inner=element.innerHTML.substr(0,4);
	switch(inner){
		case "文章管理":
			article();
			break;
		case "标签管理":
			tag();
			break;
		case "分类管理":
			classify();
			break;
		case "word":
			words();
			break;
		case "个人信息":
			info();
			break;
		default :break;
	}
}

function initWrite(){
	var container=$(".container .row");
	container.empty();
	container.append("<div class='col l12'><h5>创作文章：</h5></div>");
//	文章标题
	container.append("<div class='input-field col l8 s8 m12'><i class='material-icons prefix'>title</i><input id='articleTitle' type='text' class='validate'><label for='last_name'>标题</label></div>");
//	分类
	container.append("<div class='col l12'><div class='input-field col s12 m5'><i class='material-icons prefix'>collections_bookmark</i><select id='bigId' class='bigId'></select> <label>大分类</label></div>"
			+"<div class='input-field col s12 m4'><i class='material-icons prefix'>class</i><select id='smallId' class='smallId'></select><label>小分类</label> </div></div>");
//	tag
	container.append("<div class='col l12'> <div class='chips'></div></div>");
//	封面
	container.append("<div class='col l12'><div class='file-field input-field'><div class='btn'><span>上传封面图片</span><input  type='file' id='file' accept='image/*' /></div><div class='file-path-wrapper'><input class='file-path validate' type='text'></div></div></div>");
//	f封面显示
	container.append("<div id='showImg' class='col l12'><img id='articleImage' /></div>");
	container.append("<div class='col l12'><a id='addArticle' class='btn right'>创建文章</a></div>");
	getAllBig();
	initMaterial();
	$("#bigId").change(getSmallByBig);
	$("#addArticle").click(createArticle);
	$("#file").change(imageUpload);	 
}

function getSmallByBig(){
	var key=$("#bigId").val();
	if($.isEmptyObject(key)){
		Materialize.toast("请选择大分类！！",2000,"rounded red lighten-2");
		return;
	}
	var url="small/get/"+key;
	$.get({
		url:url+"/1/100",
		success:function(data){
			var smallId=$(".smallId select");
			smallId.empty();
			var list=data.list;
			for(let small of list){
				smallId.append("<option value='"+small.smallId+"'>"+small.smallName+"</option>");
			}
			$('select').material_select();
		}
	});
	return false;
}

function initListArticle(){
	var container=$(".container .row");
	container.empty();
	container.append("<div class='col l12'><h5>文章管理：</h5></div>");
	container.append("<div class='col l12' style='margin-top: 5px;'>"+
			"<nav class='deep-orange darken-2   z-depth-0 '>"+
			"<div class='nav-wrapper hoverable'>"+
			"<form id='searchByKey'>"+"<div class='input-field'>"+"<input id='search' type='search' required>"+
			"<label class='label-icon' for='search'><i class='material-icons'>search</i></label>"+
			"<i class='material-icons'>close</i>"+
			"</div></form></div></nav></div>");
//	container.append("<div class='col l12' style='margin-top: 5px;'>"+
//			"<div class='input-field col s12 m5'><i class='material-icons prefix'>collections_bookmark</i><select  id='smallCondition'  class='smallId icons'><option value='' disabled selected>小分类</option></select><label>小分类</label></div>"+
//		    "<div class='input-field col l6'><i class='material-icons prefix'>title</i><select  id='tagCondition'  class='smallId icons'><label for='last_name'>标题</label></select><div>"+
//		    "<div class='col l12'><div class='switch col l3'><label>隐藏文章：</label><label> 是<input checked type='checkbox'><span class='lever'></span></label></div><div class='switch col l3'><label>关闭评论：</label><label>是<input checked type='checkbox'><span class='lever'></span>否</label></div></div>"+
//		    "<button id='searchByCondition'  class='btn input-field right'>条件筛选</button></div>");
	container.append("<div  id='progree' class='progress  hide'><div class='indeterminate'></div>");
	container.append("<div class='col l12'><ul id='list'  class='collection hide'></ul></div>");
	container.append("<div  id='slip'  class='col l12 center hide'></div>");
	initArticleList();
	initMaterial();
	$("#searchByKey").submit(searchArticle);
}

function searchArticle(){
	var key=$("#search").val();
	var url="article/search/"+key;
	$.get({
		url:url+"/1/10",
		success:function(data){
			$("#progree").removeClass("hide");
			listArticle(data);
			slipPage(url,data);
		}
	});
	return false;
}

function createArticle(){
	var articleTitle=$("#articleTitle").val();
	if($.isEmptyObject(articleTitle)){
		Materialize.toast("请填写文章标题！！",2000,"rounded red lighten-2");
		return;
	}
	var articleSmall=$("#smallId").val();
	if(articleSmall==""||articleSmall==null){
		Materialize.toast("请选择小分类！！",2000,"rounded red lighten-2");
		return;
	}
	var tagList=$(".chips .chip");
	var tags=[];
	for(let tagItem of tagList){
		tags.push(tagItem.firstChild.data);
	}
	var articleImage=$("#articleImage").attr("src");
	if($.isEmptyObject(articleImage)){
		Materialize.toast("请上传封面图片！！",2000,"rounded red lighten-2");
		return;
	}
	$.post({
		url:"article/add",
		traditional: true,//将数组转为参数
		data:{
			"small.smallId":articleSmall,
			articleTitle:articleTitle,
			articleImage:articleImage,
			tag:tags
		},
		success:function(data){
			window.open("article/editor/"+data.articleId,"_blank");
		},
		error:function(){
			Materialize.toast("创建失败！！",2000,"rounded red lighten-2");
		}
	});
}

function imageUpload(){
	var file=getEventTarget(event);
	var filemaxsize = 1024 * 3;//3M 
    var Size = file.files[0].size / 1024; 
    var upfile=file.files[0];
     if(Size > filemaxsize) { 
    	 Materialize.toast("图片不能大于3mb",2000,"rounded red lighten-2");
         return; 
     } 
     if(!file.files[0].type.match(/image.*/)) { 
    	 Materialize.toast("请选择正确格式的图片！！！",2000,"rounded red lighten-2");
    	 return;
     }
     var formdata=new FormData();
     formdata.append("file",upfile);
     $.post({
    	 url:"file/upload",
    	 processData:false,
   		contentType: false,
    	 data:formdata,
    	 success:function(data){
    		 $("#articleImage").attr("src",data);
    	 }
     });
}

function listArticle(data){
	var listView=$("#list");
 	listView.empty();
 	var articleList=data.list;
 	if(articleList.length>0&&listView.hasClass("hide")){
 		listView.removeClass("hide");
 	}else if(articleList.length<=0&&!listView.hasClass("hide")){
 		listView.addClass("hide");
 	}
 	for(let article of articleList){
		 listView.append("<li class='collection-item'>"+article.articleTitle+"<a class='secondary-content'><i class='material-icons delete'  data-href='article/delete/"+article.articleId+"'>delete_forever</i></a>" +
		 		"<a target='_blank'  href='article/editor/"+article.articleId+"'  class='secondary-content'><i class='material-icons'>editor</i></a></li>");
 	}
	initMaterial();
 	listView.on("click",function(event){
 		var urlLink=getEventTarget(event);
 		if($(urlLink).hasClass("delete")){
 			var url=urlLink.getAttribute("data-href");
	 		$.post({
	 			url:url,
				data:{_method:"delete"},
	 			success:function(data){
	 				urlLink.parentElement.parentElement.remove();
	 				Materialize.toast(data);
	 			}
	 		});
 		}
 	});
 	$("#progree").addClass("hide");
}

function initArticleList(){
	var url="article/get";
	$.get({
		url:url+"/1/10",
		success:function(data){
			$("#progree").removeClass("hide");
			listArticle(data);
			slipPage(url,data);
		}
	});
}