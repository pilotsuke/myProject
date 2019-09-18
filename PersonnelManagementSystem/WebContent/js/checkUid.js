function checkUid(){
			var uid=$("#uid").val();
			console.log(uid);
			$.ajax({
				type:"post",
				url:"accountUidAjax.do",
				data:"uid="+uid,
				success:function(msg){
					if(msg=="success"){
						$("#tipuid").text("✔");
					}else{
						$("#tipuid").text("该用户未注册");
					}
				}
			})
		}