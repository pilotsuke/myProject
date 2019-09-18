function fun(){
	var uid = location.href.slice(location.href.indexOf("=")+1,location.href.indexOf("&"));
	$("#uid").text(uid);
	
	var qx = location.href.substr(location.href.indexOf("qx=")+1);
	if(location.href.substr(location.href.length-1)=="1"){
		$("#qx").text("管理员");
	}else{
		$("#qx").text("普通用户");
	}
	
	
}