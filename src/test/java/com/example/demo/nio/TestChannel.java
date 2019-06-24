package com.example.demo.nio;

import org.apache.tomcat.jni.File;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {

    /**
     *
     *  通道分为:
     *  阻塞
     *   FileChannel
     *
     *    非阻塞
     *   SocketChannel
     *   ServerSocketChannel
     *   DatagramChannel
     * 获取通道三种方式
     * 1. getchannle;
     * 2. 静态方面 open;
     * 3. files工具类
     * @throws IOException
     */

    /**
     *  file 非直接缓冲区
     * @throws IOException
     */
    @Test
    public void t1() throws IOException {

        FileInputStream fin = null;
        FileOutputStream fot= null;
        FileChannel finChannel = null;
        FileChannel fotChannel =null;
        try {
            fin = new FileInputStream("/Users/vipkid/Desktop/1.jpg");
             fot = new FileOutputStream("/Users/vipkid/Desktop/2.jpg");

             finChannel = fin.getChannel();
             fotChannel = fot.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (finChannel.read(buffer) != -1){
                buffer.flip();
                fotChannel.write(buffer);
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fotChannel!=null){
                fotChannel.close();
            }
            if (finChannel!=null){
                finChannel.close();
            }
            if (fot!=null){
                fot.close();
            }
            if (fin!=null){
                fin.close();
            }
        }

    }

    /**
     * file 直接缓冲期  只有 filechannel支持 直接缓冲区
     */
    @Test
    public void t2 () throws IOException {
        FileChannel fileChannel = null;
        FileChannel fileChannel2 = null;
        try {
            fileChannel = FileChannel.open(Paths.get("/Users/vipkid/Desktop/1.jpg"));
             fileChannel2 = FileChannel.open(Paths.get("/Users/vipkid/Desktop/3.jpg"),StandardOpenOption.CREATE,StandardOpenOption.WRITE);

            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

            while (fileChannel.read(buffer)!=-1){
                buffer.flip();
                fileChannel2.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileChannel2.close();;
        fileChannel.close();
    }

    /**
     * file 直接缓冲 另种方式
     * @throws IOException
     */
    @Test
    public void t3 () throws IOException {
        FileChannel fileChannel = null;
        FileChannel fileChannel2 = null;
        try {
            fileChannel = FileChannel.open(Paths.get("/Users/vipkid/Desktop/1.jpg"));
            fileChannel2 = FileChannel.open(Paths.get("/Users/vipkid/Desktop/4.jpg"),StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.READ);

            // 内存映射文件
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            MappedByteBuffer map1 = fileChannel2.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());

            byte[] bytes = new byte[map.limit()];
            map.get(bytes);
            map1.put(bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }

        fileChannel2.close();;
        fileChannel.close();
    }

    /**
     * 分类读取和聚集
     */
    @Test
    public  void t4() throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("/Users/vipkid/Desktop/1.jpg", "rw");
        RandomAccessFile accessFile2 = new RandomAccessFile("/Users/vipkid/Desktop/5.jpg", "rw");


        FileChannel channel = accessFile.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(10);
        ByteBuffer allocate2 = ByteBuffer.allocate(102400);

        ByteBuffer[] byteBuffers = {allocate,allocate2};
        channel.read(byteBuffers);
        allocate.flip();
        allocate2.flip();


        accessFile2.getChannel().write(byteBuffers);

    }
}
