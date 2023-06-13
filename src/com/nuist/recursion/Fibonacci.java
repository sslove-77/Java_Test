/** 斐波那契数列  1,1,2,3,5,8,13...
 * 递归实现，a = 1, b = 1, a = b, b = a+b,...
 */
package com.nuist.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    private static int fib(int num) {
        //    初始值
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }
}
