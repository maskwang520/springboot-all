package com.effectivejava.chapter20.current;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by maskwang on 2017/8/19 0019.
 */
public class Cache {
    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    public static final Object get(String key) { //读
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new ReadThread());
        Thread th2 = new Thread(new WriteThrea());
        Thread th3 = new Thread(new WriteThrea());
        th1.start();
        th2.start();
        th3.start();
    }

    private static class ReadThread implements Runnable {
        @Override
        public void run() {
            System.out.println("read" + map.toString());
        }
    }

    private static class WriteThrea implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                map.put(String.valueOf(i), "one");
            }
        }
    }
}
