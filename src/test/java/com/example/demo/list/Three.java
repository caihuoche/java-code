package com.example.demo.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 3.给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 示例 1:
 *
 * 输入: "abcabcbbqwerrret" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Three {
	public int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		HashMap<Character, Integer> objects = new HashMap<>();
		int max = 0;
		int left = 0;
		for (int i = 0; i < chars.length; i++) {
			Integer orDefault = objects.getOrDefault(chars[i], -1);
			if (orDefault != -1) {
				left = orDefault + 1 > left ? orDefault + 1 : left;
			}
			max = (i + 1 - left) > max ? (i + 1 - left) : max;

			objects.put(chars[i], i);
		}


		return max;
	}

	@Test
	public void t1() {
		//"dvdf"
		int abcabcbb = lengthOfLongestSubstring("dvdf");
		System.out.println(abcabcbb);
	}
}