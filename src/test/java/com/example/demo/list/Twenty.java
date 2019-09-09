package com.example.demo.list;

import java.util.Stack;

import org.junit.Test;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 *
 * @author yanghaiyu
 * @date 2019/09/08
 **/
public class Twenty {

	public boolean isValid(String s) {
		if ("".equals(s)) return true;

		char[] chars = s.toCharArray();
		if (s.length() % 2 == 1) return false;

		Stack<Character> objects = new Stack<>();
		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
				case '(':
					objects.push(chars[i]);
					break;
				case '[':
					objects.push(chars[i]);
					break;
				case '{':
					objects.push(chars[i]);
					break;
				case ')':
					if (objects.empty()|| '(' != objects.pop())
						return false;
					break;
				case ']':
					if (objects.empty()|| '[' != objects.pop())
						return false;
					break;
				case '}':
					if (objects.empty()|| '{' != objects.pop())
						return false;
					break;
			}
		}
		return objects.size() > 0 ? false : true;
	}


	@Test
	public void t1() {
		String s = "()[]{}";
		boolean valid = isValid(s);
		System.out.println(valid);
	}
}
