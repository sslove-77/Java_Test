/** Vector 底层数据为数组，线程同步，查询快，增删慢
 * Vector特有方法
 * 添加元素：addElement()
 * 查找元素：firstElement(), LastElement()
 * 删除元素：removeElement(String s), removeElementAt(int index)
 * 枚举：Enumeration<E> elements(),方法有hasMoreElements(), nextElement()
 注意：枚举方法被迭代器替代，后用的多的还是增强for
* */
package com.nuist.collection.list;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
//        创建集合对象
        Vector<String> vector = new Vector<>();
//        添加元素
        vector.add("hello");
        vector.addElement("java");
        vector.addElement("hadoop");
        vector.addElement("java");
        vector.addElement("hadoop");

//        查找指定位置元素
        System.out.println(vector.get(2));
        System.out.println(vector.elementAt(2));
        System.out.println("-----------------");
//        第一个和最后一个位置元素
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
        System.out.println("-----------------");
//        查找元素索引
        System.out.println(vector.lastIndexOf("hadoop"));
        System.out.println(vector.indexOf("java"));
        System.out.println("--------------");

//        枚举方法
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        System.out.println("--------------");

//        for循环遍历
        for (String ele : vector) {
            System.out.println(ele);
        }
    }

    @Test
    public void vectorTest() {
//        创建Vector对象
        Vector<String> vector = new Vector<>();
//        添加元素
        vector.add("su");
        vector.add("love");
        vector.add("qi");
        vector.add("forever");

        System.out.println(vector.size());
        vector.addElement("and");
        vector.addElement("never");
        vector.addElement("change");
        System.out.println(vector.size());

        System.out.println(vector.get(3));
        System.out.println(vector.indexOf("qi"));
        System.out.println(vector.remove(4));
        System.out.println(vector.removeElement("never"));
        vector.removeElementAt(4);
        System.out.println(vector);

        Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }
}
