/** 假设某电影院有4个窗口售卖200张票，编写多线程程序实现售票
 *
 */

package com.nuist.thread.synchronize.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTickets {
    //    电影票总数
    private int tickets = 200;

    //    定义锁对象
    private final Lock lock = new ReentrantLock();

//    Lock实现
    public void sell2() {
        while (true) {
            //            获取锁
            lock.lock();
            try {
                if (tickets > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "出售第" + tickets--
                            + "张票, 余票" + tickets);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }

    }

}
