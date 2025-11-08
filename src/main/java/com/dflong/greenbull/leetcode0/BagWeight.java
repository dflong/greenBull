package com.dflong.greenbull.leetcode0;

/**
 * 01背包
 */
public class BagWeight {

    public static void main(String[] args) {
        BagWeight bagWeight = new BagWeight();
        int solve = bagWeight.solve2(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4);
        System.out.println(solve);
        solve = bagWeight.solve3(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4);
        System.out.println(solve);
    }

    // 二维数组 (物品、背包顺序不分先后)
    public int solve(int[] weights, int[] values, int bagWeight) {
        int n = weights.length;

        int[][] dp = new int[n][bagWeight + 1];
        // dp[i][0] = 0
        // dp[0][j]
        for (int j = weights[0]; j <= bagWeight; j ++) {
            dp[0][j] = values[0];
        }

        for (int i = 1; i < n; i ++) {
            for (int j = 1; j <= bagWeight; j ++) {
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        return dp[n - 1][bagWeight];
    }

    // 一维数组 (物品、背包顺序分先后、不可颠倒)
    public int solve1(int[] weights, int[] values, int bagWeight) {
        int n = weights.length;
        int[] dp = new int[bagWeight + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = bagWeight; j >= weights[i]; j --) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[bagWeight];
    }


    /**
     * 完全背包 (物品、背包顺序不分先后)
     */
    // 二维数组
    public int solve2(int[] weights, int[] values, int bagWeight) {
        int n = weights.length;
        int[][] dp = new int[n][bagWeight + 1];
        // 初始化
        dp[0][weights[0]] = values[0];
        for (int j = weights[0] + 1; j <= bagWeight; j ++) {
            dp[0][j] = dp[0][j - 1] + values[0];
        }
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j <= bagWeight; j ++) {
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weights[i]] + values[i]);
                }
            }
        }
        return dp[n - 1][bagWeight];
    }

    // 一维数组 (物品、背包顺序不分先后)
    public int solve3(int[] weights, int[] values, int bagWeight) {
        int n = weights.length;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < n; i ++) {
            for (int j = weights[i]; j <= bagWeight; j ++) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        return dp[bagWeight];
    }

}
