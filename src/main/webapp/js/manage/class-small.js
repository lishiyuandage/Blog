function addClassSmall(){
	var ClassBigId=$("#addBigId").val();
	var ClassSmallName=$.trim($("#addClassSmallName").val());
	var ClassSmallDetails=$.trim($("#addClassSmallDetails").val());
	if($.isEmptyObject(ClassSmallName)){
		Materialize.toast("类别名不能为空！！",2000,"rounded red lighten-2");
		return;
	}
	if($.isEmptyObject(ClassBigId)){
		Materialize.toast("请选择大分类！！",2000,"rounded red lighten-2");
		return;
	}
	$.post({
		url:"small/add",
		data:{
			"big.bigId":ClassBigId,
			smallName:ClassSmallName,
			smallDetails:ClassSmallDetails
		},
		success:function(data){
			Materialize.toast(data,2000,"rounded teal");
		}
	});
}
function searchClassSmall(){
	var key=$("#search").val();
	if($.isEmptyObject(key)){
		Materialize.toast("请选择大分类！！",2000,"rounded red lighten-2");
		return;
	}
	var url="small/get/"+key;
	$.get({
		url:url+"/1/10",
		success:function(data){
			$("#progree").removeClass("hide");
			listClassSmall(data);
			slipPage(url,data);
		}
	});
	return false;
}
function deleteClassSmall(){
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
function editorClassSmall(urlLink){
	var ClassSmallId=urlLink.getAttribute("data-id");
	var ClassBigId=urlLink.getAttribute("data-big");
	var options=$("#updateBigId").val(ClassBigId);
	$("#updateBigId").material_select();
	var ClassSmallDetails=urlLink.previousSibling.previousSibling.previousSibling.nodeValue.substring(3);
	var ClassSmallName=urlLink.parentElement.parentElement.previousElementSibling.innerText;
	$("#updateClassSmallName").val(ClassSmallName);
	$("#updateClassSmallDetails").val(ClassSmallDetails);
	$("#updateClassSmall").modal("open");
	Materialize.updateTextFields();
	$("#updateClassSmallButton").click(function(){
		var ClassBigId=$("#updateBigId").val();
		var ClassSmallName=$("#updateClassSmallName").val();
		var ClassSmallDetails=$("#updateClassSmallDetails").val();
		$.post({url:"small/update",
			data:{_method:"put",smallName:ClassSmallName,smallId:ClassSmallId,smallDetails:ClassSmallDetails,"big.bigId":ClassBigId},
			success:function(data){
				if(data=="修改成功"){
					urlLink.previousSibling.previousSibling.previousSibling.nodeValue="说明："+ClassSmallDetails;
					urlLink.parentElement.parentElement.previousElementSibling.innerText=ClassSmallName;
				}
				Materialize.toast(data,2000,"rounded teal");
		}});
	});
}

function listClassSmall(data){
	var listView=$("#list");
 	listView.empty();
 	var ClassSmallList=data.list;
 	if(ClassSmallList.length>0&&listView.hasClass("hide")){
 		listView.removeClass("hide");
 	}else if(ClassSmallList.length<=0&&!listView.hasClass("hide")){
 		listView.addClass("hide");
 	}
 	for(let ClassSmall of ClassSmallList){
		 listView.append("<li><div class='collapsible-header'>"+ClassSmall.smallName+"</div>"+
					      "<div class='collapsible-body'><p>说明："+ClassSmall.smallDetails+"<br /> 所属大分类："+ClassSmall.big.bigName+"<a class='btn right editor' data-id='"+ClassSmall.smallId+"' data-big='"+ClassSmall.big.bigId+"'><i class='material-icons'>mode_edit</i></a><a class='btn-flat right delete' data-href='small/delete/"+ClassSmall.smallId+"'><i class='material-icons'>delete_forever</i></a> </p></div>");
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
 			editorClassSmall(urlLink);
 		}
 	});
 	$("#progree").addClass("hide");
}
function getAllBig(){
	var url="big/get";
	$.get({
		url:url+"/1/100",
		success:function(data){
			var bigId=$(".bigId select");
			var list=data.list;
			for(let big of list){
				bigId.append("<option value='"+big.bigId+"'>"+big.bigName+"</option>");
			}
			$('select').material_select();
		}
	});
}
function initClassSmall(){
	getAllBig();
	var url="small/get";
	$.get({
		url:url+"/1/10",
		success:function(data){
			$("#progree").removeClass("hide");
			listClassSmall(data);
			slipPage(url,data);
		}
	});
}

function switchSmall(){
	var container=$(".container .row");
	container.empty();
	container.append("<div class='col l12'><h5>小分类管理：<a class='btn-floating right btn-large' href='#addClassSmall'><i class='material-icons'>add</i></a></h5></div>");
	container.append("<div class='col l12' style='margin-top: 5px;'>"+
							"<div class='input-field col s12 m5'><i class='material-icons prefix'>collections_bookmark</i>"+
						   " <select  id='search'  class='bigId icons'>"+
						      "<option value='' disabled selected>选择大分类</option>"+
						    "</select>"+
						    "<label>大分类</label></div><button id='searchByKey'  class='btn input-field right'>条件筛选</button></div>");
	container.append("<div  id='progree' class='progress  hide'><div class='indeterminate'></div>");
	container.append("<div class='col l12'><ul id='list'  class='collapsible hide' data-collapsible='accordion'></ul></div>");
	container.append("<div id='addClassSmall' class='modal'><div class='modal-content'>" +
			"<h4>添加小分类</h4>" +
			"<p>" +
			"<div class='input-field'><i class='material-icons prefix'>collections_bookmark</i>"+
			   " <select id='addBigId'   class='bigId icons'>"+
			      "<option value='' disabled selected>选择大分类</option>"+
			    "</select>"+
			    "<label>大分类</label></div>"+
			"<div class='input-field'>" +
			"<i class='material-icons prefix'>label</i>" +
			"<input id='addClassSmallName' type='text' class='validate'>" +
			"<label for='addClassSmallName'>分类名</label>" +
			"</div><div class='input-field'><i class='material-icons prefix'>details</i><input id='addClassSmallDetails' type='text' class='validate'><label for='addClassSmallDetails'>分类说明</label></div></p></div><div class='modal-footer'><button id='addClassSmallButton' class='modal-action waves-effect waves-green btn'>添加</button><a class=' modal-action modal-close waves-effect waves-green btn-flat'>取消</a></div></div>")
	container.append("<div id='updateClassSmall' class='modal'><div class='modal-content'><h4>修改小分类</h4><p>" +
			"<div class='input-field'><i class='material-icons prefix'>collections_bookmark</i>"+
			   " <select id='updateBigId'  class='bigId icons'>"+
			      "<option value='' disabled selected>选大分类</option>"+
			    "</select>"+
			    "<label>大分类</label></div>"+
			"<div class='input-field'><i class='material-icons prefix'>label</i><input id='updateClassSmallName' type='text' class='validate'><label for='updateClassSmallName'>分类名</label></div><div class='input-field'><i class='material-icons prefix'>details</i><input id='updateClassSmallDetails' type='text' class='validate'><label for='updateClassSmallDetails'>分类说明</label></div></p></div><div class='modal-footer'><button id='updateClassSmallButton' class='modal-action waves-effect waves-green btn'>修改</button><a class=' modal-action modal-close waves-effect waves-green btn-flat'>取消</a></div></div>")
	container.append("<div  id='slip'  class='col l12 center hide'></div>");
	initMaterial();
	initClassSmall();
	$("#addClassSmallButton").click(addClassSmall);
	$("#searchByKey").click(searchClassSmall);
	$("#slip").on("click",function(){
 		var li=getEventTarget(event);
 		if(li.tagName=="I"||li.tagName=="A"){
 			var url=li.parentElement.parentElement.getAttribute("data-url");
 			var index=li.getAttribute("data-url");
 			$.get({
 			url:url+index,
 			success:function(data){
 				$("#progree").removeClass("hide");
 				listClassSmall(data);
 				slipPage(url,data);
 			}
 		});
 		}
 	});
}
