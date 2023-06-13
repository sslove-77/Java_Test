/**  Hashtable与HashMap的区别：
 *  Hashtable：线程安全，不允许null键和null值
 *  HashMap：非线程安全，允许null键和null值

 * List，Set，Map等接口是否都继承自Map接口？
 * List和Set继承自Collection接口
 * Map接口本身就是顶层接口
* */
package com.nuist.map;

import com.nuist.classfile.Person;

import java.util.Hashtable;
import java.util.Set;

public class HashtableDemo {
    public static void main(String[] args) {
//        创建对象
        Hashtable<String, Person> hashtable = new Hashtable<>();
//        添加元素，键和值不能为null值，报异常NullPointerException
        hashtable.put(null, new Person("qq", 25, 'F')); //NullPointerException
        hashtable.put("it", null); // NullPointerException
        hashtable.put("hello", new Person("qq", 25, 'F'));
        hashtable.put("java", new Person("ss", 27, 'M'));

//        遍历元素
        Set<String> keySet = hashtable.keySet();
        for (String key : keySet) {
            Person p = hashtable.get(key);
            System.out.println(key+":"+p.getName()+"--"+p.getAge()+"--"+p.getSex());
        }
    }
}
