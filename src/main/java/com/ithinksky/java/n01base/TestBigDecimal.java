package com.ithinksky.java.n01base;

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

}
