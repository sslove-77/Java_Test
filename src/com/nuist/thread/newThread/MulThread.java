package com.nuist.thread.newThread;

/**
 * @author Helen
 * @date 2023-02-12 11:23
 */
public class MulThread extends Thread{
    public MulThread() {
    }

    public MulThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"--当前输出："+i);

        }
    }
}
