package com.example.demo.db;

import org.junit.Test;

/**
 *  TODO 一次没做出来,
 *[
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yanghaiyu
 * @date 2020/07/01 
 **/
public class 排序矩阵查找 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if ( matrix==null) return false;
		if ( matrix.length==0) return false;
		int m = matrix[0].length;
		int n = matrix.length;
		int i = 0;
		while (m > 0  && i<n) {
			if (matrix[i][m - 1] > target) {
				m--;
			} else if (matrix[i][m - 1] < target) {
				i++;
			} else {
				return true;
			}
		}
		return false;
	}

	//[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
	//20
	@Test
	public  void t1(){
		int[] a = {1,   4,  7, 11, 15};
		int[] a2 = {2,   5,  8, 12, 19};
		int[] a3 = {3,   6,  9, 16, 22};
		int[] a4 = {10, 13, 14, 17, 24};
		int[] a5 = {18, 21, 23, 26, 30};
		int[][] arr = {{1,1}};
		boolean b = searchMatrix(arr, 2);
		System.out.println(b);
	}
}
