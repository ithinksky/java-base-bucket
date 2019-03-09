package com.ithinksky.java.n05mutilthread.dbpool.t001;

import java.util.LinkedList;

/**
 * 使用超时等待模式构建一个简单的数据库连接池示例
 *
 * @author tengpeng.gao
 * @since 2019/3/9
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initPoolSize) {
        if (initPoolSize > 0) {
            for (int i = 1; i <= initPoolSize; i++) {
                pool.addLast(new Connection(i));
            }
        }
    }

    /**
     * 释放数据库连接，归还到连接池中，并通知所有等待 pool 的线程
     *
     * @param connection 要释放的数据库连接
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }


    /**
     * 使用等待超时模式申请一个数据库连接
     *
     * @param mills 超时时间
     * @return 数据库连接或等待超时
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection connection = null;
                if (!pool.isEmpty()) {
                    connection = pool.removeFirst();
                }
                return connection;

            }
        }

    }


}
