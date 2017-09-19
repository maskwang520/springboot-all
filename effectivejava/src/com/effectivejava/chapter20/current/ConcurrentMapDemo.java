package com.effectivejava.chapter20.current;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by maskwang on 2017/9/5 0005.
 */
public class ConcurrentMapDemo {
    static ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        concurrentHashMap.put(1, "mask");
        concurrentHashMap.put(2, "wang");
        concurrentHashMap.put(3, "sb");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(Map.Entry entry:concurrentHashMap.entrySet()){
                    System.out.println(entry.getKey()+":"+entry.getValue());
//                    concurrentHashMap.remove(2);
                    System.out.println("size:"+concurrentHashMap.size());
                }

            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                concurrentHashMap.remove(2);
                for(Map.Entry entry:concurrentHashMap.entrySet()){
                    System.out.println(entry.getKey()+":"+entry.getValue());

                }
            }
        }, "t2");
        t1.start();
        t2.start();
//        Map<Integer,String> map=new HashMap<Integer,String>();
//        map.put(1,"hello");
//        map.put(2,"didi");
//        map.put(3,"wokao");
//        for(Map.Entry entry:map.entrySet()){
//            System.out.println(entry.getKey()+":"+entry.getValue());
//            map.remove(2);
//        }
//
    }
}
