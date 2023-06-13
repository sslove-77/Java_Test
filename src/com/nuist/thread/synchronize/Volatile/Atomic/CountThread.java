package com.nuist.thread.synchronize.Volatile.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class CountThread implements Runnable{
//    定义共享变量count
//    private volatile int count = 0;

    //    定义原子类变量
    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

                System.out.println(Thread.currentThread().getName()+"--"+atomicInteger.incrementAndGet());
        }


    }
}
