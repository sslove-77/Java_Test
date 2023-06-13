/** TreeMap 能实现排序，唯一
 * 排序方法：
 * 自然排序：用无参构造方法，修改hashCode和equals方法，修改
 * 比较器排序： 继承 Comparator接口，重写compare方法
* */
package com.nuist.map;

import com.nuist.classfile.Person;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
//        创建对象
        TreeMap<String, Person> personTreeMap = new TreeMap<>();
//        创建Person对象
        Person p1 = new Person("ss",29,'M');
        Person p2 = new Person("qq",27,'F');
        Person p3 = new Person("xin",26,'M');
        Person p4 = new Person("lin",26,'F');
        Person p5 = new Person("qq",25,'F');
        Person p6 = new Person("xin",26,'F');

//        添加元素到map对象
        personTreeMap.put("java",p1);
        personTreeMap.put("python",p2);
        personTreeMap.put("c++",p3);
        personTreeMap.put("c",p4);
        personTreeMap.put("go",p5);
        personTreeMap.put("php",p6);

//        遍历，默认按照键排序
        Set<String> coding = personTreeMap.keySet();
        for (String s : coding) {
            Person p = personTreeMap.get(s);
            System.out.println(s+" : "+p.getName()+"--"+p.getAge()+"--"+p.getSex());
        }

    }
}
