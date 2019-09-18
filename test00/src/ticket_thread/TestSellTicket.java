package ticket_thread;

public class TestSellTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SellTicket s1 = new SellTicket();
		s1.start();
		SellTicket s2 = new SellTicket();
		s2.start();
		SellTicket s3 = new SellTicket();
		s3.start();
	}

}
