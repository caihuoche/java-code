package com.example.demo.list;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/09/03
 **/
public class Thirteen {

	public int romanToInt(String s) {
		int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] arr2 = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder sb = new StringBuilder(s);
		int j = 0;
		int num = 0;
		for (int i = 0; i < arr2.length; i++) {
			while (j < sb.length()  && arr2[i].equals(sb.substring(j, j + 1))) {
				num += arr[i];
				j++;
			}
			while (j < sb.length() - 1&& arr2[i].equals(sb.substring(j, j + 2))) {
				num += arr[i];
				j += 2;
			}
		}
		return num;
	}

	@Test
	public void t1() {
		int i = romanToInt("MCMXCIV");
		System.out.println(i);
	}
}
