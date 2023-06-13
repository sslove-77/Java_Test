package com.nuist.reflect.dynamicalproxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
//       创建被代理类对象
        ClothFactory pumaFactory = new PumaFactory();
        ClothFactory proxy = (ClothFactory) getProxyInstance(pumaFactory);
//        代理实现方法
        proxy.produce();
        proxy.create("shoes");
    }

    public static Object getProxyInstance(Object obj) {
//        创建代理对象
        MyInvocationHandler handler = new MyInvocationHandler(obj);
        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), handler);
        return proxy;
    }

}
