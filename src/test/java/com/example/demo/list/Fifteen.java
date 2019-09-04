package com.example.demo.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

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

	public List<List<Integer>> threeSum(int[] nums) {
		HashMap<Integer, Integer> set = new HashMap<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			set.put(nums[i], i);
		}
		List<List<Integer>> arrayList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			//map.put(nums[i],i);
			for (int j = i + 1; j < nums.length; j++) {
			//	map.put(nums[j],j);
				int temp = 0 - (nums[i] + nums[j]);
				Integer integer = set.get(temp);
				if (integer!=null && set.get(temp)>j  ) {
						List<Integer> objects = new ArrayList<>();
						objects.add(nums[i]);
						objects.add(nums[j]);
						objects.add(temp);
						arrayList.add(objects);
					//map.put(temp,integer);
				}
			}
			map.clear();
		}
		return arrayList;
	}

	@Test
	public void t1() {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> lists = threeSum(nums);
		System.out.println(lists);
	}
}
