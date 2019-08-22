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

	public int reverse2(int x) {
		int reverse = 0;

		return abc(x, reverse);
	}

	private int abc(int x, int reverse) {
		if (x / 10 != 0) {
			reverse = reverse + (x % 10);
			if (reverse > Integer.MAX_VALUE/10 || reverse < Integer.MIN_VALUE/10) {
				return 0;
			}
			reverse = reverse * 10;

		} else {
			reverse = reverse + (x % 10);
			if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
				return 0;
			}
			return reverse;
		}
		return abc(x / 10, reverse);
	}

	@Test
	public void t1() {
		int reverse = reverse2(1563847412);
//int 		reverse = (214748365 ) * 10;
//		int a = Integer.MAX_VALUE/ 10;
//		int b = Integer.MIN_VALUE/ 10;
		System.out.println(reverse);
	}
}
