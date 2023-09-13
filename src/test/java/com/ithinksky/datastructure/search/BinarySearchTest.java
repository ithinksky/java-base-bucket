package com.ithinksky.datastructure.search;

import org.junit.Test;

/**
 * 类功能描述：
 *
 * @author: tengpeng.gao
 */
public class BinarySearchTest {

    @Test
    public void binarySearch() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        int result = BinarySearch.binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}