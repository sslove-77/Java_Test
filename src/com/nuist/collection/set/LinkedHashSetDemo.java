/** LinkedHashSet 底层数据为链表，并结合了哈希表
 * 链表保证数据存储有序，哈希表保证数据唯一
* */
package com.nuist.collection.set;

import com.nuist.classfile.Person;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
//        创建对象
        LinkedHashSet<Person> linkedHashSet = new LinkedHashSet<>();
//        添加元素
        linkedHashSet.add(new Person("ss",29,'M'));
        linkedHashSet.add(new Person("qq",27,'F'));
        linkedHashSet.add(new Person("ss",28,'M'));
        linkedHashSet.add(new Person("qq",27,'F'));

//        遍历元素
        for (Person p : linkedHashSet) {
            System.out.println(p.getName()+"--"+p.getSex()+"--"+p.getAge());
        }
    }
}
