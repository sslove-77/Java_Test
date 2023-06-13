package com.nuist.thread.synchronize.threadGroup;

public class MyThreadGroup implements Runnable{

//    重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}
