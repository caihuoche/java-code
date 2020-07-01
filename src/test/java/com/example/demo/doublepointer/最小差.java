package com.example.demo.doublepointer;

import org.junit.Test;

/** TODO
 *给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * 示例：
 *
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 * 提示：
 *
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间[-2147483648, 2147483647]内
 * 通过次数3,363提交次数8,311
 *
 * @author yanghaiyu
 * @date 2020/07/01 
 **/
public class 最小差 {
	public int smallestDifference(int[] a, int[] b) {
		int cha = Math.abs(a[0] - b[0]);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				int abs = Math.abs(a[i] - b[j]);
				if (abs <0){
					continue;
				}
				cha = cha < abs ? cha : abs;
			}
		}
		return cha;
	}

	@Test
	public void t1() {
		//[-2147483648,1]
		//[2147483647,0]
		int[] b = {-2147483648,1};
		int[] a = {2147483647,0};
		int i = smallestDifference(a, b);
		System.out.println(i);
	}
}
