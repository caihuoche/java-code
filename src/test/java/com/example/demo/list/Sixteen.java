package com.example.demo.list;

import java.util.Arrays;

import org.junit.Test;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @author yanghaiyu
 * @date 2019/09/06
 **/
public class Sixteen {

	/**
	 * 这个也类似于三数之和了,  同上一样 一个指针固定, 俩指针分头跑, 空间复杂的 0(1)
	 */
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int temp = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {

			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (Math.abs(target - sum) < Math.abs(target - temp)) {
					temp = sum;
				}
				if (sum < target) {
					l++;
				}
				if (sum > target) {
					r--;
				}
				if (sum == target) {
					return target;
				}

			}
		}
		return temp;
	}

	@Test
	public void t1() {
		int[] nums = {-1, 2, 1, -4};
		int tatger = 1;
		int i = threeSumClosest(nums, tatger);
		System.out.println(i);
	}
}
