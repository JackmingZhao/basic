package basic;

public class ThreadJoinTest {

	public static void main(String[] args) {
		final Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t1");
			}
		});
		
		final Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t2");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t3");
			}
		});
		
		t3.start();
		t1.start();
		t2.start();
	}
	
}
