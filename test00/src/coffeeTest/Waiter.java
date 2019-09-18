package coffeeTest;

public class Waiter implements Runnable {
	Cup cup = null;
	
	public Waiter(Cup cup){
		this.cup = cup;
	}

	public void run() {
		while(true){
//			wait��notify�Ĳ����������ͬ��������ִ��
			synchronized(cup){
				while(!cup.isEmpty){
					try {
//						�ͷŵ�ǰ�������, ��������״̬, �ȴ������̵߳��õ�ǰ�����notify�����������߳�
						cup.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("����Ա������");
				cup.isEmpty = false;
//				�ͷŵ�ǰ�������, ͬ�»��������ȴ���ǰ����������߳�
				cup.notifyAll();
			}
		}
	}

}
