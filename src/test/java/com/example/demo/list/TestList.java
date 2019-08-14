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

	@Test
	public void t2() {
		int[] arr = {5, 4,10, 16, 11, 21, 30, 40};
		int ac = 10;
		int result = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < ac && (result < arr[i] || result == -1)) {
				result = arr[i];
			}
		}
		System.out.println(result);
	}
	@Test
	public void t3() {
		int[] arr = {5, 10, 16, 11, 21, 30, 40};
		int ac = 10;

	}
}
