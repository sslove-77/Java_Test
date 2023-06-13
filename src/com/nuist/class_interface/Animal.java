package com.nuist.class_interface;

public class Animal {
//    定义姓名，年龄，颜色，性别
    private String name;
    protected int age;
    public String color;
    private char sex;

//    无参构造方法
    public Animal() {
    }

//    带参构造方法


    public Animal(String name, int age, String color, char sex) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    //    定义受保护的方法
    protected void show() {
        System.out.println("动物类");
    }

    /**
     * 静态方法，只能使用静态参数和方法
     */
    public static void eat() {
        System.out.println("动物吃什么呢？");
//        可调用静态方法
        test();
//        不可调用非静态方法
//        int();
    }

    /**
     * 私有静态方法
     */
    private static void test() {
        System.out.println("这是私有方法，仅在本类范围内可用");
    }

    /**
     * 非静态方法
     */

    public int count(int ... num) {
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        return sum;
    }
}
