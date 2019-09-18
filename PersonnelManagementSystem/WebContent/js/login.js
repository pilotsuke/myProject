function login(){
	event.preventDefault();
	var uid=$("#uid").val();
	var pwd=$("#pwd").val();
	$.ajax({
		type:"post",
		url:"login",
		data:"uid="+uid+"&pwd="+pwd,
		success:function(msg){
			if(msg=="failure"){
				alert("密码错误");
			}else{
				alert("登录成功");
				if(uid=="admin"){
//					location.href="deptManagement.html?uid="+uid+"&qx=1";
					$("#weluid").text(uid);
					$("#welqx").text("管理员");
				}else{
//					location.href="deptManagement.html?uid="+uid+"&qx=0";
					$("#weluid").text(uid);
					$("#welqx").text("普通用户");
				}
				$("#login").css("display","none");
				$("#welcome").css("display","block");
				$("#con").css("display","block");	
			}
		}
	})
}