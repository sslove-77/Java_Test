/** 线程间通信：
    * wait-notify
    * await-signal
 * 需求：让线程A执行5次操作，然后B执行10次，最后C执行20次，反复执行整个过程20次
 * 分析：设置一个标记flag，当值为1时执行A，为3时执行B，为5时执行C
*/
package com.nuist.thread.synchronize.thread_communication2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCommunication {
    //    设置标志变量
    private int flag = 1;

    //    创建锁对象
    private final Lock lock = new ReentrantLock();
    //    创建三个线程唤醒对象
    private final Condition cond1 = lock.newCondition();
    private final Condition cond2 = lock.newCondition();
    private final Condition cond3 = lock.newCondition();

//    方法1
    public void show1() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                cond1.await();
            }
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }

            //    修改标记
            flag = 2;
//            唤醒线程B
            cond2.signal();

        }finally {
            lock.unlock();
        }
    }

//    方法2
    public void show2() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                cond2.await();
            }
            for (int i = 1; i <= 2; i++) {
                System.out.println(Thread.currentThread().getName()+"："+i);
            }

            flag = 3;
            cond3.signal();
        }finally {
            lock.unlock();
        }
    }

    //    方法3
    public void show3() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                cond3.await();
            }
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName()+"："+i);
            }

            flag = 1;
            cond1.signal();
        }finally {
            lock.unlock();
        }
    }
}
