package com.example.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
	ReentrantLock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();
	volatile boolean flag = true;
	volatile boolean flag2 = true;

	public Foo() {

	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		condition2.signal();
		flag = false;
	}

	public void second(Runnable printSecond) throws InterruptedException {
		condition2.await();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		condition3.signal();
		flag2 = false;

	}

	public void third(Runnable printThird) throws InterruptedException {
		condition3.await();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}

class Test {

}