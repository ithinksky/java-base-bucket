package com.ithinksky.datastructure.search;

/**
 * 类功能描述：二分法查找
 * 查找的数据在一个有序的集合内。。。
 *
 * @author: tengpeng.gao
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                // 找到目标，返回其索引
                return mid;
            } else if (arr[mid] < target) {
                // 如果目标大于中间值，搜索右半部分
                left = mid + 1;
            } else {
                // 如果目标小于中间值，搜索左半部分
                right = mid - 1;
            }
        }

        // 没有找到目标，返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}