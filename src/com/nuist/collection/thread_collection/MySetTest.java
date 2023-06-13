/** HashSet是非线程安全的，用CopyOnWriteArraySet解决安全问题
* */
package com.nuist.collection.thread_collection;

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class MySetTest {
    public static void main(String[] args) {
//        创建集合对象
//        HashSet<String> set = new HashSet<>();

//        线程安全对象
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
//        创建多个线程对象
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString());
                System.out.println(set);
            }).start();
        }
    }
}
