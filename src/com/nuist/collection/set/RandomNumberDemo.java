/** 需求：随机产生20个不重复的10-100之间的随机数
* */
package com.nuist.collection.set;

import java.util.HashSet;
import java.util.Random;

public class RandomNumberDemo {
    public static void main(String[] args) {
//        创建集合对象
        HashSet<Integer> hashSet = new HashSet<>();
//        创建随机数对象
        Random random = new Random(100);
//        每次随机产生一个随机数并存入集合
        for (int i = 0; i < 20; i++) {
            Integer integer = random.nextInt(100);
            hashSet.add(integer);
        }

//        遍历最终集合
        for (Integer i : hashSet) {
            System.out.println(i);
        }
    }
}
