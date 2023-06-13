package com.nuist.class_inner;

public class AnimalTest {
    public static void main(String[] args) {
//        创建成员内部类对象
//        Animal.Sub1 as1 = new Animal().new Sub1();

//        当内部类为静态时
        Animal.Sub1 as1 =new Animal.Sub1();
//        调用方法
        int  res1 =  as1.sum();
        System.out.println(res1);
        as1.fun();

//        定义局部内部类
        Animal animal = new Animal();
        animal.display();
    }
}
