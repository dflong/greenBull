package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.Objects;

public class _1449 {

    public static void main(String[] args) {
        new _1449().largestNumber(new int[]{4,3,2,5,6,7,2,5,5}, 9);
    }

    public String largestNumber(int[] cost, int target) {
        String[][] dp = new String[9][target + 1];
        for (int i = 0; i < 9; i ++) {
            Arrays.fill(dp[i], "");
        }
        for (int i = 0; i < target + 1; i ++) {
            if (i % cost[0] == 0 && i >= cost[0]) {
                dp[0][i] = dp[0][i - cost[0]] + 1;
            }
        }

        for (int i = 1; i < 9; i ++) {
            for (int j = 1; j <= target; j ++) {
                if (j >= cost[i]) {
                    if (j == cost[i]) {
                        dp[i][j] = strMax(dp[i - 1][j], (i + 1) + "");
                    } else if (j > cost[i] && !Objects.equals(dp[i][j - cost[i]], "")) {
                        String num = (i + 1) + dp[i][j - cost[i]];
                        dp[i][j] = strMax(dp[i - 1][j], num);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        if (dp[8][target] == "") return "0";
        return dp[8][target];
    }

     String strMax(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.length() > b.length()) return a;
        if (a.length() < b.length()) return b;
        return a.compareTo(b) > 0 ? a : b;
    }
}
