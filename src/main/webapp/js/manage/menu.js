function article(){
	$("#menu li").click(changeManage);
	var tabStr=' <li class="tab"><a class="active"  href="#writeArticle">写文章</a></li><li class="tab"><a href="#articleList">我的文章</a></li>';
	initTabs(tabStr);
	initWrite();
	$(".tab").click(()=>{
		var a=getEventTarget(event);
		var msg=a.getAttribute("href");
		if(msg=="#writeArticle"){
			initWrite();
		}else if(msg=="#articleList"){
			initListArticle();
		}
	});
}

function tag(){
	var tabString="<li class='tab'><a >标签列表</a></li>";
	initTabs(tabString);
	var container=$(".container .row");
	container.empty();
	container.append("<div class='col l12'><h5>标签管理：<a class='btn-floating right btn-large' href='#addTag'><i class='material-icons'>add</i></a></h5></div>");
	container.append("<div class='col l12' style='margin-top: 5px;'>"+
							"<nav class='deep-orange darken-2   z-depth-0 '>"+
							"<div class='nav-wrapper hoverable'>"+
							"<form id='searchByKey'>"+"<div class='input-field'>"+"<input id='search' type='search' required>"+
							"<label class='label-icon' for='search'><i class='material-icons'>search</i></label>"+
							"<i class='material-icons'>close</i>"+
							"</div></form></div></nav></div>");
	container.append("<div  id='progree' class='progress  hide'><div class='indeterminate'></div></div>");
	container.append("<div class='col l12'><ul id='list'  class='collapsible hide' data-collapsible='accordion'></ul></div>");
	container.append("<div id='addTag' class='modal'><div class='modal-content'><h4>添加标签</h4><p><div class='input-field'><i class='material-icons prefix'>label</i><input id='addTagName' type='text' class='validate'><label for='addTagName'>标签名</label></div><div class='input-field'><i class='material-icons prefix'>details</i><input id='addTagDetails' type='text' class='validate'><label for='addTagDetails'>标签说明</label></div></p></div><div class='modal-footer'><button id='addTagButton' class='modal-action waves-effect waves-green btn'>添加</button><a class=' modal-action modal-close waves-effect waves-green btn-flat'>取消</a></div></div>")
	container.append("<div id='updateTag' class='modal'><div class='modal-content'><h4>修改标签</h4><p><div class='input-field'><i class='material-icons prefix'>label</i><input id='updateTagName' type='text' class='validate'><label for='updateTagName'>标签名</label></div><div class='input-field'><i class='material-icons prefix'>details</i><input id='updateTagDetails' type='text' class='validate'><label for='addTagDetails'>标签说明</label></div></p></div><div class='modal-footer'><button id='updateTagButton' class='modal-action waves-effect waves-green btn'>修改</button><a class=' modal-action modal-close waves-effect waves-green btn-flat'>取消</a></div></div>")
	container.append("<div  id='slip'  class='col l12 center hide'></div>");
	initMaterial();
	initTag();
	$("#addTagButton").click(addTag);
	$("#searchByKey").submit(searchTag);
	$("#slip").on("click",function(){
 		var li=getEventTarget(event);
 		if(li.tagName=="I"||li.tagName=="A"){
 			var url=li.parentElement.parentElement.getAttribute("data-url");
 			var index=li.getAttribute("data-url");
 			$.get({
 			url:url+index,
 			success:function(data){
 				$("#progree").removeClass("hide");
 				listTag(data);
 				slipPage(url,data);
 			}
 		});
 		}
 	});
}

function classify(){
	var tabString="<li class='tab'><a href='#big'>大分类</a></li><li class='tab'><a href='#small'>小分类</a></li>";
	initTabs(tabString);
	switchBig();
	$(".tab").click(()=>{
			var a=getEventTarget(event);
			var msg=a.getAttribute("href");
			if(msg=="#small"){
				switchSmall();
			}else if(msg=="#big"){
				switchBig();
			}
	});
}

function words(){
	var tabString="<li class='tab'><a href='#test1'>words列表</a></li>";
	initTabs(tabString);
	var container=$(".container .row");
	container.empty();
	container.append("<div class='col l12'><h5>Words管理：</h5></div>");
	container.append("<div class='input-field col l10'><input placeholder='words内容'  id='wordsContent' type='text' class='validate'> <label for='first_name'>添加words</label></div>");
	container.append("<a id='addWordsButton' class='waves-effect waves-light btn col l2'><i class='material-icons left'>add</i>发布</a>");
	container.append("<div  id='progree' class='progress  hide'><div class='indeterminate'></div>");
	container.append("<div class='col l12'><ul id='list'  class='collection hide'></ul></div>");
	container.append("<div  id='slip'  class='col l12 center hide'></div>");
	initWords();
	initMaterial();
	$("#addWordsButton").click(addWords);
}

function info(){
	var tabString="<li class='tab'><a href='#test1'>我的信息</a></li>";
	initTabs(tabString);
	var container=$(".container .row");
	container.empty();
	container.append("<div class='col l10'><h5>我的信息：<a class='btn-floating right' href='#updatePassword'><i class='material-icons'>perm_identity</i></a></h5></div>");
	container.append("<div class='col l12'>	<div class='col l12'><div class='input-field col l8'><i class='material-icons prefix'>code</i><input id='userCode' type='text' autofocus placeholder='提示' class='validate'><label for='last_name'>用户码：</label></div> <div class='input-field col l8'><i class='material-icons prefix'>title</i> <input id='userName' type='text' autofocus placeholder='提示' class='validate'><label for='last_name'>用户名：</label></div> <div class='input-field col l8'>" +
			"<i class='material-icons prefix'>title</i><select id='userSex'  class='bigId icons'><option value='true'>男</option><option value='false'>女</option></select></div>" +
			"<div class='input-field col l8'><i class='material-icons prefix'>title</i><input id='userEmail' type='email' placeholder='提示'  class='validate'><label for='last_name'>Email</label></div><div class='col l8'><button id='updateInfoButton' class='btn input-field right'>确认修改</button></div></div></div>");
	container.append("<div id='updatePassword' class='modal col l5'><div class='modal-content'><h4>修改密码</h4><p><div class='input-field'><i class='material-icons prefix'>details</i><input id='oldPassword' type='password' class='validate'><label for='addTagDetails'>老密码</label></div><div class='input-field'><i class='material-icons prefix'>label</i><input id='newPassword' type='password' class='validate'><label for='updateTagName'>新密码</label></div><div class='input-field'><i class='material-icons prefix'>label</i><input id='newPasswordAgain' type='password' class='validate'><label for='updateTagName'>确认新密码</label></div></p></div><div class='modal-footer'><button id='updatePasswordButton' class='modal-action waves-effect waves-green btn'>修改</button><a class=' modal-action modal-close waves-effect waves-green btn-flat'>取消</a></div></div>");
	initInfo();
	initMaterial();
	$("#updatePasswordButton").click(updatePassword);
	$("#updateInfoButton").click(updateInfo);
}

function initTabs(tabStr){
	var tabs=$("ul.tabs");
	tabs.empty();
	tabs.append(tabStr);
	tabs.tabs();
}
