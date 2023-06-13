package com.nuist.thread.synchronize.communication2;

/**
 * @author Helen
 * @date 2023-02-13 21:41
 */
public class Factory {
    /**
     * 假设原始生产数量为0
     */
    public static int total = 0;

    /**
     * 消费，只有当total>0才能消费，消费完即可唤醒生产
     */
    public synchronized void consume() {

        if (total > 0) {
            System.out.println(Thread.currentThread().getName() + "正在消费第" + total-- + "张票");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 生产，只要小于等于0就开始生产，大于1就阻塞
     */
    public synchronized void produce() {
        if (total <= 20) {
            System.out.println(Thread.currentThread().getName() + "正在生产第" + ++total + "张票");
            notify();

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
