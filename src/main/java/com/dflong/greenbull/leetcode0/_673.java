package com.dflong.greenbull.leetcode0;

import java.util.Arrays;

public class _673 {

    public static void main(String[] args) {
        new _673().findNumberOfLIS(new int[]{1,3,5,4,7});
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = 0, sum = 0;
        int[] dp = new int[n], count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                sum = count[i];
            } else if (dp[i] == max) {
                sum += count[i];
            }
        }

        return sum;
    }

}
