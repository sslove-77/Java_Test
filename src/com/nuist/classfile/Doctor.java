package com.nuist.classfile;

import lombok.Data;

import java.util.Objects;

@Data
public class Doctor implements Comparable<Doctor> {
    private String name;
    private int age;
    private int salary;

    public Doctor() {
    }

    public Doctor(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    //    成员方法
    public void working() {
        System.out.println("医生的工作是治病救人");
    }

    private void print(String s) {
        System.out.println(s);
    }

//    重写hashCode和equals方法

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return age == doctor.age && Double.compare(doctor.salary, salary) == 0 && Objects.equals(name, doctor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    @Override
    public int compareTo(Doctor d) {
        int s1 = this.age - d.age;
        int s2 = s1 == 0 ? this.name.length() - d.name.length() : s1;
        return s2 == 0 ? this.salary - d.salary : s2;
    }

}
