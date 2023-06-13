/** Set接口的直接子类有 HashSet，TreeSet，LinkedHashSet
 * HashSet 底层数据结构为哈希表，哈希表是元素为链表的数组，结合了链表和数组的特性

 * HashSet的方法基本和 list相同
 * add()方法实现元素唯一的条件：
     先比较hashCode，
    1. 如果不等，则不是同一个值，添加
    2. 如果相等，再比较equals
        A. 值相等则为同一个值，不添加
        B. 值不等，则添加

    * 集合存储不同类型的元素时，必须重写hashCode()和equals()方法
* */
package com.nuist.collection.set;

import com.nuist.classfile.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    @Test
    public void setTest() {
//        创建set对象，唯一，无序的集合
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("python");
        set.add("mysql");
        System.out.println(set);

        System.out.println(set.remove("python"));

        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("Helen", 29, 'F'));
        personSet.add(new Person("Peter", 27, 'M'));
        personSet.add(new Person("Mary", 25, 'F'));
        personSet.add(new Person("Helen", 29, 'F'));

        for (Person p : personSet) {
            System.out.println(p.getName() + "\t" + p.getAge());
        }
    }
}
