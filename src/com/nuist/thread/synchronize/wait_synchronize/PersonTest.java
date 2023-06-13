package com.nuist.thread.synchronize.wait_synchronize;

public class PersonTest {
    public static void main(String[] args) {
//        创建person对象
        Person person = new Person();
            //        创建线程对象
        for (int i = 1; i <= 2; i++) {
//            设置信息线程
            new Thread(()-> {
                person.setInfo("mary", 24);
                System.out.println(Thread.currentThread().getName() + "发送数据");

            }).start();
//            获取信息线程
            new Thread(person::getInfo).start();

        }

    }
}