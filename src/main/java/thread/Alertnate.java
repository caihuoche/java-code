package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanghaiyu
 * @date 2019/09/21
 **/
public class Alertnate implements Runnable {

	private volatile int num = 1;

	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();

	@Override
	public void run() {

		try {

			lock.lock();
			while (num < 100) {
				System.out.println(Thread.currentThread().getName() + "  " + num++);
				condition.signalAll();
				condition.await();
			}
			condition.signalAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		Alertnate alertnate = new Alertnate();
		Thread thread = new Thread(alertnate);
		thread.setName("A");
		thread.start();
		Thread thread2 = new Thread(alertnate);
		thread2.setName("B");
		thread2.start();
		Thread thread3 = new Thread(alertnate);
		thread3.setName("C");
		thread3.start();
	}
}
