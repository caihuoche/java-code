package com.example.demo.list;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/08/16
 **/
public class Four {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1Max = nums1[nums1.length - 1];
		int nums2Max = nums1[nums2.length - 1];
		int nums1Min = nums1[0];
		int nums2Min = nums1[0];
		int max = nums1Max > nums2Max ? nums1Max : nums2Max;
		int min = nums1Min > nums2Min ? nums2Min : nums1Min;
		int mid = (max - min) / 2;


	}

	@Test
	public void t1() {
		int[] arr = {4, 10, 12, 24, 56};
		int[] arr2 = {16, 17, 18, 24, 38};
		double medianSortedArrays = findMedianSortedArrays(arr, arr2);
		System.out.println(medianSortedArrays);
	}
}
