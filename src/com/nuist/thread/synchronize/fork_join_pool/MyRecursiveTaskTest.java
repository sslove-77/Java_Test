package com.nuist.thread.synchronize.fork_join_pool;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class MyRecursiveTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        创建任务对象
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(1, 100);
//        创建合并分支池对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        提交任务并返回结果
        Instant start1 = Instant.now();
        ForkJoinTask<Integer> task = forkJoinPool.submit(myRecursiveTask);
        Instant end1 = Instant.now();
        Integer res = task.get();
        System.out.println("1+2+...+100的结果为"+res+" ,计算时间为:"+
        Duration.between(start1, end1).toMillis()+"毫秒");

//        第二种方法
        Instant start2 = Instant.now();
        ForkJoinTask<Integer> task1 = forkJoinPool.submit(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        });
        Instant end2 = Instant.now();
        Integer res2 = task1.get();

        System.out.println("1+2+...+100的结果为"+res2+" ,计算时间为:"+
                Duration.between(start2, end2).toMillis()+"毫秒");

//        关闭线程池
        forkJoinPool.shutdown();
    }
}