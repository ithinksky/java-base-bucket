package com.ithinksky.datastructure.search;

/**
 * 类功能描述：线性搜索
 *
 * @author: tengpeng.gao
 */
public class LinearSearch {
    public static int linearSearch(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
