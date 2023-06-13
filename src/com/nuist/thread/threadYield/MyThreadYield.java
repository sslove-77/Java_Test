/** Thread.yield() 方法在某种程度上能让每个线程交替执行
* */
package com.nuist.thread.threadYield;

public class MyThreadYield extends Thread {
    //    构造方法
    public MyThreadYield() {
    }

    public MyThreadYield(String name) {
        super(name);
    }

//    重写run方法

    @Override
    public void run() {
//       每隔一秒依次打印字符串中的每个字符
        String str = "abcdefghijklmn";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println(getName() + "--" + ch);

//            每个线程执行后暂停一秒
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }
}
