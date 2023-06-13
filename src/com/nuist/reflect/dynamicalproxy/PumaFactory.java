package com.nuist.reflect.dynamicalproxy;

public class PumaFactory implements ClothFactory {
    @Override
    public void produce() {
        System.out.println("彪马生产了一批新货");
    }

    @Override
    public void create(String name) {
        System.out.println("生产了一批"+name);
    }
}
