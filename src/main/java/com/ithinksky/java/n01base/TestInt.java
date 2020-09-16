package com.ithinksky.java.n01base;

import java.util.Objects;

/**
 * @author tengpeng.gao
 */
public class TestInt {

    public static void main(String[] args) {

        Integer id = 0;
        System.out.println(Objects.isNull(id) || id.equals(0));

        System.out.println(34%20 - 1);
    }


}

