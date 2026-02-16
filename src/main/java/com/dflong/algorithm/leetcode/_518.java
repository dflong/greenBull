package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _518 {

    public static void main(String[] args) {
        new _518().change(5, new int[] {1, 2, 5});
    }

    public int change(int amount, int[] coins) {
        backTracking(amount, coins, 0);

        // n个金币随意选取可重复，金额达到amount的组合数量
        int[][] dp = new int[coins.length][amount + 1];

        // 递推公式 dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]]

        // 初始化
        for (int i = 0; i < coins.length; i ++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= amount; i ++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }

        // 遍历顺序
        for (int i = 1; i < coins.length; i ++) {
            for (int j = 1; j <= amount; j ++) {
                if (j >= coins[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length - 1][amount];
    }

    public int change1(int amount, int[] coins) {
//        backTracking(amount, coins, 0);

        // n个金币随意选取可重复，金额达到amount的组合数量
        int[] dp = new int[amount + 1];

        // 递推公式 dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]]

        // 初始化
        dp[0] = 1;

        // 遍历顺序 先物品后背包是组合
        for (int i = 0; i < coins.length; i ++) {
            for (int j = 0; j <= amount; j ++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }

        // 先背包后物品是排列
//        for (int j = 0; j <= amount; j ++) {
//            for (int i = 0; i < coins.length; i ++) {
//                if (j >= coins[i]) {
//                    dp[j] = dp[j] + dp[j - coins[i]];
//                }
//            }
//        }

        return dp[amount];
    }

    /**
     * 组合 （超时）
     */
    int sum = 0, res;
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();
    public void backTracking(int amount, int[] coins, int idx) {
        if (sum == amount) {
            res ++;
            lists.add(new ArrayList<>(list));
            return;
        }
        if (sum > amount) {
            return;
        }

        for (int i = idx; i < coins.length; i ++) {
            sum += coins[i];
            list.add(coins[i]);
            backTracking(amount, coins, i);
            sum -= coins[i];
            list.remove(list.size() - 1);
        }
    }
}
