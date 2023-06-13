/** 单例模式：饿汉式(线程安全)和懒汉式(非线程安全)
 * 懒汉式：不提前给定，需要时再创建
    * 用synchronized保证线程安全，但是效率低
    * 用synchronized，volatile二次检查保证线程安全和效率
    * 静态内部类方式
*/
package com.nuist.thread.synchronize.Volatile.singleton;

public class LazySingleton1 implements Runnable{
//    静态实例
    private static LazySingleton1 singleton;

//    私有构造方法
    private LazySingleton1(){
    }

    //    获取实例的方法
    public static synchronized LazySingleton1 getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton1();
        }

        return singleton;
}

    public void show() {
        System.out.println(Thread.currentThread().getName()+"懒汉式单例");
    }

    @Override
    public void run() {
        singleton.show();
    }
}
