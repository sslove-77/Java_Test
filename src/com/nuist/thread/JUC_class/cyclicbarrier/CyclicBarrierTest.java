/** 允许一组线程全部等待彼此达到共同屏障点的同步辅助。 循环阻塞在涉及固定大小的线程方的程序中很有用，这些线程必须等待彼此。
 * 屏障被称为循环 ，因为它可以在等待的线程被释放之后重新使用。
 A CyclicBarrier支持一个可选的Runnable命令，每个屏障点运行一次，在派对中的最后一个线程到达之后，
 但在任何线程释放之前。 在任何一方继续进行之前，此屏障操作对更新共享状态很有用。
 *
 */
package com.nuist.thread.JUC_class.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
//        创建CyclicBarrier对象，若线程执行数量少于参与者数量，则一直阻塞
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()->
                System.out.println("-----执行完成-----"));

//        创建线程对象
        for (int i = 1; i <= 5; i++) {
            new Thread(()-> {
                for (int j = 1; j <= 4; j++) {
                    System.out.println(Thread.currentThread().getName() + "号出现");
                    try {
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            },String.valueOf(i)).start();
        }

    }
}
