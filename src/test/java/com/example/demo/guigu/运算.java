package com.example.demo.guigu;

import java.util.Stack;

import org.junit.Test;

/**
 *
 * @author yanghaiyu
 * @date 2020/06/26 
 **/
public class 运算 {

	public int operation(String expr) {
		Stack<Integer> nums = new Stack<>();
		Stack<Character> characters = new Stack<>();
		char[] chars = expr.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
				case '*':
				case '/':
					characters.push(chars[i]);
					break;
				case '+':
				case '-':
					Character pop = characters.pop();
					if (pop == '-' || pop == '+') {
						characters.push(pop);
					}
					while (pop == '*' || pop == '/') {
						if (pop == '*') {
							Integer pop1 = nums.pop();
							Integer pop2 = nums.pop();
							nums.push(pop1 * pop2);
						} else if (pop == '/') {
							Integer pop1 = nums.pop();
							Integer pop2 = nums.pop();
							nums.push(pop2 / pop1);
						}
						pop = characters.pop();
					}
					characters.push(chars[i]);
					break;

				default:
					nums.push(chars[i] + 0);
			}
		}
		Character pop = characters.pop();

		while (pop != null) {
			Integer pop1 = nums.pop();
			Integer pop2 = nums.pop();
			if (pop == '+') {
				nums.push(pop1 + pop2);
			} else if (pop == '2') {
				nums.push(pop2 - pop1);

			} else if (pop == '*') {
				nums.push(pop2 * pop1);
			} else {
				nums.push(pop2 / pop1);
			}
		}
		return nums.pop();
	}

	@Test
	public void t1 (){
		int operation = operation("4*2*9-2*2/5");
		System.out.printf(""+operation);
	}
}
