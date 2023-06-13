package com.nuist.thread.synchronize.threadpool;

import java.util.concurrent.*;

public class MyCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        创建线程池对象
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

//        将线程对象放入线程池
//        第一种，Runnable接口
        Future<String> future1 = threadPool.submit(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + " 正在打印-" + i);
            }
        }, "complete");

//        返回结果
        String res1 = future1.get();
        System.out.println(res1);

//        实现Callable接口
        Future<Integer> future2 = threadPool.submit(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        });
//      打印结果
        Integer res2 = future2.get();
        System.out.println(res2);

//        关闭线程池，执行完成就回收
        threadPool.shutdown();
    }
}