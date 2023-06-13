/** Field	getDeclaredField(String name):返回一个 Field对象，它反映此表示的类或接口的指定已声明字段类对象。
 * Field[] getDeclaredFields()
    返回的数组 Field对象反映此表示的类或接口声明的所有字段 类对象。
 * Field	getField(String name)
    返回一个 Field对象，它反映此表示的类或接口的指定公共成员字段 类对象。
 * Field[]	getFields()
    返回包含一个数组 Field对象反射由此表示的类或接口的所有可访问的公共字段 类对象。

 Field类的方法：
 * void	set(Object obj, Object value)：将指定对象参数上的此 Field对象表示的字段设置为指定的新值。
 * void	setBoolean(Object obj, boolean z)：设置作为一个字段的值 boolean指定的对象上。
 * void	setByte(Object obj, byte b)：设置作为一个字段的值 byte指定的对象上。
 * void	setChar(Object obj, char c)：设置作为一个字段的值 char指定的对象上。

 * Method	getDeclaredMethod(String name, 类<?>... parameterTypes)
    返回一个方法对象，它反映此表示的类或接口的指定声明的方法 类对象。
 * Method[]	getDeclaredMethods()
    返回包含一个数组方法对象反射的类或接口的所有声明的方法，通过此表示类对象，
    包括公共，保护，默认（包）访问和私有方法，但不包括继承的方法。
 * Method	getMethod(String name, 类<?>... parameterTypes)
    返回一个 方法对象，它反映此表示的类或接口的指定公共成员方法 类对象。
 * Method[]	getMethods()
    返回包含一个数组 方法对象反射由此表示的类或接口的所有公共方法 类对象，
 包括那些由类或接口和那些从超类和超接口继承的声明。
 Method类的方法：
 * Object	invoke(Object obj, Object... args)
    在具有指定参数的 方法对象上调用此 方法对象表示的底层方法。
 *
* */
package com.nuist.reflect.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetFields {
    public static void main(String[] args) throws Exception {
//        创建class对象
        Class cls = Class.forName("com.nuist.classfile.Employee");
//       无参构造
        Constructor cons = cls.getConstructor();
        Object obj = cons.newInstance();

//        获取成员变量name
        Field fieldName = cls.getField("name");
//        为name赋值
        fieldName.set(obj, "helen");
        System.out.println(obj);

//        获取私有成员变量age
        Field fieldAge = cls.getDeclaredField("age");
//        为age赋值
        fieldAge.setAccessible(true);
        fieldAge.set(obj, 27);
        System.out.println(obj);

//        获取成员方法1
        Method m1 = cls.getMethod("printObj", Object.class);
//        为方法写入参数invoke方法
        m1.invoke(obj, "hello");

//        获取私有成员方法3，必须获取权限
        Method m3 = cls.getDeclaredMethod("sum", int.class, int.class);
        m3.setAccessible(true);

        Integer res = (Integer) m3.invoke(obj, 3, 5);
        System.out.println(res);
    }
}
