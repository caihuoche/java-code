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
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int l = j + 1;
				int r = nums.length - 1;
				while (l < r) {
					if (nums[i] + nums[j] + nums[l] + nums[r] < target)
						l++;
					else if (nums[i] + nums[j] + nums[l] + nums[r] > target)
						r--;
					else if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
						if ((l == j + 1 || nums[l] != nums[l - 1])) {
							List<Integer> obj = new ArrayList<>();
							obj.add(nums[i]);
							obj.add(nums[j]);
							obj.add(nums[l]);
							obj.add(nums[r]);
							objects.add(obj);
						}
						l++;
					}

				}
			}
		}
		return objects;
	}

	@Test
	public void t1() {
		int[] nums = {-2, 0, 0, 3, 3, -1};
		int target = 5;
		List<List<Integer>> lists = fourSum(nums, target);
		System.out.println(lists);
	}
}
