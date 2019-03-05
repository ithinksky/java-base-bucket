package com.ithinksky.java.n06concurrency.tools;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 使用 Fork/Join 框架
 * 这是一个简单的Join/Fork计算过程，将1—1001数字相加
 *
 * @author tengpeng.gao
 * @since 2019/3/1
 */
public class Test001ForkJoin {


    static class TestForkJoin extends RecursiveTask<Integer> {

        private static final Integer MAX = 200;

        private Integer startValue;

        private Integer endValue;

        public TestForkJoin(Integer startValue, Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Integer compute() {
            if (endValue - startValue < MAX) {
                System.out.println("开始计算的部分：startValue = " + startValue + ";endValue = " + endValue);
                int totalValue = 0;
                for (int i = startValue; i <= endValue; i++) {
                    totalValue += i;
                }
                return totalValue;
            } else {
                TestForkJoin testForkJoinA = new TestForkJoin(startValue, (startValue + endValue) / 2);
                TestForkJoin testForkJoinB = new TestForkJoin((startValue + endValue) / 2 + 1, endValue);
                testForkJoinA.fork();
                testForkJoinB.fork();
                return testForkJoinA.join() + testForkJoinB.join();
            }
        }
    }


    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        TestForkJoin testForkJoin = new TestForkJoin(1, 1001);

        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(testForkJoin);
        try {
            Integer result = forkJoinTask.get();
            System.out.println("result = " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
