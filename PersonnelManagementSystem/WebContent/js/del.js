//			删除部门数据
			function del(){
				var btn=event.srcElement;
//				得到部门编号的标签
				var cell=btn.parentElement.parentElement.firstChild;
				console.log(cell.innerText);
				$.ajax({
					type:"post",
					url:"delDept.do",
//					将部门编号的值发送出去, 作为查询条件
					data:"deptno="+cell.innerText,
					success:function(msg){
						if(msg=="1"){
							alert("删除成功");
							queryAll();
						}else{
							alert("删除失败");
						}
					}
				})
			}