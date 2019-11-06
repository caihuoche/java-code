package com.example.demo.list;

import org.junit.Test;

/**
 * 输入: haystack = "hello", needle = "ll" 输出: 2
 *
 * @author yanghaiyu
 * @date 2019/11/06
 **/
public class TwentyEight {
	public int strStr(String haystack, String needle) {
		if (needle == null || "".equals(needle)) {
			return 0;
		}
		if (haystack == null || "".equals(haystack)) {
			return -1;
		}
		char[] chars = haystack.toCharArray();
		char[] chars2 = needle.toCharArray();
		int length = chars.length;
		int length2 = chars2.length;
		for (int i = 0; i < length; i++) {
			if (chars[i] == chars2[0]) {
				if (length2 == 1) {
					return i;
				}
				int a = i + 1;
				for (int j = 1; j < length2; j++, a++) {
					if (a == length) {
						return -1;
					}
					if (chars[a] != chars2[j]) {
						break;
					}
					if (j == length2 - 1) {
						return i;
					}
				}
			}
		}
		return -1;
	}

	@Test
	public void t1() {
		String a = "a";
		String b = "a";
		int i = strStr(a, b);
		System.out.println(i);
	}
}
