package com.nuist.thread.threadInterrupt;

public class ThreadInterruptTest {
    public static void main(String[] args) {
//        创建线程对象
        ThreadInterrupt threadInterrupt = new ThreadInterrupt();
//        启动线程
        threadInterrupt.start();
        try {
            Thread.sleep(4000);
            threadInterrupt.interrupt();
//            Thread.sleep(1000);
            System.out.println("线程重跑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}