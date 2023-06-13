/** HashMap的线程安全类为 ConcurrentHashMap
* */
package com.nuist.collection.thread_collection;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MyMapTest {
    public static void main(String[] args) {
        //        创建map对象
//        HashMap<String, String> map = new HashMap<>();

//        线程安全类
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        //        创建多个线程对象
        for (int i = 0; i < 20; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                map.put(key,UUID.randomUUID().toString());
                System.out.println(map);
            }).start();
        }
    }
}
