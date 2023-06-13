package com.nuist.thread.synchronize.wait_notify;

public class GetInfo extends Thread{
//    定义学生对象
    Student stu;
    public GetInfo(Student stu) {
        this.stu = stu;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (stu) {
                if (!stu.flag) {
                    try {
                        stu.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                //            打印学生姓名和年龄
                System.out.println(stu.name+"--"+stu.age);
//                修改标记
                stu.flag = false;
//                唤醒
                stu.notify();

            }

        }
    }
}
