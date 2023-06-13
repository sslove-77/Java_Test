package com.nuist.thread.synchronize.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    public static void main(String[] args) {
//        创建Executors线程池对象

//        线程池大小固定，同一时间只能有4个线程执行，后面的排队
//        ExecutorService threadPool = Executors.newFixedThreadPool(4);

//        创建可扩容线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
//        创建多个线程提交到线程池
        for (int i = 1; i <= 29; i++) {
            final int num = i;
            threadPool.execute(()->
                System.out.println(Thread.currentThread().getName() + " 当前值为:" + num)
            );
        }

//        关闭线程池
        threadPool.shutdown();

    }
}
