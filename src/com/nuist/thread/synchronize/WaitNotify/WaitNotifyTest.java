/** wait-notify防止虚假唤醒，while(条件)
*/
package com.nuist.thread.synchronize.WaitNotify;

public class WaitNotifyTest {
    public static void main(String[] args) {
//        创建资源对象
        WaitNotify waitNotify = new WaitNotify();

        //        创建线程
        Thread add1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.add();
            }
        },"add1");

        Thread sub1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.sub();
            }
        },"sub1");

        Thread add2 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.add();
            }
        },"add2");

        Thread sub2 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.sub();
            }
        },"sub2");

        add1.start();
        sub1.start();
        add2.start();
        sub2.start();

    }
}