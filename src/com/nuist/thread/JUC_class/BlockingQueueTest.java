/** 阻塞队列BlockingQueue(接口)，主要实现类：ArrayBlockingQueue， LinkedBlockingQueue
 * 四种添加，取元素方法
    *1.抛出异常：  add(e) ，remove()，检查：element()
    *2.特殊值：offer(e)，poll()，检查：peek()
    *3. 阻塞：put(e) ， take()
    *4. 超时：offer(e, time, unit) ，poll(time, unit)
*/
package com.nuist.thread.JUC_class;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
//        创建数组阻塞队列对象，指定容量为4
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(4);

//    第一种方法
//        blockingQueue.add("aa");
//        blockingQueue.add("bb");
//        blockingQueue.add("cc");
//        blockingQueue.add("dd");
//        blockingQueue.add("ee");  // 队列满了Queue full

//        System.out.println(blockingQueue.remove());   // aa
//        System.out.println(blockingQueue.remove());  // bb
//        System.out.println(blockingQueue.remove());  // cc
//        System.out.println(blockingQueue.remove());  // dd
//        System.out.println(blockingQueue.element());  //NoSuchElementException - 如果这个队列是空的

//    第二种方法
//        blockingQueue.offer("aa");
//        blockingQueue.offer("bb");
//        blockingQueue.offer("cc");
//        blockingQueue.offer("dd");
//        blockingQueue.offer("ee");
////
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());  // null，只能装4个元素

//        阻塞式方法
        blockingQueue.put("aa");
        blockingQueue.put("bb");
        blockingQueue.put("cc");
        blockingQueue.put("dd");
//        blockingQueue.put("ee");  // 阻塞

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());  //阻塞

    }
}
