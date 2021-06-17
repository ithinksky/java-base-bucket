package com.ithinksky.java.n01base;


import java.util.Random;

public class TestRandom {

    public static void main(String[] args) {

        Random random = new Random();

        // 0~9
        int i = random.nextInt(10);
        System.out.println(i);

        // 1~10
        i = random.nextInt(10) + 1;
        System.out.println(i);

    }
}
