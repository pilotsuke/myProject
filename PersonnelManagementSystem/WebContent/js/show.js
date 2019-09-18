function show(count){
				var con=document.getElementById('con');
//				得到外层DIV的所有子节点
				var subarr=con.childNodes;
				
				var darr=new Array();
				var idx=0;
//				遍历#con的子节点集合
				for(s of subarr){
//					将其中的DIV节点放在新的集合中
					if(s.nodeName=='DIV'){
						darr[idx++]=s;
					}
				}
				
				var uls=document.getElementsByTagName('ul');
//				得到列表节点 li
				var larr=uls[0].childNodes;
				var narr=new Array();
				idx=0;
				for(l of larr){
//					将列表节点放到新的集合中
					if(l.nodeName=="LI"){
						narr[idx++]=l;
					}
				}
				
				darr[count].setAttribute('class','show');
				for(i in darr){
					if(i!=count){
						if(darr[i].hasAttribute('class')){
							darr[i].removeAttribute('class');
						}
					}
				}
			}