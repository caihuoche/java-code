package middle;

import org.junit.Test;

/**
 *给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * @author yanghaiyu
 * @date 2020/06/23 
 **/
public class Middle238 {
	/**
	 * 提供俩个数组,  一个记录元素左边的乘积,一个记录元素右边的乘积 时间 O(n) 空间0(n)
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		left[0] = 1;
		right[nums.length - 1] = 1;
		for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
			left[i] = left[i - 1] * nums[i-1];
			right[j] = right[j + 1] * nums[j+1];
		}
		for (int i = 0; i < nums.length ; i++) {
			nums[i] = left[i] * right[i];
		}
		return nums;
	}

	@Test
	public void t1(){
		int[] arr ={1,2,3,4};
		int[] ints = productExceptSelf2(arr);
		System.out.printf("i");
	}

	/**
	 * 第二种, 时间 O(n) 空间O(1)
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf2(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i - 1] * nums[i-1];
		}
		int pro = 1;
		result[nums.length -1] = result[nums.length -1] * pro;
		for (int i = nums.length -2; i >=0 ; i--) {
			pro = pro * nums[i+1];
			result[i] = result[i] * pro;
		}
		return result;
	}
}
