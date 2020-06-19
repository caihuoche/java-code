package com.example.demo.esay;

/**
 *给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author yanghaiyu
 * @date 2020/06/18 
 **/
public class ThirtyFive {

	/**
	 * 普通
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i]) {
				return i;
			}
		}
		return nums.length;
	}

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int tar = 2;
		int i = searchInsert2(nums, tar);
		System.out.printf(i + "");
	}

	public static int searchInsert2(int[] nums, int target) {
		if (nums[0] >target) {
			return 0;
		}
		int left = 0, right = nums.length - 1;
		int index=0;
		while (left <= right) {
			index = (left + right) / 2;

			if (nums[index] > target) {
				right = index - 1;
			} else if (nums[index] < target) {
				left = index + 1;
				index =left;
			} else {
				return index;
			}
		}
		return index;
	}
}
