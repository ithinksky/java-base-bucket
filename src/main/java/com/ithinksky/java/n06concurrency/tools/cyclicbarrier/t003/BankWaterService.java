package com.ithinksky.java.n06concurrency.tools.cyclicbarrier.t003;

import java.util.Map.Entry;
import java.util.concurrent.*;

/**
 * 注意 业务处理 和 await 调用之间的顺序。
 *
 * @author tengpeng.gao
 * @since 2019/3/11
 */
public class BankWaterService implements Runnable {

    private CyclicBarrier c = new CyclicBarrier(4, this);
    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();


    private void count() {

        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                // 计算当前 sheet 的银行流水数据，
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                // 银行流水计算完成，插入一个屏障。
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

    }


    @Override
    public void run() {
        int result = 0;
        for (Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println("result === " + result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
