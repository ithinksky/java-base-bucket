package com.ithinksky.datastructure.sort;

/**
 * 类功能描述：
 *
 * @author: tengpeng.gao
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // 找到当前未排序部分的最小元素
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            // 交换当前未排序部分的最小元素与未排序部分的第一个元素
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }


}
