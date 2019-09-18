package coffeeTest;

public class Customer implements Runnable {
	Cup cup = null;
	
	public Customer(Cup cup){
		this.cup = cup;
	}
	@Override
	public void run() {
		while(true){
			synchronized(cup){
				while(cup.isEmpty){
					try {
						cup.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"ºÈ¿§·È");
				cup.isEmpty = true;
				cup.notifyAll();
			}
		}
	}

}
