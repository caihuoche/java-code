package com.example.demo.esay;

/**
 *给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * @author yanghaiyu
 * @date 2020/06/19 
 **/
public class FiftyEight {
	public static int lengthOfLastWord(String s) {
		char[] chars = s.toCharArray();
		int sum =0;
		for (int i =chars.length-1;i>=0 ;i--){
			if (chars[i] !=' '){
				sum++;
			}else {
				if (sum>0){
					break;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.printf(lengthOfLastWord("jee we2   2")+"");
	}
}
