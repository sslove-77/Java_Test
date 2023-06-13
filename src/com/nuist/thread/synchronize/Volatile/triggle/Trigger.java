package com.nuist.thread.synchronize.Volatile.triggle;

public class Trigger{
//    定义变量abc
    public int a = 1;
    public int b = 2;
    public int c = 3;
//  定义volatile触发器标记
    public volatile boolean flag;

//    写方法
    public void write() {
        a = 10;
        b = 20;
        c = 30;
        flag = true;
    }

//    读方法
    public void read() {
        while (flag) {
            System.out.println("a="+a+",b="+b+",c="+c);
        }
    }
}
