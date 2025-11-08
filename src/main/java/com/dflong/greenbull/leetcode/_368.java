package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _368 {

    public static void main(String[] args) {
        new _368().largestDivisibleSubset(new int[]{1,2,4,8});
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // i位置最大公约数个数
        int[] dp = new int[n];

        // 递推公式 dp[i] = max(dp[i], dp[j] + 1)

        // 初始化
        Arrays.fill(dp, 1);

        int maxSize = 1;
        int maxVal = nums[0];
        // 遍历顺序
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        List<Integer> res = new ArrayList<>();
        // 用最大公约数倒推结果
        for (int i = n - 1; i >= 0; i --) {
            if (maxSize == dp[i] && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxSize --;
                maxVal = nums[i];
            }
        }

        return res;
    }
}
