package com.nuist.Enum;

public class MyEnumTest {
    public static void main(String[] args) {
        MyEnum myEnum = MyEnum.NORTH;
        System.out.println(myEnum.name());
        myEnum.show();
        System.out.println(myEnum);

        System.out.println(myEnum.ordinal());

    }
}