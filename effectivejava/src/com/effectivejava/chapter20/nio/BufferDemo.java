package com.effectivejava.chapter20.nio;

import java.nio.CharBuffer;

/**
 * Created by maskwang on 2017/9/13 0013.
 */
public class BufferDemo {
    public static void main(String[] args) {
        CharBuffer buf = CharBuffer.allocate(1024);
        buf.put("abcd");
        buf.flip();
        int i=0;
        while (buf.hasRemaining()) {
            System.out.println(buf.get());
            if(i==2){
                System.out.println(buf.position());
                buf.mark();
                System.out.println(buf.limit());
            }
            if(i==3){
                buf.reset(); //position 回到标记处
            }
            i++;
        }

    }
}
