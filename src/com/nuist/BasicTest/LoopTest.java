/** 输出1000以内的水仙花数，水仙花数是指即各个位上的数的立方之和等于它本身的三位数，
 * 如 153 = 1+5*5*5+3*3*3
* */
package com.nuist.BasicTest;

import java.util.ArrayList;
import java.util.List;

public class LoopTest {
    public static void main(String[] args) {
//        for循环实现
        flowerNumber();
        System.out.println();

//      while循环实现
        flowerNumber2();
    }

    private static void flowerNumber2() {
//        计数器
        int counter2 = 0;
//        初始值
        int num = 100;
//        定义集合
        List<Integer> list = new ArrayList<>();

        while (num < 1000) {
            int ge = num % 10;
            int shi = (num / 10) % 10;
            int bai = (num / 100) % 10;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == num) {
                list.add(num);
                counter2++;
            }
            num++;
        }
        System.out.println("水仙花数总共有"+counter2+"个");
        System.out.println("他们分别是：");
        for (Integer i : list) {
            System.out.print(i+"\t");
        }
    }

    private static void flowerNumber() {
//        定义计数器
        int counter = 0;
//        定义集合存储水仙花数
        ArrayList<Integer> arrayList = new ArrayList<>();
//        定义变量范围
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = (i / 10) % 10;
            int bai = (i / 100) % 10;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                arrayList.add(i);
                counter++;
            }

        }
        System.out.println("水仙花数总共有"+counter+"个");
        System.out.println("他们分别是：");
        for (Integer i : arrayList) {
            System.out.print(i+"\t");
        }
    }
}
