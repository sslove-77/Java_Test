package com.nuist.reflect.staticproxy;

public class PumaFactory implements ClothFactory{
    @Override
    public void produce() {
        System.out.println("彪马生产了一批新货");
    }
}
