//package com.ithinksky.leetcode.algorithms;
//
///**
// * 求连续最大乘积
// *
// * @author tengpeng.gao
// */
//public class T001MaxMulti {
//
//    public static void main(String[] args) {
//
//        int[] arrays = new int[]{2, 0, -2, -3, 4, 0, 2, 4};
//        int length = arrays.length;
//        int max = 0;
//        for (int i = 0; i < length; i++) {
//            int max = arrays[0];
//            for (int j = i; j < length; j++) {
//                if (max * arrays[j] > max) {
//                    max = max * arrays[j];
//                }
//            }
//        }
//        System.out.println("max === " + max);
//
//    }
//
//}
