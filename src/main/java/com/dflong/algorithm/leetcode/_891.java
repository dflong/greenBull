package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _891 {

    public int sumSubseqWidths(int[] nums) {
        // 求当前nums[i]做为最大值、最小值在子序列出现的次数
        // 排序后，nums[i]做为最大值的次数是2^i，做为最小值的次数是2^(n - 1 - i)，差值就是贡献
        int n = nums.length, MOD = 1000000007;
        Arrays.sort(nums);
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i ++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long res = 0;
        for (int i = 0; i < nums.length; i ++) {
            res += (long) nums[i] * (pow2[i] - pow2[n - 1 - i]) % MOD;
        }
        // res 可能是负数，所以加上MOD再取模
        return (int) (res % MOD + MOD) % MOD;
    }
}
