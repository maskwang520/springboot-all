package com.effectivejava.chapter20.current;

import java.util.concurrent.CountDownLatch;

/**
 * Created by maskwang on 2017/8/22 0022.
 * CountDownLatch会阻塞当前线程，直到变为0
 */
public class CountDownLatchTest {
    static CountDownLatch c=new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println(3);
    }
}
