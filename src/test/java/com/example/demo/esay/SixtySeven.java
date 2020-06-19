package com.example.demo.esay;

import org.junit.Test;

/**
 给你两个二进制字符串，返回它们的和（用二进制表示）。

 输入为 非空 字符串且只包含数字 1 和 0。

  

 示例 1:

 输入: a = "11", b = "1"
 输出: "100"
 示例 2:

 输入: a = "1010", b = "1011"
 输出: "10101"
  

 提示：

 每个字符串仅由字符 '0' 或 '1' 组成。
 1 <= a.length, b.length <= 10^4
 字符串如果不是 "0" ，就都不含前导零。
 通过次数89,327提交次数169,131

 * @author yanghaiyu
 * @date 2020/06/19 
 **/
public class SixtySeven {
	public String addBinary(String a, String b) {
		char[] charsa = a.toCharArray();
		char[] charsb = b.toCharArray();
		int i = charsa.length-1;
		int j = charsb.length-1;
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		while ( i>=0 && j>=0){
			if (charsa[i] == '0'){
				if (charsb[j]=='0'){
					sb.insert(0,'0');
				}else {
					sb.insert(0,'1');
				}
			}else {
				if (charsb[j]=='0'){
					sb.insert(0,'1');
				}else {
					sb.insert(0,'0');
					flag =true;
				}
			}
		}return "";
	}

	@Test
	public void t(){

		System.out.print( '0'-'1' + " "
		);	}
}
