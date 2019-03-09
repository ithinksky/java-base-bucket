package com.ithinksky.java.n05mutilthread.dbpool.t001;

import java.util.concurrent.TimeUnit;

/**
 * 模拟数据库连接
 *
 * @author tengpeng.gao
 * @since 2019/3/9
 */
public class Connection {

    private String connectionName;

    public Connection(int i) {
        connectionName = "数据库连接 - " + i;
    }

    public void executeSql() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(connectionName + " 模拟要执行的数据库操作");
    }

}
