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
		if (nums1.length == 0) {
			if (!flag) {
				return (double) (nums2[mid] + nums2[mid - 1]) / 2;

			}
			return nums2[mid];
		}
		if (nums2.length == 0) {
			if (!flag) {
				return (double) (nums1[mid] + nums1[mid - 1]) / 2;

			}
			return nums1[mid];
		}
		for (int i = mid - small.length - 1; i <= mid; i++) {
			if (mid - i - 1 >= small.length) {
				if (small[mid - (i + 1) - 1] < big[i + 1]) {
					left1 = i;

					break;
				}
			} else if (mid - (i + 1) - 1 == -1) {
				left1 = i;
				if (flag) {
					return small[mid - i - 1] < big[i + 1] ? small[mid - i - 1] : big[i + 1];
				}
				break;
			} else {
				if (small[mid - (i + 1) - 1] <= big[i + 1] && big[i] <= small[mid - i - 1]) {
					left1 = i;
					if (flag) {
						return small[mid - i - 1] < big[i + 1] ? small[mid - i - 1] : big[i + 1];
					}
					break;
				}
			}
		}

		if (flag) {
			return big[left1 + 1];
		} else {
			int left2 = (mid - 2 - left1);
			int left;
			if (left1 == -1) {
				left = small[left2];
			} else if (left2 == -1) {
				left = big[left1];
			} else {
				left = big[left1] > small[left2] ? big[left1] : small[left2];
			}
			int right;
			if (left2 + 1 >= small.length) {
				right = big[left1 + 1];
			} else if (left1 + 1 >= big.length) {
				right = small[left2 + 1];

			} else {

				right = big[left1 + 1] > small[left2 + 1] ? small[left2 + 1] : big[left1 + 1];
			}
			return (double) (left + right) / 2;
		}


	}

	@Test
	public void t1() {
		int[] arr = {4};
		int[] arr2 = {1, 2, 3};
		double medianSortedArrays = findMedianSortedArrays(arr, arr2);
		System.out.println(medianSortedArrays);
		//int medianSortedArrays = binarySearch(0, arr2.length, arr2, 13);
		//System.out.println(medianSortedArrays);
	}
}
