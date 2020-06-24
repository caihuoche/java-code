package com.example.demo.esay;

import org.junit.Test;

/**
 *给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * @author yanghaiyu
 * @date 2020/06/24 
 **/
public class Easy125 {
	public boolean isPalindrome(String s) {
		String replaceAll = s.replaceAll("[^a-zA-Z0-9]", "");
		String upperCase = replaceAll.toUpperCase();
		char[] chars = upperCase.toCharArray();
		for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
			if (chars[i] != chars[j]) {
				return
						false;
			}
		}
		return true;
	}

	@Test

	public void t1(){
		isPalindrome( "A man, a plan, a canal: Panama");
	}
}
