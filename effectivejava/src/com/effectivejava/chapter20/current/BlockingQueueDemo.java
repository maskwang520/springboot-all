package com.effectivejava.chapter20.current;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by maskwang on 2017/9/5 0005.
 */
public class BlockingQueueDemo {
    static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        TimeUnit.SECONDS.sleep(10);
    }

    private static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    blockingQueue.put("string" + i);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

                if (i == 3) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true)
                try {
                    System.out.println(blockingQueue.take());
                } catch (InterruptedException e) {
                    System.out.println(e);

                }
        }
    }
}

