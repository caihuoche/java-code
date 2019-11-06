package com.example.demo.list;

import org.junit.Test;

/**
 * 给定 nums = [1,2,2,3,4,3], val = 3,
 *
 * @author yanghaiyu
 * @date 2019/11/06
 **/
public class TwentySeven {

	public int removeElement(int[] nums, int val) {
		int flag = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				if (flag != i) {
					nums[flag] = nums[i];
				}
				flag++;
			}
		}

		return flag;
	}

	@Test
	public void t1() {
		int[] nums = {1,2,2,3,4,3};
		int val = 3;
		int i = removeElement(nums, 3);
		System.out.println(i);
	}

}
