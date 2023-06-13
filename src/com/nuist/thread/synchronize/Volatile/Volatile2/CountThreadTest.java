/** volatile能保证共享变量的可见性，但是不能保证原子性操作
 * 解决方法：
    * 加锁机制
    * 原子性类实现
 *
 */

package com.nuist.thread.synchronize.Volatile.Volatile2;

public class CountThreadTest {
    public static void main(String[] args) {
//        创建资源对象
        CountThread countThread = new CountThread();
//        创建200个线程，计算count的值
        for (int i = 1; i <= 200; i++) {
            new Thread(countThread,"Thread"+i).start();
        }
    }
}