package runnable;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t1=new Thread1();
		Thread t11=new Thread(t1);
		
		Thread2 t2=new Thread2();
		Thread t22=new Thread(t2);
		
		t11.start();
		t22.start();
		
		
		for(int i=0;i<100;i++){
			System.out.println(i+"³Ô·¹");
		}
	}

}
