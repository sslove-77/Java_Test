package com.nuist.thread.newThread;

/**
 * @author Helen
 * @date 2023-02-12 14:29
 */
public class MulThreadTest {
    public static void main(String[] args) {
        //        创建两个线程
        MulThread thread1 = new MulThread("线程1");
        MulThread thread2 = new MulThread("线程2");

//        开启线程
        thread1.start();
        thread2.start();

    }
}
