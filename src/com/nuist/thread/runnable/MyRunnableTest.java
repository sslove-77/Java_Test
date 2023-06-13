package com.nuist.thread.runnable;

/**
 * @author Helen
 * @date 2023-02-12 14:30
 */
public class MyRunnableTest {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread th1 = new Thread(myRunnable, "线程1");
        Thread th2 = new Thread(myRunnable, "线程2");

        th1.start();
        th2.start();
    }

}
