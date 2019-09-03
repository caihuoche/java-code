package com.example.demo.list;

import java.util.HashMap;

import org.junit.Test;

/**
 * 字符          数值 I             1 V             5 X             10 L             50 C             100 D             500
 * M             1000
 *
 * @author yanghaiyu
 * @date 2019/09/03
 **/
public class Twelve {

	@Test
	public void t1() {
		String s = intToRoman2(9);
		System.out.println(s);
	}

	/**
	 * 性能较差
	 */
	public String intToRoman(int num) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
		int y;
		StringBuilder sb = new StringBuilder();
		for (int i = 1, j = 5; num / 10 >= 0 && num != 0; i *= 10, j *= 10) {
			y = num % 10;
			num /= 10;
			if (y > 0 && y < 4) {
				for (int k = 0; k < y; k++) {
					sb.insert(0, map.get(i));
				}
			} else if (y == 4) {
				sb.insert(0, map.get(j));
				sb.insert(0, map.get(i));
			} else if (y == 5) {
				sb.insert(0, map.get(j));
			} else if (y == 9) {
				sb.insert(0, map.get(i * 10));
				sb.insert(0, map.get(i));
			} else if (y > 5 && y < 9) {
				for (int k = 6; k < y; k++) {
					sb.insert(0, map.get(i));
				}
				sb.insert(0, map.get(i));
				sb.insert(0, map.get(j));

			}
		}
		return sb.toString();
	}


	public String intToRoman2(int num) {
		int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] arr2 = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			while (num >= arr[i]) {
				sb.append(arr2[i]);
				num -= arr[i];
			}
		}
		return sb.toString();
	}
}
