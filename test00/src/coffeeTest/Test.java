package coffeeTest;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cup cup = new Cup();
		Waiter w = new Waiter(cup);
		Thread t1 = new Thread(w);
		
		Customer c = new Customer(cup);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		Thread t4 = new Thread(c);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
