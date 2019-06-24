package com.example.demo.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.junit.Test;


/**
 * @author yanghaiyu
 * @date 2019/06/24
 **/
public class TestCharSet {

	@Test
	public void t1() {
		SortedMap<String, Charset> map = Charset.availableCharsets();

		Set<Map.Entry<String, Charset>> entries = map.entrySet();
		entries.forEach((x) -> {
			System.out.println(x.getKey() + "   " + x.getValue());
		});


	}

	@Test
	public void t2() throws CharacterCodingException {
		Charset charset = Charset.forName("ISO-8859-13");

		CharsetEncoder charsetEncoder = charset.newEncoder();
		CharsetDecoder charsetDecoder = charset.newDecoder();

		String a = "你好啊哈哈哈hhhaaa";

		ByteBuffer wrap = ByteBuffer.wrap(a.getBytes());

		/*byte[] bytes = new byte[100];
		encode.get(bytes);

		String s = new String(bytes);
		System.out.println(s);
*/
		CharBuffer decode = charsetDecoder.decode(wrap);

		ByteBuffer encode = charsetEncoder.encode(decode);

		//encode.flip();
		byte[] bytes = new byte[encode.limit()];
		encode.get(bytes);


		String s2 = new String(bytes);
		System.out.println(s2);

	}
}
