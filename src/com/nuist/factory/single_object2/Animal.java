/** 单例模式之懒汉式，需要对象的时候才创建，线程不安全
* */
package com.nuist.factory.single_object2;

public class Animal {
//    私有构造方法，外部不能创建对象
    private Animal() {
    }

//    创建对象
   static Animal animal = null;

    //    创建单例的方法
    public static Animal getAnimal() {
        if (animal == null) {
            animal = new Animal();
        }
        return animal;
    }
}
