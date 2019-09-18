package thread;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t1=new Thread1();
		Thread2 t2=new Thread2();
//		Æô¶¯Ïß³Ì
		t1.start();
		t2.start();
		
		
		for(int i=0;i<100;i++){
			System.out.println(i+"³Ô·¹");
		}
	}

}
