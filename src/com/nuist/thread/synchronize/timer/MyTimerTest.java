package com.nuist.thread.synchronize.timer;

import java.util.Timer;

public class MyTimerTest {
    public static void main(String[] args) {
//        创建定时器对象
        Timer timer = new Timer();

//        定时器调度
//        timer.schedule(new MyTimer(),2000);  //延迟2秒执行
        timer.schedule(new MyTimer(),4000,2000);  // 延迟4秒执行，然后每隔2秒执行一次

    }
}