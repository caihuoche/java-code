package com.example.demo.list;

import org.junit.Test;

/**
 *实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1    1243  1324  12433 13234  1236361521 ->1236362115		 1236363512
 * @author yanghaiyu
 * @date 2020/03/20 
 **/
public class ThirtyOne {

	@Test
	public void t1() {
		// 12354  12435
		int[] arr = {2,3,1,3,3};
		nextPermutation(arr);
		System.out.printf(arr.length+"");
	}

	public void nextPermutation(int[] nums) {
		int max = nums[nums.length - 1];
		int k =0;
		int a=0;
		for (int i = nums.length-2; i >= 0; i--) {
			if (max<=nums[i]){
				max = nums[i];
			}else {
				k = i+1;
				a= i+1;
				for (int j =i+1;j<nums.length;j++){
					if (nums[j]<=max && nums[j]>nums[i]){
						max = nums[j];
						k = j;
					}
				}
			 	int temp=	nums[i];
				nums[i]=max;
				nums[k]=temp;

				break;
			}
		}
		// 8,7,6,5,4   47658  4
		for (int i =a,b=nums.length-1; a<b;a++,b--){
			int temp =nums[a];
			nums[a] = nums[b];
			nums[b]= temp;
		}
	}

	public void sort( int[] arr, int k){
			for (int i =k;i<arr.length;i++){
				for (int j= k+1;j<arr.length;j++){
					if (arr[i]>arr[j]){
						int temp = arr[i];
						arr[i] =arr[j];
						arr[j]=temp;
					}

				}
			}
	}
}
