package com.nuist.classfile;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Employee implements Comparable<Employee> {

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
        this.name = name;
        this.age = age;
    }

//      带参构造3
    public Employee(String name, int age, String career) {
        this.name = name;
        this.age = age;
        this.career = career;
    }

    public Employee(String name, int age, String career, double salary) {
        this.name = name;
        this.age = age;
        this.career = career;
        this.salary = salary;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getCareer() {
//        return career;
//    }
//
//    public void setCareer(String career) {
//        this.career = career;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }

    //    成员方法
    public void printObj(Object obj) {
        System.out.println(obj);
    }

//    成员方法2
    public void show() {
        System.out.println("show");
    }
//      成员方法3
    private Integer sum(int a, int b) {
        return a + b;
    }

    private void working() {
        System.out.println("员工应该爱岗敬业");
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
}
