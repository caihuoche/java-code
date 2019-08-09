package com.example.demo.list;

import java.util.LinkedList;

import org.junit.Test;


/**
 * 阻塞
 */
public class TestList {

	/**
	 * 倒排linkedList
	 */
	@Test
	public void t1() {
		System.out.println(1 >> 1);

		LinkedList<Integer> objects = new LinkedList<>();
		objects.add(1);
		objects.add(2);
		objects.add(3);
		objects.add(4);
		objects.add(5);
		System.out.println(objects);
		for (int i = objects.size() - 1; i >= 0; i--) {
			objects.add(objects.remove(i));
		}
		System.out.println(objects);
	}
}
