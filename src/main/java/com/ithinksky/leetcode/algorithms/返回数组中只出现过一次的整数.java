package com.ithinksky.leetcode.algorithms;

/**
 * 给定整数数组，除了一个元素之外，每个元素都会出现两次。 找到那个只出现一次的
 * <p>
 * 利用 异或
 * 0^1 = 1
 * 0^0 = 0
 * 1^0 = 1
 * 1^1 = 0
 */
public class 返回数组中只出现过一次的整数 {


    public static void main(String[] args) {

        int intArray[] = new int[]{1, 2, 1, 3, 2};

        int length = intArray.length;

        System.out.println(返回数组中只出现过一次的整数.singleNumber(intArray));

        // int resultArray = [3, 5] / [5, 3]
    }


    private static int singleNumber(int[] array) {
        int length = array.length;
        int num = 0;
        for (int i = 0; i < length; i++) {
            num = num ^ array[i];
        }
        return num;
    }

}
