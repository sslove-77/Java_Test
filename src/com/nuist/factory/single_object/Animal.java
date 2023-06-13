/** 单例模式之饿汉式，事先创建对象
* */
package com.nuist.factory.single_object;

public class Animal {
//    私有构造方法，外部不能创建对象
    private Animal() {
    }

//    创建对象
   static Animal animal = new Animal();

//    动物类的方法
    public void eat() {
        System.out.println("动物吃什么呢？");
    }

//    创建单例的方法
    public static Animal getAnimal() {
        return animal;
    }
}
