package com.nuist.BasicTest;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Helen
 * @date 2023-02-10 15:33
 */
public class ArrayDemo {

    /**
     * 测试一维数组排序
     */
    @Test
    public void rankTest() {
        int[] arr = {29, 67, 10, -3, 7, 19, 45, 18, 25};
        int[] arr2 = {0, -4, 10, 8, -3, 7};
        int[] rankArr = rank(arr);
        int[] rankArr2 = rank(arr2);
        for (int val : rankArr) {
            System.out.print(val + "\t");
        }
        System.out.println("-----------------------");
        for (int val : rankArr2) {
            System.out.print(val + "\t");
        }
    }

    /**
     *  测试杨辉三角
     */

    @Test
    public void triangleTest() {
//        输入一个数字，输出杨辉三角
        int num = 10;
        int[][] triangleNum = yangTriangle(num);
        for (int i = 0; i < triangleNum.length; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print(triangleNum[i][j] + "\t");
            }
            System.out.println();
        }
    }


    @Test
    public void arraysTest() {

//        Arrays类的用法：排序
        int[] arr = {29, 67, 10, -3, 7, 19, 45, 18, 25};
        Arrays.sort(arr);
        for (int x : arr) {
            System.out.print(x + "\t");
        }
        System.out.println();
        System.out.println("--------------------------");

//       二分查找，查找成功返回正确的索引，否则返回其他数值
        System.out.println(Arrays.binarySearch(arr, 10));   // 查找成功
        System.out.println(Arrays.binarySearch(arr, -17));  // 查找失败
        System.out.println("--------------------------");

//        其他用法
        String s = Arrays.toString(arr);
        System.out.println(s);

    }


    /**
     * 冒泡排序法
     * @param arr
     */
    private int[] rank(int[] arr) {
//        总共比较n-1次，第1次比较n-1-1次，比较数值范围为arr[0]~arr[n-1-i]，两两比较，较大值放在右边，第一比较完最大值在最右边
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 杨辉三角
     * @param num
     */
    private int[][] yangTriangle(int num) {
//        定义二维数组存储数据
        int[][] arr = new int[num][num];

//        每行第一列和最后一列数据为1
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }

//        从第3行第2列开始，该列数据等于上一行对应列数据后一列数据之和
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j-1] + arr[i - 1][j];
            }
        }
        return arr;
    }

}
