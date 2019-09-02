package com.example.demo.list;

import org.junit.Test;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R E T O E S I I G E   D   H   N 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows); 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRETOESIIGEDHN" 示例 2:
 *												  LCIRETOESIIGEDHN
 * 输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG" 解释:
 *
 * L     D     R E   O E   I I E C   I H   N T     S     G
 *
 * @author yanghaiyu
 * @date 2019/09/02
 **/
public class Six {

	@Test
	public void t1() {
		String s = "LEETCODEISHIRING";
		int num = 3;
		String convert = convert(s, num);
		System.out.println(convert);
	}

	/**
	 * 做完了一致提示内存超出 时间超出,  原来是 要加这个 		if (numRows == 1) return s;
	 *
	 * 题解1的思想真的是太棒了
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;
		char[] arr = s.toCharArray();
		int inter = numRows + numRows - 2;
		StringBuilder sb = new StringBuilder();
		int length = arr.length;
		for (int i = 0; i < numRows; i++) {
			int x = 0;
			int a = i;
			while (a < length) {
				sb.append(arr[a]);
				a = (i + (x + 1) * inter) - (2 * i);
				x++;
				if (i != 0 && i != numRows - 1 && a < length) {
					sb.append(arr[a]);
				}
				a = i + x * inter;
			}
		}
		return sb.toString();
	}
}
