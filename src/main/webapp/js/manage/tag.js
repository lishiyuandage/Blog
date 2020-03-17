function addTag(){
	$("#addTag");
	var tagName=$.trim($("#addTagName").val());
	var tagDetails=$.trim($("#addTagDetails").val());
	if($.isEmptyObject(tagName)){
		Materialize.toast("标签名不能为空！！",2000,"rounded red lighten-2");
		return;
	}
	$.post({
		url:"tag/add",
		data:{
			tagName:tagName,
			tagDetails:tagDetails
		},
		success:function(data){
			Materialize.toast(data,2000,"rounded teal");
		}
	});
}

function searchTag(){
	var key=$("#search").val();
	var url="tag/get/"+key;
	$.get({
		url:url+"/1/10",
		success:function(data){
			$("#progree").removeClass("hide");
			listTag(data);
			slipPage(url,data);
		}
	});
	return false;
}
function deleteTag(){
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
function editorTag(urlLink){
	var tagId=urlLink.getAttribute("data-id");
	var tagDetails=urlLink.previousSibling.nodeValue;
	var tagName=urlLink.parentElement.parentElement.previousElementSibling.innerText;
	$("#updateTagName").val(tagName);
	$("#updateTagDetails").val(tagDetails);
	$("#updateTag").modal("open");
	Materialize.updateTextFields();
	$("#updateTagButton").click(function(){
		var tagName=$("#updateTagName").val();
		var tagDetails=$("#updateTagDetails").val();
		$.post({url:"tag/update",
			data:{_method:"put",tagName:tagName,tagId:tagId,tagDetails:tagDetails},
			success:function(data){
				if(data=="已修改"){
					urlLink.previousSibling.nodeValue=tagDetails;
					urlLink.parentElement.parentElement.previousElementSibling.innerText=tagName;
				}
				Materialize.toast(data,2000,"rounded teal");
		}});
	});
}
function listTag(data){
	var listView=$("#list");
 	listView.empty();
 	var tagList=data.list;
 	if(tagList.length>0&&listView.hasClass("hide")){
 		listView.removeClass("hide");
 	}else if(tagList.length<=0&&!listView.hasClass("hide")){
 		listView.addClass("hide");
 	}
 	for(let tag of tagList){
		 listView.append("<li><div class='collapsible-header'>"+tag.tagName+"</div>"+
					      "<div class='collapsible-body'><p>"+tag.tagDetails+"<a class='btn right editor' data-id='"+tag.tagId+"'><i class='material-icons'>mode_edit</i></a><a class='btn-flat right delete' data-href='tag/delete/"+tag.tagId+"'><i class='material-icons'>delete_forever</i></a> </p></div>");
 	}
 	listView.on("click",function(event){
 		var urlLink=getEventTarget(event);
 		if($(urlLink).hasClass("delete")){
 			var url=urlLink.getAttribute("data-href");
	 		$.post({
	 			url:url,
				data:{_method:"delete"}, 			
	 			success:function(data){
	 				urlLink.parentElement.parentElement.parentElement.remove();
	 				Materialize.toast(data);
	 			}
	 		});
 		}else if($(urlLink).hasClass("editor")){
 			editorTag(urlLink);
 		}
 	});
 	$("#progree").addClass("hide");
}
function initTag(){
	var url="tag/get";
	$.get({
		url:url+"/1/10",
		success:function(data){
			$("#progree").removeClass("hide");
			listTag(data);
			slipPage(url,data);
		}
	});
}

