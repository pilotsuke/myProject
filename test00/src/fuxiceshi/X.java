package fuxiceshi;

public class X {
	X(){
		System.out.println(1);
	}
	X(int x){
		this();
		System.out.println(2);
	}
}
