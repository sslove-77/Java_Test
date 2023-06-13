package com.nuist.classfile;

import java.util.Objects;

public class Person implements Comparable<Person>{
//    定义姓名，年龄，性别
    private String name;
    private int age;
    private char sex;

//    无参构造方法
    public Person() {
    }
//    带参构造方法
    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

//    设置姓名，年龄，性别

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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

//    重写hashCode和equals方法

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && sex == person.sex && Objects.equals(name, person.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "Person{name = "+name+", age = "+age+", sex = "+sex+"}";
    }

    //    要想对象具备可比较性，必须重写compareTo方法
//    按照年龄从小到大，姓名首字母从小到大，性别从小到大排序
    @Override
    public int compareTo(Person p) {
        int num = -this.age+p.age;
        int num2 = (num == 0) ? this.name.length()-p.name.length() : num;
        return (num2 == 0) ? Character.compare(this.sex, p.sex) : num2;
    }

}
