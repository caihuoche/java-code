package com.example.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**  生产者消费者
 * @author yanghaiyu
 * @date 2019/11/26
 **/
public class ProdCoumer {

	private volatile int num = 0;
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();


	public void prod() {
		try{
			lock.lock();
			while (num!=0){
				condition.await();
			}
			num++;
			System.out.println("生产了\t\t"+num);
			condition.signalAll();

		} catch (InterruptedException e) {
		} finally {
			lock.unlock();
		}
	}

	public void coume() {
			try{
				lock.lock();
				while (num==0){
					condition.await();
				}
				num--;
				System.out.println("消费了\t"+num);
				condition.signalAll();

			} catch (InterruptedException e) {
			} finally {
				lock.unlock();
			}

	}

	public static void main(String[] args) {
		ProdCoumer prodCoumer = new ProdCoumer();
		new Thread(()->{
			for (int i =0;i<10;i++){

				prodCoumer.prod();
			}
		}).start();
		new Thread(()->{
			for (int i =0;i<10;i++){
				prodCoumer.coume();
			}
		}).start();
	}
}
