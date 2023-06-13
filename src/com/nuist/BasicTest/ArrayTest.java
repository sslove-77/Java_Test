package com.nuist.BasicTest;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
//      创建一维数组
        int[] arr = {234, 523, 654, 24, 5, 6, 42, 3784};
//        排序
        Arrays.sort(arr);
        for (int num:
             arr) {
            System.out.print(num+"\t");
        }
        System.out.println();
//      二分查找
        int i = Arrays.binarySearch(arr, 556);
        int j = Arrays.binarySearch(arr, 2, 5, 42);
        System.out.println(i);
        System.out.println(j);

//        二维数组
        String[][] str = new String[2][];
        str[0] = new String[]{"hello", "world"};
        str[1] = new String[]{"ss", "and", "qq"};
        for (String[] row: str) {
            for (String s : row) {
                System.out.print(s+"\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        int[] a = new int[4];
        int[] b = new int[]{0, 1};
//        遍历
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }

    @Test
    public void test2() {
        String[][] s = new String[3][];

        s[0] = new String[]{"java", "python", "c++"};
        s[1] = new String[]{"vue","css"};
        s[2] = new String[]{"hadoop", "hive", "hdfs"};

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j]+"\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test3() {
        int num = 10;
        int[][] arr = new int[num][num];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
