package com.example.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yanghaiyu
 * @date 2019/11/26
 **/
public class ProdQuene {

	ArrayBlockingQueue queue = new ArrayBlockingQueue(1);

	public static void main(String[] args) {
		ProdQuene prodQuene = new ProdQuene();
		new Thread(() -> {
			try {
				for (int i =0;i<10;i++){

					prodQuene.pord();
				}
			} catch (InterruptedException e) {
			}
		}).start();
		try {
			for (int i =0;i<10;i++){

				prodQuene.coume();
			}
		} catch (InterruptedException e) {
		}
		new Thread(() -> {
		}).start();
	}

	private void pord() throws InterruptedException {
		while (queue.offer("2", 2, TimeUnit.SECONDS)) {
			System.out.println("生产了\t");

		}

	}

	private void coume() throws InterruptedException {
		Object take = queue.take();
		System.out.println("消费者\t" + take);
	}
}
