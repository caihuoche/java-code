package com.example.demo.list;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/08/22
 **/
public class Seven {

	public int reverse(int x) {
		String s = x + "";
		char[] chars = s.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		int a = 0;
		if (x < 0) {
			stringBuilder = new StringBuilder("-");
			a = 1;
		}
		for (int i = chars.length - 1; i >= a; i--) {
			stringBuilder.append(chars[i]);
		}
		try {
			return Integer.parseInt(stringBuilder.toString());
		} catch (Exception e) {

			return 0;
		}
	}

	@Test
	public void t1() {
		int reverse = reverse(-0);
		System.out.println(reverse);
	}
}
