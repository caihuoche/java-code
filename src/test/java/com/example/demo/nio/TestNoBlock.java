package com.example.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

/**
 * 非阻塞传输 tcp
 *
 * @author yanghaiyu
 * @date 2019/06/24
 **/
public class TestNoBlock {

	/**
	 * 服务端
	 */
	@Test
	public void t1() throws IOException {

		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.configureBlocking(false);
		channel.bind(new InetSocketAddress("127.0.0.1", 8989));

		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_ACCEPT);

		while (selector.select() > 0) {
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey next = iterator.next();
				if (next.isAcceptable()) {
					SocketChannel socketChannel = channel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
				} else if (next.isReadable()) {
					SocketChannel socketChannel  = (SocketChannel) next.channel();
					ByteBuffer allocate = ByteBuffer.allocate(1024);
					int len = 0;

					// 这里判断事>0 大于0是有数据 如果判断不等于-1 会有问题, 没数据也会进来.
					while ((len = socketChannel.read(allocate)) >0) {
						allocate.flip();
						System.out.println(new Date() + "\n" + new String(allocate.array(), 0, len));
						allocate.clear();
					}
				}
				iterator.remove();
			}
		}
	}

	/**
	 * 客户端
	 */
	@Test
	public void t2() throws IOException {
		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8989));
		socketChannel.configureBlocking(false);
		//Scanner scanner = new Scanner(System.in);
		ByteBuffer allocate = ByteBuffer.allocate(1024);
		//	String next = scanner.next();
			allocate.put("哈哈".getBytes());
			allocate.flip();
			socketChannel.write(allocate);
			allocate.clear();
	}

	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8989));
		socketChannel.configureBlocking(false);
		Scanner scanner = new Scanner(System.in);
		ByteBuffer allocate = ByteBuffer.allocate(1024);
		while (true){
			String next = scanner.next();
			allocate.put(next.getBytes());
			allocate.flip();
			socketChannel.write(allocate);
			allocate.clear();
		}
	}
}
