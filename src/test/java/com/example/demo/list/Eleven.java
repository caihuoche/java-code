package com.example.demo.list;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/09/03
 **/
public class Eleven {

	public int maxArea(int[] height) {
		int temp = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int area = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
				temp = area > temp ? area : temp;
			}
		}
		return temp;
	}

	public int maxArea2(int[] height) {
		int temp = 0;
		for (int i = 0, j = height.length - 1; i < j; ) {
			int area = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
			temp = area > temp ? area : temp;
			if (height[i] > height[j]) {
				j--;
			} else {
				i++;
			}
		}
		return temp;
	}

	@Test
	public void t1() {
		int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		//int i = maxArea(arr);
		int i2 = maxArea2(arr);
		System.out.println(i2);
	}
}
