package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1774 {

    public int closestCostMin(int[] baseCosts, int[] toppingCosts, int target) {
        int[] nums = new int[toppingCosts.length * 2];
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = toppingCosts[i % toppingCosts.length];
        }
        int m = baseCosts.length, n = nums.length;

        Arrays.sort(baseCosts);
        Arrays.sort(toppingCosts);
        List<Integer> list = new ArrayList<>();
        for (int k = 0; k < m; k ++) {
            int base = baseCosts[k];
            int tar = target - base;
            if (tar <= 0) {
                list.add(base);
                continue;
            }
            int[][] dp = new int[n][target + 1];
            // 初始化
            for (int i = 0; i <= tar; i ++) {
                if (i >= nums[0]) {
                    dp[0][i] = nums[0];
                }
            }

            for (int i = 1; i < n; i ++) {
                for (int j = 1; j <= tar; j ++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= nums[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    }
                }
            }
            list.add(base + dp[n - 1][tar]);
        }

        list.add(baseCosts[0]);
        list.add(baseCosts[0] + toppingCosts[0]);
        int max = list.get(0);
        for (int cost : list) {
            if (Math.abs(cost - target) < Math.abs(max - target)) {
                max = cost;
            } else if (Math.abs(cost - target) == Math.abs(max - target) && cost < max) {
                max = cost;
            }
        }

        return max;
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // 得到最近结果
        int min = closestCostMin(baseCosts, toppingCosts, target);
        if (min - target != 0) {
            for (int diff = 1; diff <= Math.abs(target - min); diff ++) {
                int i1 = closestCostMin(baseCosts, toppingCosts, target + diff);
                System.out.println(i1);
                if (Math.abs(min - target) > Math.abs(i1 - target)) {
                    min = i1;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        _1774 v = new _1774();

        int i = v.closestCost(new int[]{2753,8936,5849,8042,6881,1996,3424,9348,6280},
                new int[]{3356,4654,1772,396,1935},
            9328);
        System.out.println();
    }

}
