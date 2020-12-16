package com.ithinksky.datastructure.sort;

import java.util.Arrays;

/**
 * 基本思想:
 * 冒泡排序，较大的数沉下去，较小的数慢慢冒起来
 *
 * @author tengpeng.gao
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] inputArrays = new int[]{5, 2, 6, 1, 3, 4, 8, 9, 7};
        BubbleSort.bubbleSortAsc(inputArrays);

        inputArrays = new int[]{5, 2, 6, 1, 3, 4, 8, 9, 7};
        BubbleSort.bubbleSortDesc(inputArrays);

    }


    /**
     * 从右变开始，将小的交换到前面，将大的交换到后面
     * 直观表达，每一趟遍历，将一个最小的数移到序列前端。
     * @param inputArrays
     */
    public static void bubbleSortDesc(int[] inputArrays) {
        int length = inputArrays.length;
        for (int i = length; i > 0; i--) {
            for (int j = length - 1; j > 0; j--) {
                if (inputArrays[j - 1] > inputArrays[j]) {
                    int temp = inputArrays[j - 1];
                    inputArrays[j - 1] = inputArrays[j];
                    inputArrays[j] = temp;
                }
            }
        }
        System.out.println("bubbleSortDesc === " + Arrays.toString(inputArrays));
    }

    /**
     * 从左变开始，将小的交换到前面，将大的交换到后面
     * 直观表达，每一趟遍历，将一个最大的数移到序列末尾。
     * @param inputArrays
     */
    public static void bubbleSortAsc(int[] inputArrays) {

        int length = inputArrays.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (inputArrays[j] > inputArrays[j + 1]) {
                    int temp = inputArrays[j];
                    inputArrays[j] = inputArrays[j + 1];
                    inputArrays[j + 1] = temp;
                }
            }
        }

        System.out.println("bubbleSortAsc === " + Arrays.toString(inputArrays));
    }


}
