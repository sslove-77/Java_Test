package com.nuist.thread.newThread;

import com.nuist.thread.newThread.MyThread;

/**
 * @author Helen
 * @date 2023-02-20 19:32
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    myThread.sell();
                }
            }
        },"Add1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    myThread.produce();
                }
            }
        }, "Sub1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               for (int i = 0; i < 100; i++) {
                   myThread.sell();
               }
            }
        },"Add2").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    myThread.produce();
                }
            }
        }, "Sub2").start();

    }
}
