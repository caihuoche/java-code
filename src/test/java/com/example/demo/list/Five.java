package com.example.demo.list;

import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 *
 * 输入: "cbbd" 输出: "bb"
 *
 * @date 2019/08/22
 **/
public class Five {
	public String longestPalindrome(String s) {

		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		String result = "";
		for (int i = 0; i < chars.length; i++) {
			int j = 1;
			sb.append(chars[i]);
			while (i - j >= 0 && i + j < chars.length && chars[i - j] == chars[i + j]) {
				sb.insert(0, chars[i - j])
						.append(chars[i + j]);
				j++;

			}
			if (sb.toString().length() > result.length()) {
				result = sb.toString();
			}
			sb.delete(0, sb.length());

			j = 0;
			while (i - j >= 0 && i + j + 1 < chars.length && chars[i - j] == chars[i + 1 + j]) {
				sb.insert(0, chars[i - j])
						.append(chars[i + 1 + j]);
				j++;

			}
			if (sb.toString().length() > result.length()) {
				result = sb.toString();
			}

			sb.delete(0, sb.length());
		}
		return result;
	}

	@Test
	public void t1() {
		String s = "abcddcba";
		String s1 = longestPalindrome(s);
		System.out.println(s1);
	}
}
