$(function(){
	getAllBig();
	initWords();
	initArticle();
	$("#searchByKey").submit(searchArticle);
	$("#slip").on("click",function(){
 		var li=getEventTarget(event);
 		if(li.tagName=="I"||li.tagName=="A"){
 			var url=li.parentElement.parentElement.getAttribute("data-url");
 			var index=li.getAttribute("data-url");
 			$.get({
 			url:url+index,
 			success:function(data){
 				$("#progree").removeClass("hide");
 				listIndexArticle(data);
 				slipPage(url,data);
 			}
 		});
 		}
 	});
	$(".button-collapse").sideNav();
});
function searchArticle(){
	var key=$("#search").val();
	console.log(key);
	var url="article/search/"+key;
	$.get({
		url:url+"/1/10",
		success:function(data){
			listIndexArticle(data);
			slipPage(url,data);
		}
	});
	return false;
}
function initArticle(){
	var url="article/search/_";
	$.get({
		url:url+"/1/10",
		success:function(data){
			listIndexArticle(data);
			slipPage(url,data);
		}
	});
}
function initWords(){
	$.get({
		url:"words/get/_/1/7",
		success:function(data){
			listIndexWords(data);
		}
	});
}
function getAllBig(){
	var url="big/get";
	$.get({
		url:url+"/1/100",
		success:function(data){
			listBig(data);
		}
	});
}
function listIndexArticle(data){
	var listView=$("#listArticle");
 	listView.empty();
 	var articleList=data.list;
 	if(articleList.length>0&&listView.hasClass("hide")){
 		listView.removeClass("hide");
 	}else if(articleList.length<=0&&!listView.hasClass("hide")){
 		listView.addClass("hide");
 	}
 	for(let article of articleList){
		 listView.append('<div class="card red"><div class="card-image  waves-effect waves-block waves-light"><a href="article/show/'+article.articleId+'" target="_blank"><img src="'+article.articleImage+'">'+
				 '<span class="card-title">'+article.small.smallName+'</span></a></div><div class="card-content">'+
				 '<span class="card-title activator grey-text text-darken-4">'+article.articleTitle+'<i class="material-icons right">more_vert</i></span>'+
				 '</div><div class="card-reveal"><span class="card-title grey-text text-darken-4">'+article.articleTitle+'<i class="material-icons right">close</i></span>'+
				'<p>'+article.articleContent+'</p></div></div>');
 	}
 	initMaterial();
 	$("#progree").addClass("hide");
}

function listIndexWords(data){
	var listView=$("#listWords");
 	listView.empty();
 	var wordsList=data.list;
 	if(wordsList.length>0&&listView.hasClass("hide")){
 		listView.removeClass("hide");
 	}else if(wordsList.length<=0&&!listView.hasClass("hide")){
 		listView.addClass("hide");
 	}
 	var day=new Date().getDay();
 	day=day==0?6:day-1;
 	var week=["周一","周二","周三","周四","周五","周六","周日",];
 	for(let index in wordsList){
 		var open=index==day ? "active":"";
		 listView.append(' <li><div class="collapsible-header '+open+'"><i class="material-icons">filter_drama</i>'+week[index]+'</div><div class="collapsible-body"><p>'+wordsList[index].wordsContent+'</p></div></li>');
 	}
 	initMaterial();
 	$("#progree").addClass("hide");
}

function listBig(data){
	var listView=$("#bigList");
	var listViewM=$("#bigListSlide");
	var listMoreView=$("#bigClass");
 	listView.empty();
 	listViewM.empty();
 	var bigList=data.list;
 	for(let index in bigList){
 		if(index<=3){
 			listView.append("<li class='bigClass' data-href='"+bigList[index].bigId+"'><a><i class='material-icons left'>code</i>"+bigList[index].bigName+"</a></li>");
 			listViewM.append("<li class='bigClass' data-href='"+bigList[index].bigId+"'><a class='white-text'><i class='material-icons left'>code</i>"+bigList[index].bigName+"</a></li>");
 		}else{
 			if(index==4){
 				listView.append("<li class='dropdown-button' data-activates='bigClass'><a><i class='material-icons left'></i>更多<i class='dropdown-button material-icons right'>arrow_drop_down</i></a></li>");
 				listViewM.append("<li class='dropdown-button' data-activates='bigClass'><a><i class='material-icons left'></i>更多<i class='dropdown-button material-icons right'>arrow_drop_down</i></a></li>");
 			}else{
 				listMoreView.append("<li class='bigClass' data-href='"+bigList[index].bigId+"'><a>"+bigList[index].bigName+"</a></li>");
 			}
 		}
 	}
 	var key=$(".bigClass").attr("data-href")[0];
 	getSmallByBig(key);
 	initMaterial();
 	$(".bigClass").click(function(){
 		var key=getEventTarget(event).parentElement.getAttribute("data-href");
 		if(key==null){
 			return;
 		}
 		getSmallByBig(key);
 	});
}

function getSmallByBig(key){
	var url="small/get/"+key;
	$.get({
		url:url+"/1/100",
		success:function(data){
			listSmall(data);
		}
	});
}
function listSmall(data){
	var listData=data.list;
	var listView=$("#smallList");
	var listViewM=$("#smallListSlide");
	listView.empty();
	listViewM.empty();
	listView.append("<ul class='tabs tabs-transparent'></ul>");
	listView=$("ul.tabs");
	for(let small of listData){
		listView.append('<li class="smallClass tab"><a data-href="'+small.smallId+'" >'+small.smallName+'</a></li>');
		listViewM.append('<li class="smallClass"><a data-href="'+small.smallId+'" class="white-text" >'+small.smallName+'</a></li>');
	}
	listView.tabs();
	$(".smallClass").click(function(){
		var key=getEventTarget(event).getAttribute("data-href");
		var url="article/get/"+key;
		$.get({
			url:url+"/1/10",
			success:function(data){
				listIndexArticle(data);
				slipPage(url,data);
			}
		});
	});
}


