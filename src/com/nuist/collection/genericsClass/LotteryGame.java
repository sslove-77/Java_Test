package com.nuist.collection.genericsClass;

import java.util.ArrayList;
import java.util.Random;

public class LotteryGame<T> {
//    泛型集合
    private ArrayList<T> arrayList = new ArrayList<>();
//      添加到集合
    public void put(T prize) {
        arrayList.add(prize);
    }

    //    随机数
    Random random = new Random();

    //    随即返回任意一个
    public T getPrize() {
        int i = random.nextInt(arrayList.size());
        return arrayList.get(i);
    }
}
