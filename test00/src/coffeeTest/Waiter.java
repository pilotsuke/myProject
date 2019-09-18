package coffeeTest;

public class Waiter implements Runnable {
	Cup cup = null;
	
	public Waiter(Cup cup){
		this.cup = cup;
	}

	public void run() {
		while(true){
//			wait和notify的操作必须放在同步语句块中执行
			synchronized(cup){
				while(!cup.isEmpty){
					try {
//						释放当前对象的锁, 进入阻塞状态, 等待其他线程调用当前对象的notify方法来唤醒线程
						cup.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("服务员倒咖啡");
				cup.isEmpty = false;
//				释放当前对象的锁, 同事唤醒其他等待当前对象的所有线程
				cup.notifyAll();
			}
		}
	}

}
