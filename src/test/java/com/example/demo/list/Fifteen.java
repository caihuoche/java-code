package com.example.demo.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * @author yanghaiyu
 * @date 2019/09/04
 **/
public class Fifteen {

	/**
	 * 去重有点繁琐,没有继续下去
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		HashMap<Integer, Integer> set = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			set.put(nums[i], i);
		}
		List<List<Integer>> arrayList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int temp = 0 - (nums[i] + nums[j]);
				Integer integer = set.get(temp);
				if (integer != null && set.get(temp) > j) {
					List<Integer> objects = new ArrayList<>();
					objects.add(nums[i]);
					objects.add(nums[j]);
					objects.add(temp);
					arrayList.add(objects);
				}
			}
		}
		return arrayList;
	}

	/**
	 * 看了思路 才知道用一个指针固定,双指镇移动
	 */
	public List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> arrayList = new ArrayList<>();
		int length = nums.length;
		for (int i = 0; i < nums.length - 2; i++) {
			int r = length - 1;
			if (i > 0) {
				if (nums[i] == nums[i - 1]) {
					continue;
				}
			}
			for (int j = i + 1; j < r; j++) {
				while (nums[i] + nums[j] + nums[r] < 0 && nums[j] < 0 && j < r - 1) {
					j++;
				}
				while (nums[i] + nums[j] + nums[r] > 0 && nums[r] > 0 && j < r - 1) {
					r--;
				}
				if (nums[i] + nums[j] + nums[r] == 0 ) {
					if (j - 1 != i ){
						if (nums[j] == nums[j - 1]){
							continue;
						}
					}
					List<Integer> objects = new ArrayList<>();
					objects.add(nums[i]);
					objects.add(nums[j]);
					objects.add(nums[r]);
					arrayList.add(objects);
				}
			}

		}
		return arrayList;
	}

	@Test
	public void t1() {
		//	int[] nums = {-10,-3,-8,-3,4,-1,-2,-4,-8,-5};
		int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> lists = threeSum2(nums);
		System.out.println(lists);
	}
}
