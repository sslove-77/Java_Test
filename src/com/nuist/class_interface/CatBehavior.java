package com.nuist.class_interface;

public interface CatBehavior {
//    抽象方法
    public abstract void catBehavior();
//    静态方法
    public static void fun1() {
        System.out.println("fun1");
    }
//    默认方法
    public default void fun2() {
        System.out.println("fun2");
    }

}
