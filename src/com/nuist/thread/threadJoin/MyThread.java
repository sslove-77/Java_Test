/** public class Thread
  extends Object
  implements Runnable
 线程是程序中执行的线程。 Java虚拟机允许应用程序同时执行多个执行线程。
 每个线程都有优先权。 具有较高优先级的线程优先于优先级较低的线程执行。
 并且当且仅当创建线程是守护进程时才是守护线程。

 * 自定义线程必须继承Thread，重写run方法，调用start方法启动线程

 * Thread的主要方法
    * start(): 启动线程
    * static void sleep(long millis): 线程暂停 millis毫秒
    * static void	yield():对调度程序的一个暗示，即当前线程愿意产生当前使用的处理器。
    * setName(), getName(): 设置/获取当前线程名
    * setPriority(): 设置线程优先级，优先级范围 1-10，默认5
    * void	join(): 等待这个线程死亡。
    * void	interrupt():中断这个线程。
    * void	setDaemon(boolean on)：将此线程标记为 daemon线程或用户线程。
* */
package com.nuist.thread.threadJoin;

//      自定义线程必须继承Thread才能够拥有线程的方法和属性
public class MyThread extends Thread{
//    无参构造方法
    public MyThread() {
    }

//    带参构造方法
    public MyThread(String name) {
        super(name);
    }

//    重写run方法，实现该线程的功能，但是单独调用run方法只是执行程序，并不启动多线程
    @Override
    public void run() {
//        打印200以内的整数
        for (int i = 0; i < 200; i++) {
//            getName方法获取线程名称
            System.out.println(getName()+"--"+i);
        }
    }
}
