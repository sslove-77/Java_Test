/** 杨辉三角: 每一行的数字个数与行数相等，第一列和最后一列数字为1，
            其他列数字为它上一行数字对应位置和后一位置的数字之和
    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1
    1 5 10 10 5 1
 需求：输入行数num，输出对应的杨辉三角
* */
package com.nuist.BasicTest;

public class YangHuiTriangle {
    public static void main(String[] args) {
//        输入给定的数字，输出对应的杨辉三角
        yangHui(10);
    }

    private static void yangHui(int num) {
//        定义数组
        int[][] arr = new int[num][num];
//        定义行数i，列数j
        for (int i = 0; i < num; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
//        第三行开始
        for (int i = 2; i < num; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
//        遍历数据
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
