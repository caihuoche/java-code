package com.example.demo.nio;

import java.util.Arrays;

/**
 * 快速排序 从第一个数开始 然后把比他大的放他右边, 比他小的放他左边.  分治思想 同时操作俩边
 *
 * @author yanghaiyu
 * @date 2019/09/30
 **/
public class QuickSort {

	public static void main(String[] args) {
//		int[] arr = {20, 4325, 4, 7, 23, 6, 124, 767, 242, 124, 124, 34, 645, 12, 11, 45, 5, 6};
		int[] arr = {18, 20, 4, 7, 23, 6, 7};

		int left = 0;
		int right = arr.length - 1;

		sort(left, right, arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int left, int right, int[] arr) {
		int r = right;
		int l = left;
		int temp;
		int num = arr[left];
		int index = left;
		if (left >= right) {
			return;
		}
		while (left < right) {
			while (num < arr[right] && left < right) {
				right--;
			}
			if (num > arr[right]) {
				temp = arr[right];
				arr[right] = num;
				arr[index] = temp;
				index = right;
			}
			right--;
			while (num > arr[left] && left < right) {
				left++;
			}
			if (num < arr[left]) {
				temp = arr[left];
				arr[left] = num;
				arr[index] = temp;
				index = left;
			}
			left++;
		}
		sort(l, index - 1, arr);
		sort(index + 1, r, arr);

	}


}
