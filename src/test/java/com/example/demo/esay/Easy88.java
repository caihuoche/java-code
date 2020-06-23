package com.example.demo.esay;


import org.junit.Test;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @author yanghaiyu
 * @date 2020/06/19 
 **/
public class Easy88 {
	/**
	 * 第一种, 空间复杂度 O(n) 时间复杂度 O(2n), 速度很快,但是显然不符合题解.
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] arr = new int[m + n];
		m--;
		n--;
		for (int i = m + n + 1; i >= 0; i--) {
			if (m >= 0 && n >= 0) {
				arr[i] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
			} else {
				arr[i] = m >= 0 ? nums1[m--] : nums2[n--];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			nums1[i] = arr[i];
		}
		System.out.printf("arr");
	}

	@Test
	public void t1() {
		int[] nums1 = {0};
		int m = 0;
		int[] nums2 = {1};
		int n = 1;

		merge2(nums1, m, nums2, n);

	}

	/**
	 * 任何时候都要有逆向思维. 反着推
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		m--;
		n--;
		for (int i = m + n + 1; i >= 0; i--) {
			if (m >= 0 && n >= 0){
				nums1[i] = nums1[m] < nums2[n] ? nums2[n--] : nums1[m--];

			}else {
				nums1[i] = m >= 0 ? nums1[m--] : nums2[n--];

			}
		}
		System.out.printf("m");
	}

}
