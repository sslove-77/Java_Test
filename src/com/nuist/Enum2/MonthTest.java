package com.nuist.Enum2;

public class MonthTest {
    public static void main(String[] args) {
//        创建枚举对象
        Month month = Month.JULY;
        System.out.println(month);   // JULY
        System.out.println(month.name());  // JULY
        System.out.println(month.getName());   // 七月
        System.out.println("----------------");

//      修改名字
        month = Month.JANUARY;
        System.out.println(month.getName());
        month.show();
        System.out.println("----------------");

//        再次修改
        Month mon = Month.valueOf(Month.class, "JUNE");
        mon.show();
    }
}