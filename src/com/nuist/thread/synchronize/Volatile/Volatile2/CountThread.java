package com.nuist.thread.synchronize.Volatile.Volatile2;

public class CountThread implements Runnable{
//    定义共享变量count
    private volatile int count = 0;

//    定义锁
    private Object obj = new Object();
    @Override
    public void run() {

        synchronized (obj) {
            for (int i = 0; i < 1000; i++) {
                    count++;
                    System.out.println(Thread.currentThread().getName()+"--"+count);
            }

        }
    }
}
