/** Map映射：
    * <R> Stream<R>	map(Function<? super T,? extends R> mapper)
        返回由给定函数应用于此流的元素的结果组成的流。
    * DoubleStream	mapToDouble(ToDoubleFunction<? super T> mapper)
        返回一个 DoubleStream ，其中包含将给定函数应用于此流的元素的结果。
    * IntStream	mapToInt(ToIntFunction<? super T> mapper)
        返回一个 IntStream ，其中包含将给定函数应用于此流的元素的结果。
    * LongStream	mapToLong(ToLongFunction<? super T> mapper)
         返回一个 LongStream ，其中包含将给定函数应用于此流的元素的结果。

    * <R> Stream<R>	flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
        返回由通过将提供的映射函数应用于每个元素而产生的映射流的内容来替换该流的每个元素的结果的流。

    * T	reduce(T identity, BinaryOperator<T> accumulator)
        使用提供的身份值和 associative累积功能对此流的元素执行 reduction ，并返回减小的值。
    * <U> U	reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        执行 reduction在此流中的元素，使用所提供的身份，积累和组合功能。
*/
package com.nuist.newproperty;

import com.nuist.classfile.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapreduceTest {
    ArrayList<Employee> employeeList = Employee.getEmp();
    @Test
    public void mapTest() {
        Stream<Employee> employeeStream = employeeList.stream();
//      调用map方法，实现年龄减2
//        employeeStream.map(employee -> employee.getAge() - 2).
//                forEach(System.out::println);
        employeeStream.mapToInt(Employee::getAge).map(operand -> operand-2).
                forEach(System.out::println);
        System.out.println("-----------------");

    }

    @Test
    public void mapTest2() {
        Stream<Employee> employeeStream = employeeList.stream();
//      调用map方法，找出姓名长度等于2的学生名字
        employeeStream.map(Employee::getName)
                .filter(name -> name.length() == 2).forEach(System.out::println);
        System.out.println("--------------------");
    }

    @Test
    public void reduceTest() {
//        计算年龄的和
//        T	reduce(T identity, BinaryOperator<T> accumulator)
        Integer ageSum = employeeList.stream().map(Employee::getAge).
                        reduce(0,Integer::sum);
        System.out.println(ageSum);
        System.out.println("------------------------");

//        计算工资之和
//        T	reduce(BinaryOperator<T> accumulator)
        Optional<Double> salarySum = employeeList.stream().map(Employee::getSalary).
                                            reduce(Double::sum);
        System.out.println(salarySum);
    }

    @Test
    public void collectTest() {
//        <R,A> R	collect(Collector<? super T,A,R> collector)
//使用 Collector对此流的元素执行 mutable reduction Collector 。
//        找出所有工资大于20的员工，将结果存到集合中
        List<Employee> collect = employeeList.stream().filter(em -> em.getSalary() > 20).
                                        collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
