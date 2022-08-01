package com.ithinksky.leetcode.algorithms;

/**
 * 类功能描述：
 *
 * @author: tengpeng.gao
 */
public class 剑指Offer03数组中重复的数字 {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        Solution solution = new Solution();
        int repeatNumber = solution.findRepeatNumber(nums);
        System.out.println(repeatNumber);

    }

}


class Solution {

    // 自己实现
    public int findRepeatNumber(int[] nums) {

        int length = nums.length;
        int result = 0;

        here:
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    result = nums[i];
                    break here;
                }
            }
        }
        return result;
    }
}