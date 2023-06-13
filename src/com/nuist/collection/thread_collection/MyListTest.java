/** ArrayList是非线程安全类：多个线程并发会产生并发修改异常--ConcurrentModificationException
 * 解决方法：
    1. 用Vector
    2. 用Collections.synchronizedList
    3. 用CopyOnWriteArrayList
 */

package com.nuist.collection.thread_collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyListTest {
    public static void main(String[] args) {
//        创建集合对象
//        ArrayList<String> arrayList = new ArrayList<>();
//        方法一：用Vector
//        Vector<String> arrayList = new Vector<>();

//        方法二，用Collections
//        List<String> arrayList = Collections.synchronizedList(new ArrayList<String>());

//        方法三：用CopyOnWriteArrayList
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
//        创建多个线程对象
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                arrayList.add(UUID.randomUUID().toString());
                System.out.println(arrayList);
            }).start();
        }
    }
}
