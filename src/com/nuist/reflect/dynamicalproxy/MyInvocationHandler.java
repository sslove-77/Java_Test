package com.nuist.reflect.dynamicalproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    //      定义被代理类对象实例
    private Object obj;

//    构造方法

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        调用代理类对象的invoke方法
        System.out.println("权限校验");
        Object result = method.invoke(obj, args);
        return result;
    }
}
