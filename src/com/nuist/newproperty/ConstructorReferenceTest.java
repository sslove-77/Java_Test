/** 构造器引用
*/
package com.nuist.newproperty;

import com.nuist.classfile.Employee;
import com.nuist.classfile.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceTest {
    @Test
//    Supplier中的get方法，Employee的构造方法
    public void test() {
        Supplier<Employee> sup = () -> new Employee();
        System.out.println(sup.get());

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    @Test
    public void test2() {
//        Function中的 R apply(T t),
        Function<String, Employee> func = (str) -> new Employee(str);
        System.out.println(func.apply("Helen"));

        Function<String, Employee> func2 = Employee::new;
        System.out.println(func2.apply("Peter"));
    }

    @Test
    public void test3() {
//        BiFunction中 R apply(T t, U u)
        BiFunction<String, Integer, Employee> bif = (name, age) -> new Employee(name, age);
        System.out.println(bif.apply("Helen", 27));

        BiFunction<String, Integer, Employee> bif2 = Employee::new;
        System.out.println(bif2.apply("Mary", 24));
    }

    @Test
//    数组引用
    public void test4() {
        Function<Integer, int[]> function = (length) -> new int[length];
        int[] arr = function.apply(10);
        for (int i : arr) {
            System.out.print(i+"\t");
        }
        System.out.println("----------------");

        Function<Integer, int[]> function2 = int[]::new;
        int[] arr2 = function2.apply(10);
        for (int i : arr2) {
            i += 2;
            System.out.print(i+"\t");
        }
    }
}
