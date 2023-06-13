package com.nuist.thread.newThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Helen
 * @date 2023-02-20 19:29
 */
public class MyThread{

    private static int total = 1;
    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();


//    采用synchronized关键字

//    public synchronized void sell() {
//        this.notifyAll();
//        if (total != 0) {
//            try {
//                System.out.println(Thread.currentThread().getName() + "--printing" + total--);
////                Thread.sleep(100);
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public synchronized void produce() {
//        this.notifyAll();
//        if (total != 1) {
//            try {
//                System.out.println(Thread.currentThread().getName() + "--printing" + total++);
////                Thread.sleep(100);
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }


//    使用lock

    public void sell() {

        try {
            lock.lock();
            while (total != 1) {
                con.await();
            }

            System.out.println(Thread.currentThread().getName()+"当前值"+total--);
            con.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void produce() {
        try {
            lock.lock();
            while (total != 0) {
                con.await();
            }

            System.out.println(Thread.currentThread().getName()+"当前值"+total++);
            con.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
