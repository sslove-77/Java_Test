package com.nuist.factory.single_object;

public class AnimalTest {
    public static void main(String[] args) {
//        创建单例对象
        Animal animal1 = Animal.getAnimal();
        Animal animal2= Animal.getAnimal();
        System.out.println(animal1==animal2);    // true，单例模式只能创建一个对象，故为同一对象
        animal1.eat();
    }
}
