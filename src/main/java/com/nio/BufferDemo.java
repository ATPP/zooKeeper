package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo {

    public static void main(String[] args) {
        String resource = "/Users/mc/Downloads/test.txt";
        String destination = "/Users/mc/Desktop/test.txt";
        try {
            nioCopyFile(resource, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void nioCopyFile(String resource, String destination) throws IOException {
        FileInputStream inputStream = new FileInputStream(resource);
        FileOutputStream outputStream = new FileOutputStream(destination);
        FileChannel readChannel = inputStream.getChannel();
        FileChannel writeChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true){
            byteBuffer.clear();
            int len = readChannel.read(byteBuffer);
            if (len == -1){
                break;
            }
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
        }
        readChannel.close();
        writeChannel.close();
    }
}
