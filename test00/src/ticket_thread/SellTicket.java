package ticket_thread;

public class SellTicket extends Thread {
	private int num = 500;
	
	@Override
	public void run() {
		while(num>0){
			sellTicket();
		}
	}
	public void sellTicket(){
		if(num>0){
			System.out.println("ÊÛ³öÆ±"+num);
			num--;
		}
	}
	
}
