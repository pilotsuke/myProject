			//Ajax验证过后, 提交表单数据, 新建部门
function createdept(){
				event.preventDefault();
				$.ajax({
					type:"post",
					url:"create.do",
					data:$("#createdept").serialize(),
					success:function(msg){
						alert("创建成功");
						$("#createdept")[0].reset();
					}
				})
			}