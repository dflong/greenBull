package com.dflong.greenbull.leetcode;

public class BagWeight {

    /**
     * 01背包
     * 	    重量	  价值
     * 物品0	 1	  15
     * 物品1	 3	  20
     * 物品2	 4	  30
     *
     * （容量）  0    1   2   3   4
     * 物品0    0   15  15  15  15
     * 物品1    0   15  15  20  35(物品0容量1 + 物品1价值)
     * 物品2    0   15  15  20  35
     */
    public int bagWeight(int w, int[] weights, int[] values) {
        // dp[i][j] 从weights.length件物品任取放在w容量的背包里的最大价值
        int[][] dp = new int[weights.length][w + 1];

        // 递推公式         放当前物品i                            不放当前物品
        // dp[i][j] = Max(dp[i - 1][j - weight[i]] + values[i], dp[i - 1][j])

        // 初始化
        for (int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= w; j ++) {
            if (weights[0] <= j) {
                dp[0][j] = values[0];
            }
        }

        // 遍历顺序 物品、背包不区分先后
        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j <= w; j ++) {
                if (weights[i] <= j) { // 可以放下当前物品
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

//        for (int j = 0; j <= w; j ++) {
//            for (int i = 1; i < weights.length; i++) {
//                if (weights[i] <= j) { // 可以放下当前物品
//                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }

        return dp[weights.length - 1][w];
    }

    /**
     * 一维数组
     */
    public int bagWeight1(int w, int[] weights, int[] values) {
        // dp[j]容量为w的背包最大价值
        int[] dp = new int[w + 1];

        // 递推公式 dp[j] = Max(dp[j], dp[j - weight[i]] + values[i])

        // 初始化

        // 遍历顺序 只能先物品，后背包
        for (int i = 0; i < weights.length; i++) {
            for (int j = w; j >= 0; j --) { // 只能倒序
                if (weights[i] <= j) {
                    dp[j] = Math.max(dp[j - weights[i]] + values[i], dp[j]);
                }
            }
        }

        return dp[w];
    }


    /**
     * 完全背包
     * 	     重量  价值
     * 物品0	  1	   15
     * 物品1	  3	   20
     * 物品2	  4	   30
     *
     * （容量）  0    1   2   3   4
     * 物品0    0   15  30  45  60
     * 物品1    0   15  30  45  60
     * 物品2    0   15  30  45  60
     *
     */
    public int bagWeight2(int w, int[] weights, int[] values) {

        // n件物品可重复放置在容量为w的背包，最大价值
        int[][] dp = new int[weights.length][w + 1];

        // 递推公式 dp[i][j] = max(dp[i - 1][j], dp[i][j - weights[i]] + values[i])

        // 初始化
        for (int i = 1; i <= w; i++) {
            dp[0][i] = dp[0][i - weights[0]] + values[0];
        }

        // 遍历顺序 不区分先后
        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (weights[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weights[i]] + values[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length - 1][w];
    }

    // 一维数组 (物品、背包顺序不分先后) 先物品后背包是组合 先背包后物品是排列
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
