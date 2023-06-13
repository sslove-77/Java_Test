package com.nuist.reflect.myclass;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Employee extends Human implements Comparable<Employee>, Behavior {

    //    定义姓名，年龄，职业，工资
    public String name;
    private int age;
    private String career;
    private double salary;

//    无参构造方法
    public Employee() {
    }

    //    带参构造1

    public Employee(String name) {
        this.name = name;
    }

//    带参构造2

    public Employee(String name, int age) {
        super(name, age);
    }

//      带参构造3
    public Employee(String name, int age, String career) {
        super(name, age);
        this.career = career;
    }

    public Employee(String name, int age, String career, double salary) {
        super(name, age);
        this.career = career;
        this.salary = salary;
    }


//    成员方法2
    public void show() {
        System.out.println("show");
    }
//      成员方法3
    private Integer sum(int a, int b) {
        return a + b;
    }


//    创建成员变量的方法
    public static ArrayList<Employee> getEmp() {
//        创建集合对象
        ArrayList<Employee> arrayList = new ArrayList<>();
//        创建Employee对象
        Employee emp = new Employee("ss", 29, "engineer",30);
        Employee emp2 = new Employee("qq", 27, "data",21.5);
        Employee emp3 = new Employee("lin", 26, "gong",18);
        Employee emp4 = new Employee("fei", 27, "doctor",19);

//        将元素添加到集合
        arrayList.add(emp);
        arrayList.add(emp2);
        arrayList.add(emp3);
        arrayList.add(emp4);

//        返回
        return arrayList;
    }

    @Override
    public String toString() {
        return "Employee {name=" + name + ",age=" + age + ",career=" + career + "}";
    }

    @Override
    public int compareTo(Employee em) {
        int num = em.age - this.age;
        return num == 0 ? em.name.compareTo(this.name) : num;
    }

    @Override
    public String country(String nation) {
        System.out.println("我是"+nation+"人");
        return nation;
    }
}
