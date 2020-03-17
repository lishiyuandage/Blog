function addWords(){
	var WordsName=$.trim($("#wordsContent").val());
	if($.isEmptyObject(WordsName)){
		Materialize.toast("标签名不能为空！！",2000,"rounded red lighten-2");
		return;
	}
	$.post({
		url:"words/add",
		data:{
			wordsContent:WordsName
		},
		success:function(data){
			Materialize.toast(data,2000,"rounded teal");
		}
	});
}
function deleteWords(){
	var element=getEventTarget(event);
	var url=element.getAttribute("data-href");
	$.post({
		url:url,
		data:{_method:"delete"},
		success:function(data){
			Materialize.toast(data,2000,"rounded teal");
		}
	});
}

function listWords(data){
	var listView=$("#list");
 	listView.empty();
 	var WordsList=data.list;
 	if(WordsList.length>0&&listView.hasClass("hide")){
 		listView.removeClass("hide");
 	}else if(WordsList.length<=0&&!listView.hasClass("hide")){
 		listView.addClass("hide");
 	}
 	for(let Words of WordsList){
		 listView.append("<li class='collection-item'>"+Words.wordsContent+"<a class='secondary-content'><i class='material-icons delete'  data-href='words/delete/"+Words.wordsId+"'>delete_forever</i></a></li>");
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
function initWords(){
	var url="words/getUser";
	$.get({
		url:url+"/1/10",
		success:function(data){
			$("#progree").removeClass("hide");
			listWords(data);
			slipPage(url,data);
		}
	});
}
