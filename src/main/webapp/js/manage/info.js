function updateInfo(){
	var userCode=$("#userCode").val();
	var userName=$("#userName").val();
	var userSex=$("#userSex").val();
	var userEmail=$("#userEmail").val();
	$.post({
		url:"user/updateBySelf",
		data:{"_method":"PUT","userName":userName,"userCode":userCode,"userSex":userSex,"userEmail":userEmail},
		success:function(data){
			Materialize.toast(data,2000,"rounded red lighten-2");
		}
	});
}

function updatePassword(){
	var oldPwd=$("#oldPassword").val();
	var newPwd=$("#newPassword").val();
	var newPwdAgain=$("#newPasswordAgain").val();
	if($.isEmptyObject(newPwd)){
		Materialize.toast("请填写新密码！！",2000,"rounded red lighten-2");
		return;
	}
	if(newPwd!=newPwdAgain){
		Materialize.toast("新密码不一致！！",2000,"rounded red lighten-2");
		return;
	}
	$.post({
		url:"user/updatePassword",
		data:{"_method":"PUT","oldPassword":oldPwd,"newPassword":newPwd},
		success:function(data){
			Materialize.toast(data,2000,"rounded teal");
		}
	});
}

function initInfo(){
	var userCode=$("#userCode");
	var userName=$("#userName");
	var userEmail=$("#userEmail");
	$.get({
		url:"user/myinfo",
		success:function(data){
			if(data==""){
				window.location.href="login.jsp"
			}else{
				userCode.val(data.userCode);
				userName.val(data.userName);
				$("#userSex").val(data.userSex+"");
				$("#userSex").material_select();
				userEmail.val(data.userEmail);
			}
		}
	});
}