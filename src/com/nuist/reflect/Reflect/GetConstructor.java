/** 反射 reflect
 * 类的加载过程：加载、连接、初始化
    * 类加载器：
        * Bootstrap ClassLoader：根类加载器，负责java核心类的加载，如 System，String
        * Extension ClassLoader：扩展类加载器，负责JRE的扩展目录中jar包的加载
        * System ClassLoader：系统类加载器，负责在JVM启动时加载来自java命令的class文件，以及classpath
                            环境变量指定的jar包和类路径
 * public abstract class ClassLoader (extends Object):类加载器是负责加载类的对象。 ClassLoader类是一个抽象类。
 * 构造方法：
    * protected	ClassLoader()
        创建使用该方法返回的 ClassLoader一个新的类加载器 getSystemClassLoader()作为父类加载器。
    * protected	ClassLoader(ClassLoader parent)
        使用指定的父类加载器创建一个新的类加载器进行委派。

 * public final class Class<T> (extends Object)
  implements Serializable, GenericDeclaration, Type, AnnotatedElement
    Class类的类表示正在运行的Java应用程序中的类和接口

 Class类的方法：
 *  static 类<?> forName(String className):返回与给定字符串名称的类或接口相关联的 类对象。
 *  String	getName()：返回由类对象表示的实体（类，接口，数组类，原始类型或空白）的名称，作为 String 。
 *  类<?>[]	getClasses()：返回包含一个数组 类表示所有的公共类和由此表示的类的成员接口的对象 类对象。
 * ClassLoader	getClassLoader()：返回类的类加载器。
 * Constructor<T>	getConstructor(类<?>... parameterTypes)
     返回一个 Constructor对象，该对象反映 Constructor对象表示的类的指定的公共 类函数。
 * Constructor<?>[]	getConstructors()：返回包含一个数组 Constructor对象反射由此表示的类的所有公共构造类对象。
 * Constructor<T>	getDeclaredConstructor(类<?>... parameterTypes)
    返回一个 Constructor对象，该对象反映 Constructor对象表示的类或接口的指定 类函数。
 * Constructor<?>[]	getDeclaredConstructors()
    返回一个反映 Constructor对象表示的类声明的所有 Constructor对象的数组 类 。
 * setAccessible(true): 赋予权限
* */
package com.nuist.reflect.Reflect;

import java.lang.reflect.Constructor;

public class GetConstructor {
    public static void main(String[] args) throws Exception {
//        获取Employee的Class文件
        Class cls = Class.forName("com.nuist.classfile.Employee");

//        获取所有public构造方法
//        Constructor[] cons = cls.getConstructors();
//        for (Constructor c : cons) {
//            System.out.println(c);
//        }

//        获取所有构造方法
//        Constructor[] cons = cls.getDeclaredConstructors();
//        for (Constructor c : cons) {
//            System.out.println(c);
//        }

//        获取无参构造方法
        Constructor cons = cls.getConstructor();
//        创建实例
        Object obj = cons.newInstance();
        System.out.println(obj);

//        获取带参构造方法
        Constructor cons2 = cls.getConstructor(String.class, int.class, String.class);
//            创建实例对象
        Object obj2 = cons2.newInstance("helen", 27, "engineer");
        System.out.println(obj2);

//        获取私有带参构造方法
        Constructor cons3 = cls.getDeclaredConstructor(String.class, int.class);
//        获取权限
        cons3.setAccessible(true);
//        创建实例对象,IllegalAccessException 非法访问私有对象，所以必须获取权限后再使用
        Object obj3 = cons3.newInstance("java", 20);
        System.out.println(obj3);
    }
}
