package com.nuist.reflect.classfile;

import com.nuist.classfile.Employee;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
//        获取Class文件的三种方法
//        方法一：根据实例对象调用getClass()方法
        Employee employee = new Employee();
        Class c1 = employee.getClass();

//        方法二：类名.class
        Class c2 = Employee.class;

//        方法三：直接获取
        Class c3 = Class.forName("com.nuist.classfile.Employee");

        System.out.println(c1 == c2 && c2 == c3);  // true

    }
}
