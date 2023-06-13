/** 集合嵌套
 */

package com.nuist.collection.list;

import org.junit.Test;

import java.util.ArrayList;

public class MulTest {
    @Test
    public void test() {
//        嵌套集合
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();

        ArrayList<String> subList1 = new ArrayList<>();
        subList1.add("java");
        subList1.add("hadoop");

        ArrayList<String> subList2 = new ArrayList<>();
        subList2.add("hive");
        subList2.add("oracle");

        arrayList.add(subList1);
        arrayList.add(subList2);

//        遍历嵌套集合
        for (ArrayList<String> sub : arrayList) {
            for (String s : sub) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
