package com.example.demo.nio;

import java.util.Arrays;

/**
 * 选择排序  每次选择最小的一个放在前面.
 *
 * @author yanghaiyu
 * @date 2019/09/30
 **/
public class ChooseSort {

	public static void main(String[] args) {
		int[] arr = {2, 4325, 4, 7, 23, 6, 124, 767, 242, 124, 124, 34, 645, 12, 11, 45, 5, 6};

		for (int i = 0; i < arr.length; i++) {
			int index = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;

		}
		System.out.println(Arrays.toString(arr));
	}
}
