package com.nuist.class_interface;

public class Dog extends Animal implements DogBehavior{
    public Dog() {
    }

    public Dog(String name, int age, String color, char sex) {
        super(name, age, color, sex);
    }

    @Override
    public void dogBehavior() {
        System.out.println("狗戏弄鸡");
    }


}
