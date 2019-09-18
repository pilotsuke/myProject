function regist(){
	event.preventDefault();
	$.ajax({
		type:"post",
		url:"empEntry.do",
		data:$("#empEntry").serialize(),
		success:function(msg){
			if(msg=="1"){
				alert("插入成功");
			}else{
				alert("插入失败");
			}
		}
	})
}