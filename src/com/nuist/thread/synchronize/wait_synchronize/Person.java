package com.nuist.thread.synchronize.wait_synchronize;

public class Person {
//    定义私有变量姓名，年龄
    private String name;
    private int age;

//    定义等待唤醒标记
    private boolean flag;


//    设置姓名，年龄
    public synchronized void setInfo(String name, int age) {
        //        如果有数据则等待
        while (this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        没有数据设置
        this.name = name;
        this.age = age;

//        修改标记
        this.flag = true;
        this.notify();
    }



//    获取姓名，年龄
    public synchronized void getInfo() {
        //        没有数据就等待
        while (!this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        有数据直接打印
        System.out.println(Thread.currentThread().getName()+"--"+this.name+","+this.age);
//        修改标记
        this.flag = false;
        this.notify();
    }
}
