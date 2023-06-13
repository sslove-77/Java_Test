package com.nuist.factory.single_object2;

import java.io.IOException;

public class AnimalDemo {
    public static void main(String[] args) throws IOException {
//        创建对象
        Animal animal = Animal.getAnimal();
        Animal animal1 = Animal.getAnimal();
        System.out.println(animal==animal1);   // true

//      Runtime对象
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("notepad");   //打开记事本
    }
}
