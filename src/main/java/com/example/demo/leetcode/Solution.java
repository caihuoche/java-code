package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] arr = new int[2];

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int a = target - nums[i];
			if (map.containsKey(a) && map.get(a) != i) {
				arr[0] = i;
				arr[1] = map.get(a);
				return arr;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;
		int[] ints = twoSum(nums, target);
		System.out.println(Arrays.toString(ints));
	}
}