package com.example.demo.nio;

import java.util.Arrays;

/**
 * 冒泡排序 相邻俩相比,大的往后挪
 *
 * @author yanghaiyu
 * @date 2019/09/30
 **/
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {2, 4325, 4, 7, 23, 6, 124, 767, 242, 124, 124, 34, 645, 12, 11, 45, 5, 6};
		int temp;
		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i + 1] < arr[i]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
