package com.effectivejava.chapter20.current;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by maskwang on 2017/8/22 0022.
 * 等待所有的线程都到达后，才会执行，之前会阻塞
 */
public class CyclicBarrierTest {
    static CyclicBarrier c=new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    c.await();
                }catch (Exception e){
                    System.out.println(e);
                }
                System.out.println(1);
            }
        }).start();
        try{
            c.await();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(2);
    }
    private static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
