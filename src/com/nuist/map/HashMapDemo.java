/** Map<K, V> 是键值对的组合，键必须唯一，值可重复，Map集合的数据结构只针对键，与值无关。
 * 其主要实现类有HashMap，TreeMap
 * 方法：
 添加：
 * V	put(K key, V value)： 将指定的值与该映射中的指定键相关联（可选操作）
 * void	putAll(Map<? extends K,? extends V> m)：将指定地图的所有映射复制到此映射
 删除
 * V	remove(Object key)：如果存在（从可选的操作），从该地图中删除一个键的映射
 * default boolean	remove(Object key, Object value)： 仅当指定的密钥当前映射到指定的值时删除该条目并判断
 * void	clear()： 从该地图中删除所有的映射（可选操作）

 * boolean	containsKey(Object key)： 如果此映射包含指定键的映射，则返回 true
 * boolean	containsValue(Object value)： 如果此地图将一个或多个键映射到指定的值，则返回 true
 获取
 * Set<Map.Entry<K,V>>	entrySet()： 返回此地图中包含的映射的Set视图。
    * getKey(),getValue()方法与上面配套

 * Set<K>	keySet()： 返回此地图中包含的键的Set视图
 * V	get(Object key)： 返回到指定键所映射的值，或 null如果此映射包含该键的映射

 * Collection<V>	values()： 返回此地图中包含的值的Collection视图
 替换
 * default V	replace(K key, V value)：只有当目标映射到某个值时，才能替换指定键的条目。
 * default boolean	replace(K key, V oldValue, V newValue)： 仅当当前映射到指定的值时，才能替换指定键的条目。
* */
package com.nuist.map;

import com.nuist.classfile.Person;
import org.junit.Test;

import java.util.*;

public class HashMapDemo {

    @Test
    public void mapTest() {
//        创建Map对象
        HashMap<String, Person> personMap = new HashMap<>();

        /**
         * HashMap键值可以为空，但值不能为空；Hashtable键和值均不能为空
         */
        personMap.put(null, new Person("Helen", 27, 'F'));
//        personMap.put("Beijing", null);  // 报错NullPointerException
        personMap.put("Shanghai", new Person("Helen", 27, 'F'));
        personMap.put("Hangzhou", new Person("Su", 29, 'M'));
        personMap.put("Hefei", new Person("Wen", 27, 'M'));
        personMap.put("Hangzhou", new Person("Qi", 27, 'F'));  //会覆盖前面相同key值的数据

        Set<String> keySet = personMap.keySet();
        for (String s : keySet) {
            Person person = personMap.get(s);
            System.out.println(s+":"+ person.getName()+"\t"+ person.getAge());
        }
        System.out.println("-----------------------------");

//        Hashtable对象
        Hashtable<String, Person> hashtable = new Hashtable<>();
//        hashtable.put(null, new Person("Helen", 27, 'F'));   // NullPointerException
//        hashtable.put("Beijing", null);   // NullPointerException
        hashtable.put("Shanghai", new Person("Helen", 27, 'F'));
        hashtable.put("Hangzhou", new Person("Su", 29, 'M'));
        hashtable.put("Wuxi", new Person("Lin", 26, 'F'));

        Set<String> stringSet = hashtable.keySet();
        for (String s : stringSet) {
            Person person = hashtable.get(s);
            System.out.println(s+":"+ person.getName()+"\t"+ person.getAge());
        }
        System.out.println("-------------------------");

//        Properties对象
        Properties properties = new Properties();
        properties.put("Shanghai", "Helen");
        properties.put("Hangzhou", "Su");

        Set<Object> objects = properties.keySet();
        for (Object o : objects) {
            String s = properties.getProperty((String) o);
            System.out.println(o+":"+ s);
        }
    }

    @Test
    public void treeMapTest() {

        //        TreeMap对象
        TreeMap<String, Person> treeMap = new TreeMap<>();
        treeMap.put("Shanghai", new Person("Helen", 27, 'F'));
        treeMap.put("Hangzhou", new Person("Su", 29, 'M'));
        treeMap.put("Wuxi", new Person("Lin", 26, 'F'));
        treeMap.put("Hefei", new Person("Wen", 27, 'M'));

        Set<String> strings = treeMap.keySet();
        for (String s : strings) {
            Person person = treeMap.get(s);
            System.out.println(s+":"+ person.getName()+"\t"+ person.getAge());
        }
    }
}
