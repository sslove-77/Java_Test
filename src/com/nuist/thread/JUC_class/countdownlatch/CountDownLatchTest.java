/** A CountDownLatch用给定的计数初始化。 await方法阻塞，直到由于countDown()方法的调用而导致当前计数达到零，
  之后所有等待线程被释放，并且任何后续的await 调用立即返回。这是一个一次性的现象 - 计数无法重置。
 A CountDownLatch是一种通用的同步工具，可用于多种用途。 一个CountDownLatch为一个计数的
 CountDownLatch用作一个简单的开/关锁存器，或者门：所有线程调用await在门口等待，
 直到被调用countDown()的线程打开。 一个CountDownLatch初始化N可以用来做一个线程等待，
 直到N个线程完成某项操作，或某些动作已经完成N次。
 * CountDownLatch一个有用的属性是，它不要求调用countDown线程等待计数到达零之前继续，
 * 它只是阻止任何线程通过await ，直到所有线程可以通过。
*/
package com.nuist.thread.JUC_class.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
//        创建CountDownLatch计数对象
        int num = 5;  // 计数为5
        CountDownLatch countDownLatch = new CountDownLatch(num);

//        创建线程对象
        for (int i = 1; i < num; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"号选手离场");

                //        计数减1
                countDownLatch.countDown();

            },String.valueOf(i)).start();
        }

        //        计数等待，直到为0才释放
//        countDownLatch.await();  // 若计数值大于1，则一直阻塞

//        如果达到计数时间，也会释放
        countDownLatch.await(1, TimeUnit.MILLISECONDS);
//        输出最终阻塞结果
        System.out.println("计数结束，程序运行完成");
    }
}
