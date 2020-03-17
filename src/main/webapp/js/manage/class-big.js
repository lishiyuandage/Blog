function addClassBig(){
	$("#addClassBig");
	var ClassBigName=$.trim($("#addClassBigName").val());
	var ClassBigDetails=$.trim($("#addClassBigDetails").val());
	if($.isEmptyObject(ClassBigName)){
		Materialize.toast("标签名不能为空！！",2000,"rounded red lighten-2");
		return;
	}
	$.post({
		url:"big/add",
		data:{
			bigName:ClassBigName,
			bigDetails:ClassBigDetails
		},
		success:function(data){
			Materialize.toast(data,2000,"rounded teal");
		}
	});
}
function searchClassBig(){
	var key=$("#search").val();
	var url="big/get/"+key;
	$.get({
		url:url+"/1/10",
		success:function(data){
			$("#progree").removeClass("hide");
			listClassBig(data);
			slipPage(url,data);
		}
	});
	return false;
}
function deleteClassBig(){
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
function editorClassBig(urlLink){
	var ClassBigId=urlLink.getAttribute("data-id");
	console.log(ClassBigId);
	var ClassBigDetails=urlLink.previousSibling.nodeValue;
	var ClassBigName=urlLink.parentElement.parentElement.previousElementSibling.innerText;
	$("#updateClassBigName").val(ClassBigName);
	$("#updateClassBigDetails").val(ClassBigDetails);
	$("#updateClassBig").modal("open");
	Materialize.updateTextFields();
	$("#updateClassBigButton").click(function(){
		var ClassBigName=$("#updateClassBigName").val();
		var ClassBigDetails=$("#updateClassBigDetails").val();
		$.post({url:"big/update",
			data:{_method:"put",bigName:ClassBigName,bigId:ClassBigId,bigDetails:ClassBigDetails},
			success:function(data){
				if(data=="更新成功"){
					urlLink.previousSibling.nodeValue=ClassBigDetails;
					urlLink.parentElement.parentElement.previousElementSibling.innerText=ClassBigName;
				}
				Materialize.toast(data,2000,"rounded teal");
		}});
	});
}
function listClassBig(data){
	var listView=$("#list");
 	listView.empty();
 	var ClassBigList=data.list;
 	if(ClassBigList.length>0&&listView.hasClass("hide")){
 		listView.removeClass("hide");
 	}else if(ClassBigList.length<=0&&!listView.hasClass("hide")){
 		listView.addClass("hide");
 	}
 	for(let ClassBig of ClassBigList){
		 listView.append("<li><div class='collapsible-header'>"+ClassBig.bigName+"</div>"+
					      "<div class='collapsible-body'><p>"+ClassBig.bigDetails+"<a class='btn right editor' data-id='"+ClassBig.bigId+"'><i class='material-icons'>mode_edit</i></a><a class='btn-flat right delete' data-href='big/delete/"+ClassBig.bigId+"'><i class='material-icons'>delete_forever</i></a> </p></div>");
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
 			editorClassBig(urlLink);
 		}
 	});
 	$("#progree").addClass("hide");
}
function initClassBig(){
	var url="big/get";
	$.get({
		url:url+"/1/10",
		success:function(data){
			$("#progree").removeClass("hide");
			listClassBig(data);
			slipPage(url,data);
		}
	});
}

function switchBig(){
	var container=$(".container .row");
	container.empty();
	container.append("<div class='col l12'><h5>大分类管理：<a class='btn-floating right btn-large' href='#addClassBig'><i class='material-icons'>add</i></a></h5></div>");
	container.append("<div class='col l12' style='margin-top: 5px;'>"+
							"<nav class='deep-orange darken-2   z-depth-0 '>"+
							"<div class='nav-wrapper hoverable'>"+
							"<form id='searchByKey'>"+"<div class='input-field'>"+"<input id='search' type='search' required>"+
							"<label class='label-icon' for='search'><i class='material-icons'>search</i></label>"+
							"<i class='material-icons'>close</i>"+
							"</div></form></div></nav></div>");
	container.append("<div  id='progree' class='progress  hide'><div class='indeterminate'></div>");
	container.append("<div class='col l12'><ul id='list'  class='collapsible hide' data-collapsible='accordion'></ul></div>");
	container.append("<div id='addClassBig' class='modal'><div class='modal-content'><h4>添加大分类</h4><p><div class='input-field'><i class='material-icons prefix'>label</i><input id='addClassBigName' type='text' class='validate'><label for='addClassBigName'>分类名</label></div><div class='input-field'><i class='material-icons prefix'>details</i><input id='addClassBigDetails' type='text' class='validate'><label for='addClassBigDetails'>分类说明</label></div></p></div><div class='modal-footer'><button id='addClassBigButton' class='modal-action waves-effect waves-green btn'>添加</button><a class=' modal-action modal-close waves-effect waves-green btn-flat'>取消</a></div></div>")
	container.append("<div id='updateClassBig' class='modal'><div class='modal-content'><h4>修改大分类</h4><p><div class='input-field'><i class='material-icons prefix'>label</i><input id='updateClassBigName' type='text' class='validate'><label for='updaeClassBigName'>分类名</label></div><div class='input-field'><i class='material-icons prefix'>details</i><input id='updateClassBigDetails' type='text' class='validate'><label for='addClassBigDetails'>分类说明</label></div></p></div><div class='modal-footer'><button id='updateClassBigButton' class='modal-action waves-effect waves-green btn'>修改</button><a class=' modal-action modal-close waves-effect waves-green btn-flat'>取消</a></div></div>")
	container.append("<div  id='slip'  class='col l12 center hide'></div>");
	initMaterial();
	initClassBig();
	$("#addClassBigButton").click(addClassBig);
	$("#searchByKey").submit(searchClassBig);
	$("#slip").on("click",function(){
 		var li=getEventTarget(event);
 		if(li.tagName=="I"||li.tagName=="A"){
 			var url=li.parentElement.parentElement.getAttribute("data-url");
 			var index=li.getAttribute("data-url");
 			$.get({
 			url:url+index,
 			success:function(data){
 				$("#progree").removeClass("hide");
 				listClassBig(data);
 				slipPage(url,data);
 			}
 		});
 		}
 	});
}