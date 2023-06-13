package com.nuist.thread.callable;

import java.util.concurrent.Callable;

/**
 * @author Helen
 * @date 2023-02-13 22:28
 */
public class MyCall implements Callable {
    @Override
    public Object call() throws Exception {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
