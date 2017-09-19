package com.effectivejava.chapter20.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by maskwang on 2017/9/3 0003.
 */
public class ChanelDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("D://content.txt", "rw");
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);

            int byteReader = inChannel.read(byteBuffer);

            while (byteReader != -1) {
                System.out.println("Read:" + byteReader);
                System.out.println(byteBuffer.capacity()+":"+byteBuffer.limit()+":"+byteBuffer.position());
                byteBuffer.flip();
                System.out.println(byteBuffer.capacity()+":"+byteBuffer.limit()+":"+byteBuffer.position());
                while (byteBuffer.hasRemaining()) {
                    System.out.println((char)byteBuffer.get());
                }

                byteBuffer.clear();

                byteReader = inChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                aFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
