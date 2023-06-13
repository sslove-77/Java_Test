/** 单例模式：饿汉式(线程安全)和懒汉式(非线程安全)
 * 懒汉式：不提前给定，需要时再创建
    * 用synchronized保证线程安全，但是效率低
    * 用synchronized，volatile二次检查保证线程安全和效率
    * 静态内部类方式
*/
package com.nuist.thread.synchronize.Volatile.singleton;

public class LazySingleton3 implements Runnable{

//    私有构造方法
    private LazySingleton3(){
    }

//    静态内部类
    private static class Inner{
        private static final LazySingleton3 singleton = new LazySingleton3();
    }

    //    获取实例的方法
    public static LazySingleton3 getInstance() {
        return Inner.singleton;
    }

    public void show() {
        System.out.println(Thread.currentThread().getName()+"懒汉式单例");
    }

    @Override
    public void run() {
        Inner.singleton.show();
    }
}
