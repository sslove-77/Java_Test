/** Collection为集合的基类，它包含list(有序，不唯一)，set(无序，唯一)，queue
 * List接口，具体实现类为ArrayList, LinkedList，Vector
 *  ArrayList底层数据结构是数组，查询快，增删慢，非线程同步

 * List集合的方法
 * void	add(int index, E element): 在此列表中的指定位置插入指定的元素。
 * boolean	addAll(int index, Collection c)：将指定集合中的所有元素插入到此列表中，从指定的位置开始。
 * E get(int index): 返回此列表中指定位置的元素。
 * E	remove(int index)：删除该列表中指定位置的元素（可选操作）。
 * E	set(int index, E element)：用指定的元素（可选操作）替换此列表中指定位置的元素。
 * List<E>	subList(int fromIndex, int toIndex)：返回此列表中指定的 fromIndex （含）和 toIndex之间的视图。
 * ListIterator	listIterator()： 返回列表中的列表迭代器（按适当的顺序）。，可以逆向遍历，但是必须先正向遍历后才能使用
 * ListIterator	listIterator(int index)： 从列表中的指定位置开始，返回列表中的元素（按正确顺序）的列表迭代器。
 * default void	replaceAll(UnaryOperator<E> operator)：将该列表的每个元素替换为将该运算符应用于该元素的结果。
 * default void	sort(Comparator<? super E> c)：使用随附的 Comparator排序此列表来比较元素。
 * */

/** 泛型：是一种把类型明确的工作推迟到创建对象或调用方法时才明确的数据类型，相当于传参
 * 格式： <引用类型>
 * 好处：
 * 把运行时期的问题提前到了编译时期
 * 避免强制类型转换
 * 优化程序设计，解决黄色警告线

 * 泛型类，在类定义时加上 <引用类型>，如public class Student<T>{}
 * 泛型方法，定义如 public <T> void show(T t){}
 * */
package com.nuist.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
//        创建集合对象
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = new ArrayList<>();
//        添加元素
        arrayList.add("杭州");
        arrayList.add("上海");
        arrayList.add("北京");

//        将集合添加到集合
        list.addAll(arrayList);
        list.add("广州");

//      集合长度
        System.out.println("list集合长度为："+list.size());

        //        是否为空
        System.out.println("数组是否为空:"+arrayList.isEmpty());

//        判断是否包含某个元素
        boolean b = list.contains("合肥");
        System.out.println("list是否包含合肥:"+b);
//        全部包含才为true
        boolean b2 = arrayList.containsAll(list);
        System.out.println(b2);

//        获取元素
        System.out.println(list.get(2));
//        获取指定长度的元素
        System.out.println(list.subList(0,3));

//        查找
        System.out.println(list.indexOf("上海"));

//        替换元素
        System.out.println(list.set(2,"beijing"));

//        删除元素remove
//        arrayList.remove("杭州");
//        list.removeAll(arrayList);

//        将集合转换为数组
        Object[] obj = list.toArray();
        for (Object o : obj) {
            System.out.println(o);
        }

//        遍历集合元素，使用迭代器
//        Iterator<String> iter = list.listIterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println("---------------------------");
//        增强for遍历
//        for (String val : list) {
//            System.out.println(val);
//        }

    }

    @Test
    public void test1() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("张三");
        arrayList.add("张三三");
        arrayList.add("李四");
        arrayList.add("张三四");

//        方式1：结果不正确
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).startsWith("张")) {
                arrayList.remove(i);
                i--;
            }
        }
        System.out.println(arrayList);
    }

    @Test
    public void test2() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("张三");
        arrayList.add("张三三");
        arrayList.add("李四");
        arrayList.add("张三四");

        //      方式3：  删除所有姓张的
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.startsWith("张")) {
                iterator.remove();
            }
        }
        System.out.println(arrayList);

    }

    @Test
    public void listTest() {
//        创建集合对象
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2020);
//        使用了泛型，必须用指定的类型才可，否则报错。
//        arrayList.add("java");
        arrayList.add(77);
        arrayList.add(51);
        int size = arrayList.size();
        System.out.println("集合长度为"+size);
//        直接输出
        System.out.println(arrayList);
//        获取某个位置元素
        System.out.println(arrayList.get(2));
//        转换成数组元素遍历
        for (Object o : arrayList.toArray()) {
            System.out.println(o);
        }

        System.out.println(arrayList.indexOf(77));
        System.out.println(arrayList.isEmpty());

    }
}
