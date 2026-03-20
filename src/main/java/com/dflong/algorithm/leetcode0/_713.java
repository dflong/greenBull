package com.dflong.algorithm.leetcode0;

public class _713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length, res = 0;
        int prod = 1, l = 0;
        for (int r = 0; r < n; r ++) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l];
                l ++;
            }
            res += r - l + 1; // j结尾的节点有多少满足的
        }
        return res;
    }

    public static void main(String[] args) {
        new _713().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    }
}
