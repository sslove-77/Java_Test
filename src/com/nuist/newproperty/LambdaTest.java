/** Lambda表达式的用法   (参数) -> {方法体}
 * 方法说明：
    * -> : lambda操作符
    * (参数) : 形参列表，就是抽象方法的形参
    * 方法体： 抽象方法的方法体
 * 用法说明：
    * 若只有1个参数，()可以省略
    * 方法体若只有一个输出语句或者return语句，{}或者return可以省略
*/

package com.nuist.newproperty;

import org.junit.Test;

import java.util.Comparator;

public class LambdaTest {
    @Test
    public void lambda() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("大数据学习");
            }
        };
        runnable.run();
        System.out.println("---------------");

        //    lambda实现
        Runnable r2 = () -> System.out.println("Hadoop框架");
        r2.run();
        System.out.println("----------------");
    }

    @Test
    public void lambda2() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(comparator.compare(20, 10));

//        lambda表达式实现
        Comparator<Integer> comparator1 = (num1, num2) -> Integer.compare(num1, num2);

//        方法引用  数据类型::方法名
        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator1.compare(10, 20));
        System.out.println(comparator2.compare(10,20));
    }

}
