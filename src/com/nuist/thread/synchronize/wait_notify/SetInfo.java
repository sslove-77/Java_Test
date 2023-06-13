package com.nuist.thread.synchronize.wait_notify;

public class SetInfo implements Runnable{

//    创建学生对象
    Student stu;
    //    定义变量
    int x = 0;

    public SetInfo(Student stu) {
        this.stu = stu;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (stu) {
                if (stu.flag) {
                    try {
                        stu.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (x % 2 == 0) {
                    stu.name = "java";
                    stu.age = 22;
                } else {
                    stu.name = "python";
                    stu.age = 10;
                }
                x++;

//                修改标记
                stu.flag = true;
//                  唤醒
                stu.notify();
            }

        }
    }
}
