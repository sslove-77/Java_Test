/**
 * 定时器 Timer
 构造方法：
 Timer()：创建一个新的计时器。
 Timer(boolean isDaemon)：创建一个新的定时器，其相关线程可以指定为 run as a daemon 。
 Timer(String name)：创建一个新的定时器，其相关线程具有指定的名称。
 Timer(String name, boolean isDaemon)
 创建一个新的定时器，其相关线程具有指定的名称，可以指定为 run as a daemon 。
 其他方法：
 void	cancel()：终止此计时器，丢弃任何当前计划的任务。
 int	purge()：从该计时器的任务队列中删除所有取消的任务。
 void	schedule(TimerTask task, long delay)：在指定的延迟之后安排指定的任务执行。
 void	schedule(TimerTask task, long delay, long period)
 在指定的延迟之后开始 ，重新执行 固定延迟执行的指定任务。

 * 定时器任务 TimerTask
 * public abstract class TimerTask (extends Object) (implements Runnable)：
 可以由计时器进行一次性或重复执行的任务。
 构造方法：
    protected	TimerTask():创建一个新的计时器任务。
 其他方法：
    * abstract void run()：
    * boolean	cancel()：取消此计时器任务。
    * long	scheduledExecutionTime()：返回此任务最近实际执行的预定执行时间。
* */

package com.nuist.thread.synchronize.timer;

import java.util.TimerTask;

public class MyTimer extends TimerTask {
//    重写方法

    @Override
    public void run() {
        System.out.println("hello java");
    }
}