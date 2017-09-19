package com.effectivejava.chapter20.current;

import java.util.concurrent.TimeUnit;

/**
 * Created by maskwang on 2017/8/18 0018.
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL=new
            ThreadLocal<Long>(){
                @Override
                protected Long initialValue() {
                    return System.currentTimeMillis();
                }
            };
    public static final void begin(){
        TIME_THREADLOCAL.set((System.currentTimeMillis()));
    }
    public static final long end(){
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("cost:"+Profiler.end()+"mills");

    }
}
