package basic.util_concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock_test {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new RunIt3());
		Thread t2 = new Thread(new RunIt3());
		t1.start();
		t2.start();
		t2.interrupt();
	}

}

class RunIt3 implements Runnable {
	private static Lock lock = new ReentrantLock(); 
	
	@Override
	public void run() {
		try {
			lock.lock();
			//lock.lockInterruptibly();
			System.out.println(Thread.currentThread().getName() + " running");
			TimeUnit.SECONDS.sleep(3);
			lock.unlock();
			System.out.println(Thread.currentThread().getName() + " finished");
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted"); 
		}
	}
	
}
