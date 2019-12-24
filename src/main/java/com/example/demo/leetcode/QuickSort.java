package com.example.demo.leetcode;

/**
 * @author yanghaiyu
 * @date 2019/12/10
 **/
public class QuickSort {

	public static void main(String[] args) {

		int[] arr ={5,4,3,6,3,7,8,3};
		sort(arr,0,arr.length-1);
		System.out.println(1);
	}

	public static void sort(int arr[], int left, int right) {
		if (left>right){
			return;
		}
		System.out.println(left);
		int mid = arr[left];
		int l = left, r = right;

		while (l < r) {
			while (arr[l] <= mid && l<r) {
				l++;
			}
			while (arr[r] >= mid && l<r) {
				r--;
			}
			if (l < r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
		}
		int temp =arr[left];
		arr[left]=arr[l];
		arr[l]=temp;
		sort(arr,left,l-1);
		sort(arr,r+1,right);
	}
}
