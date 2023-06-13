/** 多线程下变量的不可见性
    * 当多个线程共享变量时，其中一个线程修改了共享变量，另一个线程不能直接看到该线程修改后的数据的最新值
 * 解决方法：
  1. 用锁，synchronized代码块
  2. 用volatile关键字修饰共享变量
*/
package com.nuist.thread.synchronize.Volatile.visiability;

public class MyThread implements Runnable{
    //    定义共享变量
//    private boolean flag = false;
//      volatile关键字修饰
    private volatile boolean flag;
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //    线程修改共享变量
    @Override
    public void run() {
//        延时修改数据
        try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        flag = true;
        System.out.println("flag="+ flag);
    }
}
