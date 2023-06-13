package com.nuist.factory.simple_factory;

public class Police extends Person{
    @Override
    public void work() {
        System.out.println("警察的职责：保卫人民财产安全");
    }
}
