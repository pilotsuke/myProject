package fuxiceshi;

public class Batman {
	int squares=81;
	void go(){
		incr(++squares);
		System.out.println(squares);
	}
	void incr(int squares){
		squares+=10;
	}
}
