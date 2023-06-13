/** LinkedList底层数据为链表，存储有序，查询慢，增删快，线程不同步
 * 特有方法
 * addFirst(), addLast()
 * getFirst(), getLast()
 * 查找不删除 peek(), peekFirst(), peekLast()
 * 查找并删除 poll(), pollFirst(), pollLast()
 * 从堆栈中弹出元素 pop() , 压栈 push()
* */
package com.nuist.collection.list;

import com.nuist.classfile.Person;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {
//        创建集合对象
        LinkedList<Person> linkedList = new LinkedList<>();
//        添加元素
        linkedList.add(new Person("ss", 29, 'M'));
        linkedList.addFirst(new Person("qq", 27, 'F'));
        linkedList.add(new Person("fei", 27, 'F'));
        linkedList.addLast(new Person("lin", 26, 'F'));

//      查找任意位置对应元素
        Person p1 = linkedList.get(2);
        System.out.println("第三个人的信息为:"+p1.getName()+"--"+p1.getAge()+"--"+p1.getSex());
//        查找第一个索引元素
        Person p2 = linkedList.getFirst();
        System.out.println("第一个人的信息为:"+p2.getName()+"--"+p2.getAge()+"--"+p2.getSex());
//        查找最后一个索引元素
        Person p3 = linkedList.getLast();
        System.out.println("最后一个人的信息为:"+p3.getName()+"--"+p3.getAge()+"--"+p3.getSex());

//      删除元素

        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.pollLast());

//      遍历
        for (Person person : linkedList) {
            System.out.println(person.getName()+"--"+person.getAge()+"--"+person.getSex());
        }

        System.out.println("-------------------------");

        ListIterator<Person> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            Person person = listIterator.next();
            System.out.println(person.getName()+"\t"+person.getAge());
        }

        while (listIterator.hasPrevious()) {
            Person person = listIterator.previous();
            System.out.println(person.getName()+"\t"+person.getAge());
        }
    }
}
