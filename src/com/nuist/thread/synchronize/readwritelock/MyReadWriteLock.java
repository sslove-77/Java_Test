/** 向集合中读写数据
*/
package com.nuist.thread.synchronize.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyReadWriteLock {
    //    创建map集合对象
    private Map<String, Object> map = new HashMap<>();
    //    创建读写锁对象
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

//    写数据
    public void write(String key, Object value) {
//        获取写锁
        readWriteLock.writeLock().lock();

        try {

            System.out.println(Thread.currentThread().getName()+"正在写数据.."+key);

            map.put(key, value);
//            暂停2毫秒
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"写完"+key);

        }finally {
//            释放锁
            readWriteLock.writeLock().unlock();
        }
    }

//    读数据
    public Object read(String key) {
//        获取锁
        readWriteLock.readLock().lock();

        try {

            System.out.println(Thread.currentThread().getName()+" 正在读数据.."+key);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }finally {

//            释放锁
            readWriteLock.readLock().unlock();
        }
        return map.get(key);
    }
}
