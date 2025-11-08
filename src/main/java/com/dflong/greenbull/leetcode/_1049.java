package com.dflong.greenbull.leetcode;

public class _1049 {

    public static void main(String[] args) {
        new _1049().lastStoneWeightII(new int[]{1, 2});
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;

        // dp[n][target] n个物品容量target的背包最大价值
        int[][] dp = new int[stones.length][target + 1];

        // 递推公式 dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]

        // 初始化
        for (int i = 0; i <= target; i ++) {
            if (i >= stones[0]) {
                dp[0][i] = stones[0];
            }
        }

        // 遍历顺序
        for (int i = 1; i < stones.length; i ++) {
            for (int j = 0; j <= target; j ++) {
                if (j >= stones[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return sum - dp[stones.length - 1][target] - dp[stones.length - 1][target];
    }
}
