package com.dflong.algorithm.leetcode;

public class _330 {

    public static void main(String[] args) {
        new _330().minPatches(new int[]{1,2}, 6);
    }

    public int minPatches(int[] nums, int n) {
        int min = 0, i = 0;
        long x = 1;
        while (x <= n) {
            if (i < nums.length && nums[i] <= x) {
                x += nums[i];
                i ++;
            } else {
                x *= 2; // 当前数组缺少，需要加一个数字，同时覆盖的范围 * 2
                min ++;
            }
        }

        return min;
    }

}
