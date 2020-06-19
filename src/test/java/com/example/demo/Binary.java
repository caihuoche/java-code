package com.example.demo;

import org.junit.Test;

/**
 *
 * @author yanghaiyu
 * @date 2020/06/19 
 **/
public class Binary {

	public int search(int[] arr, int target) {

		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] > target) {
				right=mid-1;
			} else {
				left=mid+1;
			}
		}
		return 0;
	}

	@Test
	public void t1(){
		int[] arr = {1,4,6,8,10};
		int tar= 8;
		int search = search(arr, tar);
		System.out.printf(search+"");
	}
}
