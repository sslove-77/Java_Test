/** TreeSet 能实现集合的排序
 * 两种排序方式：
 * 自然排序：默认无参构造方法，对象必须实现Comparable接口
 * 比较器排序：带参构造方法，接收一个比较器接口Comparator实现其compareTo方法，对象具有比较性
 * 需求：实现Person的自然排序，按照年龄从低到高，姓名字母小到大，性别排序
* */
package com.nuist.collection.set;

import com.nuist.classfile.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
//        创建对象
        TreeSet<String> names = new TreeSet<>();
        names.add("helen");
        names.add("lin");
        names.add("ss");
        names.add("yan");
        names.add("peter");

//        遍历数据，默认按照字母顺序输出
        for (String s : names) {
            System.out.println(s);
        }
        System.out.println("+++++++++++++++++++++++++++");

//      集合元素为类对象时，无参构造实现自然排序
        TreeSet<Person> personTreeSet = new TreeSet<>();
//        创建Person对象
        Person p1 = new Person("ss",29,'M');
        Person p2 = new Person("qq",27,'F');
        Person p3 = new Person("xin",26,'M');
        Person p4 = new Person("lin",26,'F');
        Person p5 = new Person("qq",25,'F');
        Person p6 = new Person("xin",26,'F');

//        将元素添加到集合
        personTreeSet.add(p1);
        personTreeSet.add(p2);
        personTreeSet.add(p3);
        personTreeSet.add(p4);
        personTreeSet.add(p5);
        personTreeSet.add(p6);

//        遍历集合, 未实现Comparable接口会报异常：ClassCastException
        for (Person p : personTreeSet) {
            System.out.println(p.getName()+"--"+p.getAge()+"--"+p.getSex());
        }
    }

    @Test
    public void treeSetTest() {
//        Person继承Comparable接口，compareTo方法实现集合元素比较
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("Su",29,'M'));
        treeSet.add(new Person("Helen", 25, 'F'));
        treeSet.add(new Person("Su", 29, 'M'));
        treeSet.add(new Person("Su", 26, 'M'));

        for (Person p : treeSet) {
            System.out.println(p.getName()+"  "+p.getAge()+"  "+p.getSex());
        }

//
        TreeSet<Person> personTreeSet = new TreeSet<>(new Comparator<Person>() {
//            名字从小到大，年龄从小到大，性别从小到大
            @Override
            public int compare(Person p1, Person p2) {
                int n = p1.getName().compareTo(p2.getName());
                int n2 = (n == 0) ? (p1.getAge() - p2.getAge()) : n;
                return (n2 == 0) ? (Character.compare(p1.getSex(), p2.getSex())) : n2;
            }
        });

        personTreeSet.add(new Person("Su", 29, 'M'));
        personTreeSet.add(new Person("Helen", 26, 'F'));
        personTreeSet.add(new Person("Su", 24, 'M'));

        for (Person p : personTreeSet) {
            System.out.println(p.getName()+"\t"+p.getAge()+"\t"+p.getSex());
        }

    }
}
