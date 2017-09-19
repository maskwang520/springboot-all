package com.effectivejava.chapter20.current;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by maskwang on 2017/8/24 0024.
 * 主要用于线程间交换数据（可用于校对工作）
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr=new Exchanger<>();
    private static ExecutorService threadPool= Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "task a";
                    String B=exgr.exchange(A);//交换点
                    System.out.println("B:"+B);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
//                try {
//                    String B = "task b";
////                    String A = exgr.exchange(B);
////                    System.out.println("A:"+A);
//                }catch (InterruptedException e){
//                    System.out.println(e);
//                }
            }
        });
        threadPool.shutdown();
    }
}
