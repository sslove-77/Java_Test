/** Integer类
    *
* */
package com.nuist.BasicTest;

import org.junit.Test;

public class IntegerTest {
    public static void main(String[] args) {

        System.out.println(Integer.max(10,20));   // 最大值
        System.out.println(Integer.min(10,20));   // 最小值
        System.out.println(Integer.bitCount(1000));  // 返回指定的int值的二进制补码二进制表示中的 int数。
        System.out.println(Integer.MAX_VALUE);  // 最大值
        System.out.println(Integer.toString(100));
        System.out.println(Integer.parseInt("100"));
        System.out.println(Integer.parseInt("100",8));
        System.out.println(Integer.compare(20,20));  // 大于为1，小于为-1，等于为0
        Integer x = 4;
        Integer y = 5;

        Integer i = Integer.decode("200");
        System.out.println(i);
        String s = Integer.toString(100);
        System.out.println(s);

//        取补码
        int i1 = Integer.reverse(123);
        System.out.println(i1);
     }

    @Test
    public void integerTest() {
        Integer i = 128;
        System.out.println(i.hashCode());
        System.out.println(i.equals(128));
        System.out.println(i.intValue());
//        System.out.println(i.compareTo(-90));  // 大于为1
//        System.out.println(i.compareTo(128));  // 等于为0
//        System.out.println(i.compareTo(200));  // 小于为1

        System.out.println(Integer.parseInt("17329"));
        System.out.println(Integer.compare(100, -201));
        System.out.println(Integer.valueOf("237878"));
        System.out.println(Integer.reverseBytes(100));

    }
}
