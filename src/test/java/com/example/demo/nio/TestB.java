package com.example.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;


import org.junit.Test;


/**
 * 阻塞
 */
public class TestB {

    @Test
    public  void t1() throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",8989));
		SocketChannel accept = serverSocketChannel.accept();
		ByteBuffer allocate = ByteBuffer.allocate(1024);
 int len =0;
		while ((len=accept.read(allocate))!=-1){
			allocate.flip();
			System.out.println(new Date()+"\n"+ new String(allocate.array(),0,len));
			allocate.clear();
		}
		System.out.println(111111111+"");

		allocate.put("哈哈哈".getBytes());
		allocate.flip();
		accept.write(allocate);

	}

	public static void main(String[] args) throws IOException {
		SocketChannel open = SocketChannel.open();
		open.connect(new InetSocketAddress("127.0.0.1",8989));
		Scanner scanner = new Scanner(System.in);

		ByteBuffer allocate = ByteBuffer.allocate(1024);
		while (true){
			String next = scanner.next();
			allocate.put(next.getBytes());
			allocate.flip();
			open.write(allocate);
			allocate.clear();
			if (next.equals("1234")){
				break;
			}
		}
		open.shutdownOutput();

		int len =0;
		while ((len =open.read(allocate))!=-1){
			allocate.flip();
			System.out.println(new String(allocate.array(),0,len));
			allocate.clear();
		}
	}
/*	@Test
	public  void t2() throws IOException {
		SocketChannel open = SocketChannel.open();
		open.connect(new InetSocketAddress("127.0.0.1",8989));
		Scanner scanner = new Scanner(System.in);

		ByteBuffer allocate = ByteBuffer.allocate(1024);
		while (true){
			allocate.put(scanner.next().getBytes());
			allocate.flip();
			open.write(allocate);
			allocate.clear();
		}
	}*/
}
