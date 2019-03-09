package com.ithinksky.java.n05mutilthread.dbpool.t001;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试数据库连接池
 *
 * @author tengpeng.gao
 * @since 2019/3/9
 */
public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);

    // 保证所有 ConnectionRunner 同时开始
    static CountDownLatch start = new CountDownLatch(1);

    // main 线程将会等待所有 ConnectionRunner 结束后才能继续进行
    static CountDownLatch end;

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }


        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.executeSql();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        int threadCount = 50;
        end = new CountDownLatch(threadCount);

        // 每个线程申请数据库连接次数
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 1; i <= threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread-" + i);
            thread.start();
        }
        start.countDown();
        end.await();

        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);


    }

}
