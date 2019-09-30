package com.example.demo.nio;

import java.util.Arrays;

/**
 * 插入排序  拿出一个和前面的去比较 合适就插进去
 *
 * @author yanghaiyu
 * @date 2019/09/30
 **/
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {2, 4325, 4, 7, 23, 6, 124, 767, 242, 124, 124, 34, 645, 12, 11, 45, 5, 6};

		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
