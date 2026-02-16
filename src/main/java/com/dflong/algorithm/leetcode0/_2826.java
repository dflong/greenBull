package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.List;

public class _2826 {

    public int minimumOperations(List<Integer> nums) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 1; i < nums.size(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums.get(j) <= nums.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return nums.size() - res;
    }
}
