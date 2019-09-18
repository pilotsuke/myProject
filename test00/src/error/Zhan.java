package error;

public class Zhan {
	int [] arr=new int[3];
	public static void main(String [] args){
		new Zhan().methodOne();
		System.out.println("main");
	}
	public void methodOne(){
		methodTwo();
		System.out.println("One");
	}
	public void methodTwo(){
		methodThree();
		System.out.println("Two");
	}
	public void methodThree(){
		System.out.println(arr[2]);
		System.out.println("Three");
	}
}
