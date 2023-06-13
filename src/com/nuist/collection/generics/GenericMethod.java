package com.nuist.collection.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {

    public <T> void printT(T t) {
        System.out.println(t);
    }

    public <T> List<T> toList(T... arr) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t : arr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public static void getObj(List<? extends Number> list) {
        System.out.println(list.get(0));
    }

    public static void getObj2(List<? super Number> list) {
        System.out.println(list.get(0));
    }

}
