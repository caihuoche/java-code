package com.example.demo;

/**
 * @author yanghaiyu
 * @date 2019/11/30
 **/
public class Dup {

	/**
	 * 1,1,2,2,3,4,4,5,5,5
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr ={1,1,2,2,3,4,4,5,5,5};
		int ducp = ducp(arr);
		System.out.println(arr);
	}

	private static int ducp(int[] arr) {

		int temp=0;
		for (int i =1;i<arr.length;i++){
			if (arr[temp]==arr[i]){

			}else {
				arr[++temp]=arr[i];
			}
		}
		return temp;
	}
}
