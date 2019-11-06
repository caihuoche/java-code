package com.example.demo.list;

import org.junit.Test;

/**
 * [0,0,0,1,1,1,2,2,3,3,4],
 *
 * @author yanghaiyu
 * @date 2019/10/23
 **/
public class TwentySix {
	public int removeDuplicates(int[] nums) {
		int flag = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[flag]) {
				flag++;
				if (flag != i) {
					nums[flag] = nums[i];
				}
			}
		}
		return flag + 1;
	}

	@Test
	public void t1() {
		int[] nums = {0,2,2};
		int i = removeDuplicates(nums);
		System.out.println(i);
	}
}
