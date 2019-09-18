package runnable;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println(i+"³Ô·¹");
		}
	}

}
