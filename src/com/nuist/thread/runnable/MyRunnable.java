package com.nuist.thread.runnable;

/**
 * @author Helen
 * @date 2023-02-12 11:32
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        String s = "I love my families and we will have a happy future forever!";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("超时了");
            }
            System.out.println(Thread.currentThread().getName()+"--"+chars[i]);
        }
    }

}
