package com.example.demo.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class TestBuffer {

    @Test
    public void t1(){
        String str = "abcdef";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 缓冲区总大小
        System.out.println("capacity:"+buffer.capacity());
        // 可以读取到的大小
        System.out.println("limit:"+buffer.limit());

        //当前位置
        System.out.println("position:"+buffer.position());

        buffer.put(str.getBytes());

        // 缓冲区总大小
        System.out.println("capacity:"+buffer.capacity());
        // 可以读取到的大小
        System.out.println("limit:"+buffer.limit());

        //当前位置
        System.out.println("position:"+buffer.position());

        buffer.flip();
        // 缓冲区总大小
        System.out.println("capacity:"+buffer.capacity());
        // 可以读取到的大小
        System.out.println("limit:"+buffer.limit());

        //当前位置
        System.out.println("position:"+buffer.position());


        byte [] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println("读取"+new String(bytes));

        // 缓冲区总大小
        System.out.println("capacity:"+buffer.capacity());
        // 可以读取到的大小
        System.out.println("limit:"+buffer.limit());

        //当前位置
        System.out.println("position:"+buffer.position());

        buffer.rewind();

        System.out.println("rewind=======rewind=======rewind=======rewind=======rewind=======rewind=======");
        // 缓冲区总大小
        System.out.println("capacity:"+buffer.capacity());
        // 可以读取到的大小
        System.out.println("limit:"+buffer.limit());

        //当前位置
        System.out.println("position:"+buffer.position());

        byte[] bytes1 = new byte[3];
        buffer.get(bytes1);
        System.out.println(new String(bytes1));
        System.out.println("dule2==========================================================================");


        System.out.println("capacity:"+buffer.capacity());
        // 可以读取到的大小
        System.out.println("limit:"+buffer.limit());

        //当前位置
        System.out.println("position:"+buffer.position());
        buffer.mark();
        buffer.get(bytes1);
        System.out.println(new String(bytes1));

        System.out.println("dule3==========================================================================");

        System.out.println("capacity:"+buffer.capacity());
        // 可以读取到的大小
        System.out.println("limit:"+buffer.limit());

        //当前位置
        System.out.println("position:"+buffer.position());

        buffer.reset();
        System.out.println("capacity:"+buffer.capacity());
        // 可以读取到的大小
        System.out.println("limit:"+buffer.limit());

        //当前位置
        System.out.println("position:"+buffer.position());

        while (buffer.hasRemaining()){
            System.out.println(buffer.remaining());
            break;
        }

    }
}
