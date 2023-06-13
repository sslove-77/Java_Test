/** 分支合并框架，ForkJoinPool
 *
 * 需求：求 1+2+3+100，采用分支合并操作
*/
package com.nuist.thread.synchronize.fork_join_pool;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
//    定义变量Diff，分支的判断条件
    private final int DIFF = 20;

//  定义开始值和结束值
    private int start;
    private int end;

//    定义最终结果值
    private int result;

//    构造方法

    public MyRecursiveTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        for (int i = start; i <= end; i++) {
            //      判断分支条件
            if ((end - start) <= DIFF) {
//                满足条件直接求和
                result += i;
            } else {
//                不满足则拆分
                int middle = (start + end) / 2;
                MyRecursiveTask myTask1 = new MyRecursiveTask(start, middle);
                MyRecursiveTask myTask2 = new MyRecursiveTask(middle + 1, end);
//                拆分
                myTask1.fork();
                myTask2.fork();
//                结果合并
                result = myTask1.join() + myTask2.join();
            }
        }
        return result;
    }
}
