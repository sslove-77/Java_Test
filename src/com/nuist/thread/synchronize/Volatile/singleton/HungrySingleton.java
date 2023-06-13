/** 单例模式：饿汉式(线程安全)和懒汉式(非线程安全)
 * 饿汉式：事先给定类实例
*/
package com.nuist.thread.synchronize.Volatile.singleton;

public class HungrySingleton {
//    静态实例
    private static final HungrySingleton singleton = new HungrySingleton();

//    私有构造方法
    private HungrySingleton(){
    }

    //    获取实例的方法
    public static HungrySingleton getInstance() {
        return singleton;
    }

    public void show() {
        System.out.println("饿汉式实例");
    }
}
