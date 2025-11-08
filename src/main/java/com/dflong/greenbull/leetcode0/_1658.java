package com.dflong.greenbull.leetcode0;

public class _1658 {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] dp = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            dp[i] = nums[i % n];
        }

        int l = 0, r = 0, min = n + 1;
        while (r < 2 * n) {
            x -= dp[r];
            while (x < 0) {
                x += dp[l++];
            }
            if (x == 0 && ((l <= n && n <= r) || (l <= n - 1 && n - 1 <= r))) {
                min = Math.min(min, r - l + 1);
            }

            r ++;
        }

        return min == n + 1 ? -1 : min;
    }
}
