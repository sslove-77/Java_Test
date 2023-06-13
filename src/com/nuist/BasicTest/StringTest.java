/** String, StringBuilder,StringBuffer的区别
 * String是长度不可变的字符串，StringBuilder/StringBuffer长度可变
 * StringBuilder非线程安全，效率高
 * StringBuffer线程安全，效率低

 * String构造方法
    * String s = new String("");
    * String s = "";
 * 常用方法：length(), charAt(int index), indexOf(char ch), subString(int start, int end)
 * getBytes(), toCharArray(), split(String s)

 *  StringBuilder构造方法
    * StringBuilder sb = new StringBuilder("");
    * StringBuilder sb = new StringBuilder(new String());
 * StringBuilder常用方法：
    * 增加数据 append(Object obj)，insert(int location, Object obj)
    * 删除数据 delete(int start, int end),deleteCharAt(int i)
*/
package com.nuist.BasicTest;

import org.junit.Test;

public class StringTest {
    @Test
    public void stringTest() {
//        String类的相关方法
        String str = new String("I and su will have a happy future");
        String str2 = "I and su will have a happy future";
        String str3 = str;

        System.out.println(str.equals(str2)+"\t"+str.equals(str3));  // true, true
        System.out.println((str == str2) + "\t" + (str == str3));    // false. true
        System.out.println(str.length()); // 字符串长度33
        char[] chars = str.toCharArray();
        for (char c : chars) {
            System.out.print(c + "");
        }
        System.out.println();
        System.out.println("----------------------------");

        System.out.println(str.startsWith("re")); // false
        System.out.println(str.indexOf("happy"));
        System.out.println(str.indexOf("happy", 6));
        for (byte aByte : str.getBytes()) {
            System.out.println(aByte);
        }
        System.out.println(str.charAt(10));
        String[] split = str.split(" ");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(str.replace("happy", "pleasant"));
        char[] ch = {'h', 'e', 'l', 'l', 'o'};
        str.getChars(10,15,ch,0);
        System.out.println(ch);
    }

    @Test
    public void stringBuilderTest() {
        StringBuilder stringBuilder = new StringBuilder("I love my mom");
        String str = "I love my mom";
        StringBuilder stringBuilder2 = new StringBuilder(100);
        stringBuilder2.append(str);
        stringBuilder2.append("\t hello");

        stringBuilder2.insert(14, "and su!");
        System.out.println(stringBuilder2.toString());
    }
}
