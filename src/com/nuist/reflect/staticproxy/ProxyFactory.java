package com.nuist.reflect.staticproxy;

public class ProxyFactory implements ClothFactory{
//    创建私有被代理对象
    private ClothFactory cloth;

    public ProxyFactory(ClothFactory cloth) {
        this.cloth = cloth;
    }

    @Override
    public void produce() {
        cloth.produce();
        System.out.println("代理对象销售该批货");
    }
}
