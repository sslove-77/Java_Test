/** 方法引用
 * 当要传递给lambda体的操作已经有实现的方法时，可以使用方法引用
*/
package com.nuist.newproperty;

import com.nuist.classfile.Person;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionReferenceTest {
    @Test
    public void test() {
//        Consumer中的accept方法，PrintStream中的println方法
//        lambda表达式
        Consumer<Integer> cons1 = num -> System.out.println(num);
        cons1.accept(100);

//        Consumer中的accept方法，PrintStream中的println方法
//        方法引用  对象::方法名
        PrintStream ps = System.out;
        Consumer<String> cons2 = ps::println;
        cons2.accept("hello,java");
        System.out.println("----------------------");
    }

    @Test
    public void test2() {
//        Supplier中的get方法，Person中的getName方法
//        lambda表达式
        Person p = new Person("Helen", 27, 'M');
        Supplier<String> sup2 = () -> p.getName();
        System.out.println(sup2.get());

//         Supplier中的get方法，Person中的getAge方法
//        方法引用
        Supplier<Integer> sup3 = p::getAge;
        System.out.println(sup3.get());
        System.out.println("-----------------------");
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(10,20));
    }

    @Test
    public void test4() {
//        lambda表达式
        Function<Double, Long> func = aDouble -> Math.round(aDouble);
        System.out.println(func.apply(4.5));

        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(-2.4));
    }
}
