/** LinkedHashMap底层数据结构为链表，故能实现存储有序
* */
package com.nuist.map;

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
//        创建对象
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
//        添加元素
        linkedHashMap.put("ss", 29);
        linkedHashMap.put("qq", 27);
        linkedHashMap.put("lin", 26);

//        遍历
        Set<String> set = linkedHashMap.keySet();
        for (String name : set) {
            System.out.println(name+"--"+linkedHashMap.get(name));
        }
    }
}
