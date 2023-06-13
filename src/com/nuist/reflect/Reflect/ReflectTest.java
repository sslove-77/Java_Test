/** 通过反射结合配置文件输出对应的类中的方法
* */
package com.nuist.reflect.Reflect;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws  Exception {
//        利用Properties加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("ClassInit.txt"));
//        获取类名，方法名
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

//        创建class对象
        Class cls = Class.forName(className);
//        无参构造
        Constructor cons = cls.getDeclaredConstructor();
//        创建实例对象
        Object obj = cons.newInstance();
//        获取方法
        Method method = cls.getDeclaredMethod(methodName);
        method.setAccessible(true);   // 获取权限
//        调用方法
        method.invoke(obj);

    }
}
