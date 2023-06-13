/** wait-notify可能出现虚假唤醒情况，为防止虚假唤醒，在条件判断时，采用while(条件)，而不是if
*/
package com.nuist.thread.synchronize.thread_communication;

public class AwaitSignalTest {
    public static void main(String[] args) {
//        创建资源对象
        AwaitSignal waitNotify = new AwaitSignal();

        //        创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    waitNotify.add();
                }
            }
        },"add1").start();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    waitNotify.sub();
                }
            }
        },"sub1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    waitNotify.add();
                }
            }
        },"add2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    waitNotify.sub();
                }
            }
        },"sub2").start();

    }
}