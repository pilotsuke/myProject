			//使用Ajax检查部门编号是否已经被使用
			function check(){
				event.preventDefault();
				var onblur=event.srcElement;
				var xhr=new XMLHttpRequest();
				var fd=new FormData();
				fd.append("onblurName",onblur.name);
				fd.append("onblurValue",onblur.value);
				xhr.open("post","check.do",true);
				xhr.send(fd);
				xhr.onreadystatechange=function(){
					var data=xhr.responseText;
					
					if(xhr.readyState==4&&xhr.status==200){
						if(onblur.name=="deptno"){
							var result=document.getElementById("tipdeptno");
							result.innerText=data;
						}
						else if(onblur.name=="deptname"){
							var result=document.getElementById("tipdeptname");
							result.innerText=data;
						}
						else if(onblur.name=="depttel"){
							var result=document.getElementById("tipdepttel");
							result.innerText=data;
						}
						else if(onblur.name=="deptfax"){
							var result=document.getElementById("tipdeptfax");
							result.innerText=data;
						}
					}
				}
			}