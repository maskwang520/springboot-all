package com.effectivejava.chapter20.current;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by maskwang on 2017/8/22 0022.
 * fork join框架的使用
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD=4;
    private int start;
    private int end;
    public CountTask(int start,int end) {
        this.start=start;
        this.end=end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute=(end-start)<=THRESHOLD;
        if(canCompute){
            for (int i=start;i<=end;i++){
                sum+=i;
                int k=1/0; //throw Exception
            }
        }else {
            int middle=(start+end)/2;
            CountTask leftTask=new CountTask(start,middle);
            CountTask rightTask=new CountTask(middle+1,end);
            leftTask.fork();
            rightTask.fork();
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            sum=leftResult+rightResult;
        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        CountTask countTask=new CountTask(1,4);

        Future<Integer> result=forkJoinPool.submit(countTask);

        try{
            System.out.println(result.get());
        }catch (InterruptedException e){

        }catch (ExecutionException e){
            System.out.println("sbbb");
            System.out.println(countTask.isCompletedAbnormally());
            System.out.println(countTask.getException());
        }

    }
}
