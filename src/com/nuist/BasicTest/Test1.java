package com.nuist.BasicTest;

import java.util.Arrays;

public class Test1 {
    //    定义静态变量、成员变量
    public static final int NUM = 10;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
//
        Test1 test1 = new Test1();
        test1.setName("helen");
        System.out.println(test1.getName());
        System.out.println(NUM);
        System.out.println();
        int[] arr = new int[]{23, 57, 42, 576, 15, 67, 3617, 43, 3, 6};
        System.out.println("排序前的数组为");
        for (int n : arr) {
            System.out.print(n + "\t");
        }
        System.out.println();
        System.out.println("排序后的数组为");
        bubble(arr);
        System.out.println();
        optionalRank(arr);
        System.out.println();
        System.out.println(sum(1,2,3,4,5,6));
        show(100);
        show("银从必过");

        Arrays.sort(arr);
//        for (int i:
//             arr) {
//            System.out.print(i+" ");
//        }
        System.out.println(Arrays.binarySearch(arr, 15));
        System.out.println(he(2,4,5,6));
    }

    /**
    冒泡排序法：数组有n个数据，总共比较n-1轮，第i轮比较n-i次，两两比较，大值放在右边，
     第一轮最大值在最右边，第二轮第二大值在倒数第二位置，以此类推
     */

    public static void bubble(int[] number) {
        for (int i = 0; i < number.length-1; i++) {
            for (int j = 0; j < number.length - 1 - i; j++) {
                if (number[j] > number[j + 1]) {
                    int temp = number[j + 1];
                    number[j + 1] = number[j];
                    number[j] = temp;
                }
            }
        }

        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + "\t");
        }
    }

    /** 选择排序法:比较n-1轮，第i轮比较n-i次，第1轮第一个值与后面的值依次比较，
     * 最小的放在第一个位置，第一轮最小值在最左边，依次类推
     */
    public static void optionalRank(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+"\t");
        }
    }

//    可变参数相当于数组，int ... num,String ... str
    public static int sum(int ... num) {
        int s = 0;
        for (int i:num
             ) {
            s += i;
        }
        return s;
    }
//      方法重载
    public static void show(int num) {
        System.out.println(num);
    }

    public static void show(String str) {
        System.out.println(str);
    }

    public static int he(int ... s) {
        int sum = 0;
        for (int i : s) {
            sum += i;
        }
        return sum;
    }
}
