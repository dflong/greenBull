package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.List;

public class _2915 {

    public static void main(String[] args) {
        new _2915().lengthOfLongestSubsequence(Arrays.asList(4,1,3,2,1,5), 7);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int size = nums.size();
        int[][] dp = new int[size][target + 1];

        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < size; i ++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= target; j ++) {
            if (j == nums.get(0)) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums.get(i) && dp[i - 1][j - nums.get(i)] != -1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums.get(i)] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[size - 1][target] == 0 ? -1 : dp[size - 1][target];
    }
}
