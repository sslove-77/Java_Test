package com.nuist.thread.synchronize.colletcion;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Helen
 * @date 2023-02-20 22:39
 */
public class CollectionSecurityTest {
    public static void main(String[] args) {
//        创建集合
//        ArrayList<String> list = new ArrayList<>();

//        Vector<String> list = new Vector<>();

//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }

    }
}
