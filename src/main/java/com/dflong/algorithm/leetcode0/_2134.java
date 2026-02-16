package com.dflong.algorithm.leetcode0;

public class _2134 {

    public static void main(String[] args) {
        new _2134().minSwaps(new int[] {0,0,0});
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        int count = 0; // 1的数量, 窗口大小
        for (int i = 0; i < n; i++) {
            count += nums[i];
        }
        int min = count;
        if (count == 0) {
            return 0;
        }
        int num = 0; // 0的数量
        int l = 0, i = 0;
        while (l < n) {
            if (nums[i % n] == 0) {
                num ++;
            }
            if (i - l + 1 == count) {
                min = Math.min(min, num);
                if (nums[l] == 0) {
                    num --;
                }
                l ++;
            }
            i ++;
        }

        return min;
    }
}
