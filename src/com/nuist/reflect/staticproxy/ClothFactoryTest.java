package com.nuist.reflect.staticproxy;

public class ClothFactoryTest {
    public static void main(String[] args) {
//        创建被代理对象
        ClothFactory clothFactory = new PumaFactory();
//        创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory(clothFactory);
//        调用方法实现代理
        proxyFactory.produce();
    }
}
