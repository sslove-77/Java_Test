/** 排序：
 * Stream<T>	sorted()
 返回由此流的元素组成的流，根据自然顺序排序。
 * Stream<T>	sorted(Comparator<? super T> comparator)
 返回由该流的元素组成的流，根据提供的 Comparator进行排序。

 单元测试：
 1. 类必须是public，单元测试方法必须为public，无返回值，无参数
 2. 必须加上注解 @Test
 3. 导入包 import org.junit.Test;
* */
package com.nuist.newproperty;

import com.nuist.classfile.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamSortedTest {
    @Test
    public void sortedTest() {
//        创建集合对象
        ArrayList<String> stringArrayList = new ArrayList<>();
//        添加元素
        stringArrayList.add("python");
        stringArrayList.add("hello");
        stringArrayList.add("java");

//        排序
        stringArrayList.stream().sorted().forEach(System.out::println);
        System.out.println("--------------------------");

//        创建对象集合
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("ss", 29));
        employeeArrayList.add(new Employee("lin", 26));
        employeeArrayList.add(new Employee("qq", 27));
        employeeArrayList.add(new Employee("fei", 27));

//        排序，对象要实现排序必须实现Comparable接口的compareTo方法
        employeeArrayList.stream().sorted().forEach(System.out::println);
        System.out.println("-----------------------");
    }

    @Test
    public void sortedComparator() {
//        创建对象
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("ss", 29));
        employeeArrayList.add(new Employee("lin", 26));
        employeeArrayList.add(new Employee("qq", 27));
        employeeArrayList.add(new Employee("fei", 27));

//        排序，年龄从小到大，姓名从小到大
        employeeArrayList.stream().sorted(Comparator.comparingInt(Employee::getAge).
                thenComparing(Employee::getName)).forEach(System.out::println);
    }

}
