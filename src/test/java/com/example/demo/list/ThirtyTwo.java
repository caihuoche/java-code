package com.example.demo.list;

import org.junit.Test;

/**
 *
 * @author yanghaiyu
 * @date 2020/03/23 
 **/
public class ThirtyTwo {

	@Test
	public void t1() {
		String a = "()(())";
		int i = longestValidParentheses(a);
		System.out.printf(i + "");


	}

	public int longestValidParentheses(String s) {
		if (s == null || s.trim().equals("")) {
			return 0;
		}
		int max = 0;
		int num = 0;
		char[] chars = s.toCharArray();
		for (int i = 1; i < chars.length; i++) {
			if (chars[i - 1] == 40 && chars[i] == 41) {
				i++;
				num += 2;
			} else {
				max = num > max ? num : max;
				num = 0;
			}

		}
		return  num > max ? num : max;
	}
}
