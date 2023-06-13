/** 自然排序法
* */
package com.nuist.map;

import com.nuist.classfile.Person;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo2 {
    public static void main(String[] args) {
//        创建对象
        TreeMap<Person, String> personTreeMap = new TreeMap<>();
        //        创建Person对象
        Person p1 = new Person("ss",29,'M');
        Person p2 = new Person("qq",27,'F');
        Person p3 = new Person("xin",26,'M');
        Person p4 = new Person("lin",26,'F');
        Person p5 = new Person("qq",25,'F');
        Person p6 = new Person("xin",26,'F');

//        添加元素
        personTreeMap.put(p1,"java");
        personTreeMap.put(p2,"python");
        personTreeMap.put(p3,"c");
        personTreeMap.put(p4,"c++");
        personTreeMap.put(p5,"go");
        personTreeMap.put(p6,"php");

//        遍历
        Set<Person> personSet = personTreeMap.keySet();
        for (Person person : personSet) {
            String name = personTreeMap.get(person);
            System.out.println(person.getName()+"--"+person.getAge()+"--"+person.getSex()+"--"+name);
        }
    }
}
