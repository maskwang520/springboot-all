package com.effectivejava.chapter20.current;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by maskwang on 2017/8/22 0022.
 * 原子操作类
 */
public class AtomicIntegerTest {
    static AtomicInteger ai=new AtomicInteger(1);
    static int []value=new int[]{1,2};
    static AtomicIntegerArray aia=new AtomicIntegerArray(value);

    public static void main(String[] args) {
//        System.out.println(ai.getAndIncrement()); //still oldvalue
//        System.out.println(ai.get());
//        System.out.println(ai.compareAndSet(2,3));
//        System.out.println(ai.get());
        aia.getAndSet(0,3);
        System.out.println(aia.get(0));
        System.out.println(value[0]);

    }
}
