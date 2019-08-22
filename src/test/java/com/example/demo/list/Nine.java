package com.example.demo.list;

import org.junit.Test;

/**
 * 判断是否是回文数
 *
 * @author yanghaiyu
 * @date 2019/08/22
 **/
public class Nine {
	public boolean isPalindrome(int x) {

		int reverse = 0;
		int temp = x;
		while (temp / 10 > 0) {
			reverse = (reverse + (temp % 10)) * 10;
			temp = temp / 10;
		}
		reverse = reverse + (temp % 10);
		return reverse == x;
	}

	@Test
	public void t1() {
		System.out.println(isPalindrome(-122221));
	}
}
