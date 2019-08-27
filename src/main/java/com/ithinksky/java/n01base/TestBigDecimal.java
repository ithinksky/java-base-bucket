package com.ithinksky.java.n01base;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 功能描述：
 *
 * @author tengpeng.gao
 */
public class TestBigDecimal {

    public static void main(String[] args) {

        BigDecimal price = new BigDecimal(100);
        BigDecimal bargainPrice = new BigDecimal(222);

        System.out.println(bargainPrice.compareTo(price) >= 0);

    }

    @Test
    public void testA() {
        BigDecimal walletAmount = new BigDecimal(1100.2202);
        System.out.println(" amount ========== " + walletAmount.doubleValue());
        walletAmount = TestBigDecimal.convertBigDecimalDoubleToString(walletAmount);

        BigDecimal changeAmount = new BigDecimal(100.2101);
        System.out.println(" changeAmount ========== " + changeAmount.doubleValue());
        changeAmount = TestBigDecimal.convertBigDecimalDoubleToString(changeAmount);

        BigDecimal amount = walletAmount.subtract(changeAmount);
        System.out.println(" amount ========== " + amount);
        if (amount.compareTo(new BigDecimal("0")) >= 0) {
            System.out.println(" ========== ");
        }
    }

    /**
     * 转换Double 为String 参与计算
     * 因为Double类型的计算会丢失精度
     *
     * @param bigDecimal bigDecimal(0.22)
     * @return bigDecimal("0.22")
     */
    public static BigDecimal convertBigDecimalDoubleToString(@NotNull BigDecimal bigDecimal) {
        return new BigDecimal(Double.toString(bigDecimal.doubleValue()));
    }


}
