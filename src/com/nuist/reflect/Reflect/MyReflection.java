package com.nuist.reflect.Reflect;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Helen
 * @date 2023-03-04 22:07
 */
public class MyReflection {

    @Test
    public void reflectTest() {


//        获取构造器
        try {

//        获取对象的类
            Class<?> personClass = Class.forName("com.nuist.reflect.myclass.Employee");
            Constructor<?> constructor = personClass.getDeclaredConstructor();
            constructor.setAccessible(true);
//            根据构造器创建对象
            Object obj = constructor.newInstance();


//            获取所有实现的接口
//            Class<?>[] interfaces = personClass.getInterfaces();
//            for (Class cls : interfaces) {
//                System.out.println(cls);
//            }

//            获取所有申明的变量
//            Field[] fields = personClass.getDeclaredFields();
//            for (Field f : fields) {
////                System.out.println(f);
////                获取每个变量的权限修饰符
//                int modifiers = f.getModifiers();
//                System.out.println(Modifier.toString(modifiers));
//            }

//            获取所有申明或继承的方法
//            Method[] method = personClass.getDeclaredMethods();
//            for (Method m : method) {
//                System.out.println(m);
//            }


//            获取属性，方法
//            Field name = personClass.getDeclaredField("name");
//            name.setAccessible(true);
//            name.set(obj, "Helen");
//
//            Field career = personClass.getDeclaredField("career");
//            career.setAccessible(true);
//            career.set(obj, "manager");
//            System.out.println(obj.toString());
//
            Method sum = personClass.getDeclaredMethod("sum", int.class, int.class);
            sum.setAccessible(true);
            Object invoke = sum.invoke(obj, 4, 6);
            System.out.println(invoke);
//
            Method printObj = personClass.getMethod("printObj", Object.class);
            printObj.setAccessible(true);
            printObj.invoke(obj, "hello, java");

//            父类的私有方法不能访问，但是编译时不会报错，运行时才报异常，所以这也是反射的动态性的体现
//            Method working = personClass.getMethod("working");
//            working.invoke(obj);

            Method country = personClass.getMethod("country", String.class);
            country.invoke(obj, "中国");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void propertiesTest() {

//        创建properties对象
        Properties properties = new Properties();
        try {
//            方式一：直接加载配置文件，默认在当前module下
//            加载文件
            properties.load(new FileReader("src\\oracle2.properties"));

//            方式二：利用ClassLoader加载，默认在src下
//            InputStream is = MyReflection.class.getClassLoader().getResourceAsStream("oracle2.properties");
//            properties.load(is);

            //          读取文件

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String pwd = properties.getProperty("password");

            System.out.println(driver);
            System.out.println(url);
            System.out.println(user);
            System.out.println(pwd);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
