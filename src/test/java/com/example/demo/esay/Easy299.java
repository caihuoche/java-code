package com.example.demo.esay;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 *
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 *
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 示例 2:
 *
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 *  
 *
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 *
 * @author yanghaiyu
 * @date 2020/06/24 
 **/
public class Easy299 {
	public String getHint(String secret, String guess) {
		char[] secretChars = secret.toCharArray();
		char[] guessChars = guess.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder stringBuilder = new StringBuilder();
		int bulls = 0, cows = 0;
		for (int i = 0; i < secretChars.length; i++) {
			if (secretChars[i] == guessChars[i]) {
				bulls++;
			} else {
				if (map.containsKey(guessChars[i])) {
					map.put(guessChars[i], map.get(guessChars[i]) + 1);
				} else {
					map.put(guessChars[i], 1);
				}
			}
		}
		for (int i = 0; i < secretChars.length; i++) {
			if (secretChars[i] != guessChars[i]) {
				Integer integer = map.get(secretChars[i]);
				if (integer !=null ){
					if (integer>0){
						cows++;
						map.put(secretChars[i], integer-1);
					}
				}
			}
		}
		StringBuilder append = stringBuilder.append(bulls).append("A").append(cows).append("B");
		return append.toString();
	}

	@Test
	public void t1(){
		getHint("1807","7810");
	}
}
