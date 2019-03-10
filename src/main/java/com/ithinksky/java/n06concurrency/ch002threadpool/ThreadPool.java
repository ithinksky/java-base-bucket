package com.ithinksky.java.n06concurrency.ch002threadpool;

/**
 * 线程池
 *
 * @author tengpeng.gao
 * @since 2019/3/10
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();

}
