package com.nuist.collection.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.printT("hello,java");
        System.out.println(genericMethod.toList(3,5,6,7,8));
        System.out.println(genericMethod.toList("susu", "love", "qiiq"));

    }

    @Test
    public void test() {
        List<String> string = new ArrayList<>();
        List<Number> number = new ArrayList<>();
        List<Integer> integer = new ArrayList<>();

        string.add("hello");
        number.add(2189);
        integer.add(2787);

//      GenericMethod.getObj(string);            报错
        GenericMethod.getObj(number);
        GenericMethod.getObj(integer);

        GenericMethod.getObj2(number);
//        GenericMethod.getObj2(integer);  //报错

        List<? extends Number> list = null;
        List<? super Number> list1 = null;

        List<Number> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        list = list2;
        list = list3;

        list1 = list2;
//        list1 = list3;  // 报错，必须是父类


    }

}
