//组合条件搜索部门数据
function search(){
	var sdeptno=$("#searchdeptno").val();
	var sdeptname=$("#searchdeptname").val();
	var sdepttype=$("#searchdepttype").val();
	
	console.log(sdeptno);
	console.log(sdeptname);
	console.log(sdepttype);
	
	$.ajax({
		type:"post",
		url:"search.do",
		data:"sdeptno="+sdeptno+"&sdeptname="+sdeptname+"&sdepttype="+sdepttype,
		dataType:"json",
		success:function(msg){
			if(msg=="failure"){
				alert("没有符合条件的数据");
			}else{
				$("#queryTable").html("");
				$("#queryAllResult").append("<table id='queryTable'></table>");
				$("#queryTable").append("<tr><th>部门编号</th><th>部门名称</th><th>部门类型</th><th>部门电话</th><th>部门传真</th><th>部门描述</th><th>上级部门</th><th>部门建立时间</th><th>状态</th><th>状态</th></tr>")
				for(var i=0;i<msg.length;i++){
					console.log("部门编号是:"+msg[i].deptno);
					$("#queryTable").append("<tr><td>"+msg[i].deptno+"</td>"+"<td>"+msg[i].deptname+"</td>"+"<td>"+msg[i].depttype+"</td>"
							+"<td>"+msg[i].depttel+"</td>"+"<td>"+msg[i].deptfax+"</td>"+"<td>"+msg[i].deptdesc+"</td>"
							+"<td>"+msg[i].superiordept+"'</td>"+"<td><input type='date' value='"+msg[i].establish+"'/></td>"
							+"<td><input type='button'  id='edit' onclick='edit()' value='点击修改' /></td>"
							+"<td><input type='button'  id='del' onclick='del()' value='点击删除' /></td></tr>");
				}
				$("#exportData").attr("disabled",false);
			}
		}
	})

}