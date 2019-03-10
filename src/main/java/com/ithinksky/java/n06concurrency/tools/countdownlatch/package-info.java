/**
 * CountDownLatch 允许一个或多个线程等待其他线程完成
 *
 * 当我们调用 CountDownLatch 的 countDown 方法时，N 就会减 1 ，
 * CountDownLatch 的 await 方法 就会阻塞当前线程，知道 N 变为 0 。
 * 由于 countDown 方法可以用在任何地方，所以 N 个点，
 * 可以是 N 个线程，也可以是一个线程里的 N 个执行步骤。
 * 用在多个线程时，只需要把这个 CountDownLatch 的引用传递到线程里即可。
 *
 * @author tengpeng.gao
 * @since 2019/3/10
 */
package com.ithinksky.java.n06concurrency.tools.countdownlatch;