package com.effectivejava.chapter20.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by maskwang on 2017/8/24 0024.
 * 控制同时访问资源的数量
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT=100;
    private static ExecutorService threadPool= Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore=new Semaphore(1);

    public static void main(String[] args) {
        for (int i=0;i<THREAD_COUNT;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                        System.out.println("sava data"+semaphore.hasQueuedThreads());
                        semaphore.release();
                    }catch (InterruptedException e){
                        System.out.println(e);
                    }
                }
            });

        }
        threadPool.shutdown();
    }

}
