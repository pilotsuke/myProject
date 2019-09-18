//			修改部门数据
			function edit(){
				//得到目标元素, 也就是按钮
				var btn=event.srcElement;
				//获取父元素-->td
				var cell=btn.parentElement;
				//获得td的上一个兄弟元素td
				var brother=cell.previousElementSibling;
				if(btn.value=="点击修改"){
//					将tr中所有的子标签都遍历一遍, 并且设置为可编辑
					while(brother!=null){
						brother.contentEditable=true;
						brother=brother.previousElementSibling;
					}
					btn.value="完成";
				}else{
//					声明一个空字符串, 用于向servlet传数据
					var elist="";
					while(brother!=null){
//						判断td标签中是否含有<input type='date'.../> 
//						$(brother).html()得到的是字符串, 用字符串的indexof方法查找'date'
//						如果没有得到'date'子字符, 就执行以下语句
						if($(brother).html().indexOf("date")<0){
//							将得到的td数据添加到字符串中, 用分号间隔
							elist = elist+$(brother).text()+";";
							brother.contentEditable=false;
							brother=brother.previousElementSibling;
						}
//						如果得到'date'子字符, 就执行以下语句
						else{
//							$(brother).children()[0].value 得到含有input子标签的td标签, 得到td标签的所有子标签, 取第一个子标签的值
							elist = elist+$(brother).children()[0].value+";";
							brother.contentEditable=false;
							brother=brother.previousElementSibling;
						}
					}
					btn.value="点击修改";
//					更改button的value后, 向servlet传送数据
					console.log(elist);
					$.ajax({
						type:"post",
						url:"editDept.do",
//						要发送的数据
						data:"da="+elist,
						success:function(msg){
							alert("修改成功");
						}
					})
					
				}
			}