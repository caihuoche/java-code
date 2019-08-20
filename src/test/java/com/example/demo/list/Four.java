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
		int[] big = nums1.length > nums2.length ? nums1 : nums2;
		int[] small = nums1.length > nums2.length ? nums2 : nums1;
		int left1 = 0;
		for (int i = 0; i < mid; i++) {
			if (small[mid - i - 2] < big[i + 1] && big[i] < small[mid - i - 1]) {
				left1 = i;
				break;
			}
		}

		if (flag) {
			return big[left1];
		} else {
			int left2 = (mid - 2 - left1);
			int left = big[left1] > small[left2] ? big[left1] : small[left2];
			int right = big[left1 + 1] > small[left2 + 1] ? small[left2 + 1] : big[left1 + 1];
			return (double) (left + right) / 2;
		}


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
		int[] arr = {1,2};
		int[] arr2 = {3,4};
		double medianSortedArrays = findMedianSortedArrays(arr, arr2);
		System.out.println(medianSortedArrays);
		//int medianSortedArrays = binarySearch(0, arr2.length, arr2, 13);
		//System.out.println(medianSortedArrays);
	}
}
