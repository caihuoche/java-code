package com.example.demo.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/09/06
 **/
public class Eighteen {

	public List<List<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);
		List<List<Integer>> objects = new ArrayList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; i < nums.length - 2; j++) {
				int l = j + 1;
				int r = nums.length - 1;
				while (l < r) {
					if (nums[i] + nums[j] + nums[l] + nums[r] < target)
						l++;
					if (nums[i] + nums[j] + nums[l] + nums[r] > target)
						r--;
					if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
						List<Integer> obj = new ArrayList<>();
						obj.add(nums[i]);
						obj.add(nums[j]);
						obj.add(nums[l]);
						obj.add(nums[r]);
						objects.add(obj);
					}

				}
			}
		}
		return objects;
	}

	@Test
	public void t1() {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> lists = fourSum(nums, target);
		System.out.println(lists);
	}
}
