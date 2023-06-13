package com.nuist.reflect.myclass;

/**
 * @author Helen
 * @date 2023-03-05 12:32
 */
public class Human {
    //    定义姓名，年龄
    public String name;
    private int age;

    public Human() {
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //    成员方法
    public void printObj(Object obj) {
        System.out.println(obj);
    }

    private void working() {
        System.out.println("员工应该爱岗敬业");
    }


}
