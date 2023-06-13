package com.nuist.factory.simple_factory;

public class Doctor extends Person{
    @Override
    public void work() {
        System.out.println("医生的工作：治病救人");
    }
}
