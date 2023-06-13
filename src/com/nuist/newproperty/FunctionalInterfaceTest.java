/**
 * 函数式接口：只有一个抽象方法的接口
 * 用匿名实现类表示的接口都可用lambda表达式表示，也可用方法引用表示
*/
package com.nuist.newproperty;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaceTest {
    @Test
    public void fun() {
        show(200, money -> System.out.println("商品的价格为"+money));
    }

    public void show(Integer num, Consumer<Integer> consumer) {
        consumer.accept(num);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "动静", "天津");
        List<String>  listFilter = filterString(list, s -> s.contains("京"));
        System.out.println(listFilter);
    }

    public List<String> filterString(List<String> list, Predicate<String> pred) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : list) {
            if (pred.test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
