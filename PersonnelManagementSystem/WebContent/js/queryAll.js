			//显示所有部门数据信息
			function queryAll(){
				event.preventDefault();
//				将显示部门信息的DIV清空
				$("#queryTable").html("");
//				在调用该方法的时候, 才在DIV中添加table标签
				$("#queryAllResult").append("<table id='queryTable'></table>");
				$("#queryTable").append("<tr><th>部门编号</th><th>部门名称</th><th>部门类型</th><th>部门电话</th><th>部门传真</th><th>部门描述</th><th>上级部门</th><th>部门建立时间</th><th>状态</th><th>状态</th></tr>")
				$.ajax({
					type:"post",
					url:"queryAll.do",
//					设置从servlet传过来的数据的格式
					dataType:"json",
					success:function(msg){
						for(var i=0;i<msg.length;i++){
//							按照索引取得每一条数据, 在通过key值得到相应数据
							$("#queryTable").append("<tr><td>"+msg[i].deptno+"</td>"+"<td>"+msg[i].deptname+"</td>"+"<td>"+msg[i].depttype+"</td>"
									+"<td>"+msg[i].depttel+"</td>"+"<td>"+msg[i].deptfax+"</td>"+"<td>"+msg[i].deptdesc+"</td>"
									+"<td>"+msg[i].superiordept+"</td>"+"<td><input type='date' value='"+msg[i].establish+"'/></td>"
									+"<td><input type='button'  id='edit' onclick='edit()' value='点击修改' /></td>"
									+"<td><input type='button'  id='del' onclick='del()' value='点击删除' /></td></tr>");
						}
//						改属性值, 或者移除属性
						$("#exportData").removeAttr("disabled");
//						$("#exportData").attr("disabled",false);
					}	
				})  
			}