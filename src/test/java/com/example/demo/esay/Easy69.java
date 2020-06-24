package com.example.demo.esay;

import org.junit.Test;

/**实现 int sqrt(int x) 函数。

 计算并返回 x 的平方根，其中 x 是非负整数。

 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 示例 1:

 输入: 4
 输出: 2
 示例 2:

 输入: 8
 输出: 2
 说明: 8 的平方根是 2.82842...,
      由于返回类型是整数，小数部分将被舍去。
 *
 * @author yanghaiyu
 * @date 2020/06/19 
 **/
public class Easy69 {
	/**
	 * 为了溢出 不用乘法用除法. 依旧是逆向思维
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
		if (x == 0) return 0;
		if (x == 1) return 1;
		int left = 0, right = x;
		int mid =0;
		while (left <= right) {
			mid = (left + right) / 2;

			if (x/mid ==mid) {
				return mid;
			}
			if (x/mid  < mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (x/mid  < mid) {
			return mid - 1;
		}
		return mid;
	}

	@Test
	public void t1(){
		int i = mySqrt(8);
		System.out.printf(""+i);
	}
}
