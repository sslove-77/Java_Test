/** 线程安全的等待唤醒机制
 * Object类中的方法
    * wait(): 等待
    * notify()：唤醒
    * notifyAll() ：唤醒所有
* */
package com.nuist.thread.synchronize.wait_notify;

public class StudentTest {
    public static void main(String[] args) {
//        创建学生对象
        Student s = new Student();

//        创建资源对象
        GetInfo getInfo = new GetInfo(s);
        SetInfo setInfo = new SetInfo(s);

//        创建线程对象
        Thread thread1 = new Thread(getInfo);
        Thread thread2 = new Thread(setInfo);

//        启动线程
        thread2.start();
        thread1.start();
    }
}