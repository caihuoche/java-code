package com.example.demo.list;

import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 *
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
 *
 * @author caihuoche
 * @date 2019/09/03
 **/
public class Fourteen {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length < 1) return "";
		if (strs.length < 2) return strs[0];
		StringBuilder sb = new StringBuilder();
		String a = strs[0];
		String b = strs[1];
		int aLength = a.length();
		int bLength = b.length();
		int length = aLength > bLength ? bLength : aLength;
		for (int j = 0; j < length; j++) {
			if (b.charAt(j) != a.charAt(j)) break;
			sb.append(b.charAt(j));
		}
		if (sb.length() < 1) return "";
		for (int i = 2; i < strs.length; i++) {
			String b2 = strs[i];
			if (sb.length() > b2.length()) {
				sb.delete(b2.length(), sb.length());

			}
			int i1 = sb.length() > b2.length() ? b2.length() : sb.length();
			for (int j = 0; j < i1; j++) {
				if (b2.charAt(j) != sb.charAt(j)) {
					sb.delete(j, sb.length());
					break;
				}
			}

		}
		return sb.toString();
	}

	@Test
	public void t1() {
		String[] arr = {"abab", "aba", ""};
		String s = longestCommonPrefix2(arr);
		System.out.println(s);
	}

	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) return "";
			}
		return prefix;
	}

}
