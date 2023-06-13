/** 信号量，用来控制线程池中，单次执行线程个数
 */
/** 这是一段注释
*/
package com.nuist.thread.JUC_class.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MySemaphore {
////    定义5辆车
//    private int num = 5;
//    定义信号量
    private Semaphore semaphore = new Semaphore(6);

    public void park(){
//        获取

        try {

            semaphore.acquire();

            System.out.println(Thread.currentThread().getName()+" 抢占车位");
//        暂停几秒钟
            TimeUnit.SECONDS.sleep(new Random().nextInt(4));
            System.out.println(Thread.currentThread().getName()+" 离开车位");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //        释放
            semaphore.release();
        }
    }
}
