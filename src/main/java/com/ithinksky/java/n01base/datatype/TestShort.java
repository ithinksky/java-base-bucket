package com.ithinksky.java.n01base.datatype;

/**
 * Copyright (C), 2022 valuenovel.com
 *
 * @author: gaotp
 * @since: 2022/4/3 17:10
 * @description: 数据类型的类型装换
 * @modification: 修改说明
 */
public class TestShort {

    public static void main(String[] args) {

        short s = 1;
        s += 1;  // 自动进行类型转换

        short t = 1;
        t = (short) (t + 1); // 不会自动进行类型转换，需要强转

    }

}
