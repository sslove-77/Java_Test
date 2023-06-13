/** Stream流：
 * 创建方式：
    * 通过集合创建
    * Stream s = Collection.stream()  顺序流
    * Stream s = Collection.parallelStream()  并行流

    * 通过数组创建
    * IntStream stream = Arrays.stream(arr);

    * 通过 Stream的of()方法
    * Stream<Integer> stream = Stream.of(1,2,3,4,5,6);

    * 创建无限流
    *
 * void	forEach(Consumer<? super T> action)：对此流的每个元素执行操作。
 * Stream<T> limit(long maxSize)：返回由此流的元素组成的流，截短长度不能超过 maxSize
 * static <T> Stream<T>	iterate(T seed, UnaryOperator<T> f)
     返回有序无限连续 Stream由函数的迭代应用产生 f至初始元素 seed ，
     产生 Stream包括 seed ， f(seed) ， f(f(seed)) ，等
*/
package com.nuist.newproperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//    创建集合对象
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);

//        通过集合创建顺序流
        Stream<Integer> stream1 = arrayList.stream();
//        创建并行流
        Stream<Integer> parallelStream = arrayList.parallelStream();
//        通过数组创建
        IntStream stream2 = Arrays.stream(new int[]{10, 20, 30, 40});

//        通过Stream的of方法创建
        Stream<Integer> stream3 = Stream.of(10, 20, 30, 40);

//        创建无限流
        Stream.iterate(1,integer -> integer*2).limit(8)
                .forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
