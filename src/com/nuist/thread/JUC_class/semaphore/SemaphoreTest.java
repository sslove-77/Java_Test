/** Semaphore 信号量
 * 需求：5辆车，2个停车位，怎么停车
*/
package com.nuist.thread.JUC_class.semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
//        创建资源对象
        MySemaphore mySemaphore = new MySemaphore();
//        创建线程
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                mySemaphore.park();
            },"第"+i+"辆车").start();
        }

    }
}
