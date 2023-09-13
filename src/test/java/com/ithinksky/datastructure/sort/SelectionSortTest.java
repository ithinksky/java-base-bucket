package com.ithinksky.datastructure.sort;

import org.junit.Test;

/**
 * 类功能描述：选择排序
 * 选择排序是不稳定的排序方法，主要应用场景是在数据量较小或者数据已经部分有序的情况下使用。
 *
 * @author: tengpeng.gao
 */
public class SelectionSortTest {

    @Test
    public void selectionSort() {
        int[] arr = {64, 25, 12, 22, 11};
        SelectionSort.selectionSort(arr);
        System.out.println("Sorted array");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}