package com.nuist.class_interface;

public class Cat extends Animal implements CatBehavior{
//    无参构造
    public Cat() {
    }

//    带参构造
    public Cat(String name, int age, String color, char sex) {
        super(name, age, color, sex);
    }

//    重写CatBehavior接口的方法

    @Override
    public void catBehavior() {
        System.out.println("猫抓老鼠");
    }

    //   接口中的fun2
    public void fun2() {
        System.out.println("重写fun2");
//        调用接口中的默认方法
        CatBehavior.super.fun2();
    }

//    私有方法
    private int calculate(int num1, int num2) {
        return num1 * num2;
    }

//    重写父类中的eat方法
    public static void eat() {
        System.out.println("猫吃鱼");
    }
}
