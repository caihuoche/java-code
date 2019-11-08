package com.example.demo.list;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/11/07
 **/
public class TwentyNine {

	public int divide(int dividend, int divisor) {
		if (dividend == 0) return 0;
		int dividendabs = Math.abs(dividend);
		int divisorabs = Math.abs(divisor);
//		if (dividendabs ==Integer.MAX_VALUE || )
		int tmep = divisorabs;
		int result = 0;
		while (tmep <= dividendabs) {
			tmep = tmep + divisorabs;
			result++;
		}

		if (dividend > 0) {
			if (divisor > 0)
				return result;
			return -result;

		} else {
			if (divisor < 0)
				return result;

			return -result;
		}

	}

	@Test
	public void t1() {
		int divide = divide(-2147483648, -1);

		System.out.println(divide);
	}

}
