package com.effectivejava.chapter20.current;


import java.util.concurrent.*;


/**
 * Created by maskwang on 2017/8/24 0024.
 */
public class ThreadPoolExcutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(49,49,1000, TimeUnit.MILLISECONDS,new LinkedBlockingQueue(5), new ThreadPoolExecutor.AbortPolicy());
        Future<String> future=null;
        for(int i=0;i<40;i++){
             future=threadPoolExecutor.submit(new callTask());

        }
        try{
            String s=future.get();
            System.out.println(s);
            System.out.println(threadPoolExecutor.getLargestPoolSize());
            System.out.println(threadPoolExecutor.getTaskCount());
            System.out.println(Runtime.getRuntime().availableProcessors());
        }catch (ExecutionException e){
            System.out.println(e);
        }catch (InterruptedException e){
            System.out.println(e);
        }finally {
            threadPoolExecutor.shutdown();
        }
        System.out.println(threadPoolExecutor);
    }

    private static class callTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "hello world";
        }
    }
}
