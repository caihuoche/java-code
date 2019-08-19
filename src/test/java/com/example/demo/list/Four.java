package com.example.demo.list;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/08/16
 **/
public class Four {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int mid = (nums1.length + nums2.length) / 2;
		boolean flag = (nums1.length + nums2.length) % 2 == 1 ? true : false;
		for (int i = 0; i < mid; i++) {
			if (nums2[mid - i - 2] < nums1[i + 1] && nums1[i] < nums2[mid - i - 1]) {
				return i;
			}
		}
		System.out.println(i);
		return 0;
	}

	public int binarySearch(int min, int max, int[] arr, int mid) {
		int midIndex = (max + min) / 2;
		if (arr[midIndex] > mid) {
			if (midIndex == max) {
				return max;
			}
			return binarySearch(min, midIndex, arr, mid);
		} else if (arr[midIndex] < mid) {
			if (midIndex == min) {
				return min;
			}
			return binarySearch(midIndex, max, arr, mid);
		} else {
			return midIndex;
		}
	}


	@Test
	public void t1() {
		int[] arr = {4, 10, 12, 24, 56};
		int[] arr2 = {16, 17, 18, 24, 38};
		double medianSortedArrays = findMedianSortedArrays(arr, arr2);
		System.out.println(medianSortedArrays);
		//int medianSortedArrays = binarySearch(0, arr2.length, arr2, 13);
		//System.out.println(medianSortedArrays);
	}
}
