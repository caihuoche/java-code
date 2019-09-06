package com.example.demo.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/09/06
 **/
public class SevenTeen {

	HashMap<Character, String[]> map = new HashMap<>();
	List<String> objects = new ArrayList<>();
	char[] chars;

	public List<String> letterCombinations(String digits) {
		if (digits.length() < 1) {
			return objects;
		}
		chars = digits.toCharArray();
		map.put('2', new String[]{"a", "b", "c"});
		map.put('3', new String[]{"d", "e", "f"});
		map.put('4', new String[]{"g", "h", "i"});
		map.put('5', new String[]{"j", "k", "l"});
		map.put('6', new String[]{"m", "n", "o"});
		map.put('7', new String[]{"p", "q", "r", "s"});
		map.put('8', new String[]{"t", "u", "v"});
		map.put('9', new String[]{"w", "x", "y", "z"});

		fore("", 0);
		return objects;

	}

	private void fore(String str, int j) {
		for (int i = 0; i < map.get(chars[j]).length; i++) {
			if (j + 1 == chars.length) {
				objects.add(str + map.get(chars[j])[i]);
				continue;
			}
			fore(str + map.get(chars[j])[i], ++j);
			j--;
		}

	}

	@Test
	public void t1() {
		List<String> strings = letterCombinations("237");
		System.out.println(strings);
	}
}
