package ticket_runnable;

public class TestSellTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SellTicket s1 = new SellTicket();
		Thread t1 = new Thread(s1);
		t1.start();
		SellTicket s2 = new SellTicket();
		Thread t2 = new Thread(s2);
		t2.start();
		SellTicket s3 = new SellTicket();
		Thread t3 = new Thread(s3);
		t3.start();
	}

}
