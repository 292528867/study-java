package com.yk.example.utils;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yk on 16/5/25.
 */
public class NIOUtils {


    public static void testChannel() throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("/Users/yk/http.js", "rw");
        FileChannel channel = accessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int byteRead = channel.read(buffer);
        while (byteRead != -1) {
            System.out.println("Read " + byteRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            byteRead = channel.read(buffer);
        }
        accessFile.close();
    }


    public static void testScatterAndGather() throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("/Users/yk/http.js", "rw");
        FileChannel channel = accessFile.getChannel();
        ByteBuffer headBuffer = ByteBuffer.allocate(48);
        ByteBuffer bodyBuffer = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {bodyBuffer, headBuffer};
        channel.read(buffers);     //分散 scatter
        channel.write(bodyBuffer); //聚合 gather
    }

   /* public static void main(String[] args) throws Exception{
        NIOUtils.testChannel();
    }*/
}
