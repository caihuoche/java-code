package com.example.demo.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2019/07/03
 **/
public class TestPipe {

	@Test
	public void t1() throws IOException {
		Pipe pipe = Pipe.open();
		Pipe.SinkChannel sink = pipe.sink();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.put("你好啊".getBytes());
		byteBuffer.flip();
		while (byteBuffer.hasRemaining()) {
			sink.write(byteBuffer);
		}

		Pipe.SourceChannel source = pipe.source();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int len = source.read(buffer);
		buffer.flip();
		System.out.println(new String(buffer.array(), 0, len));
		buffer.clear();
		source.close();
		sink.close();
	}
}
