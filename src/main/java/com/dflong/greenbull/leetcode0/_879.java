package com.dflong.greenbull.leetcode0;

public class _879 {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // 物品group， minProfit
        int [][] dp = new int [n + 1][minProfit + 1];
        int m = group.length;
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            int g = group[i];
            int p = profit[i];

            for (int j = n; j >= g; j --) {
                for (int k = minProfit; k >= 0; k --) {
                    dp[j][k] += dp[j - g][Math.max(0, k - p)];
                    if (dp[j][k] > MOD) {
                        dp[j][k] -= MOD;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n + 1; i++) {
            sum += dp[i][minProfit];
            if (sum > MOD) {
                sum -= MOD;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        new _879().profitableSchemes(5, 3, new int[] { 2,2 }, new int[] { 2,3 });
    }


    // 超时
    public int profitableSchemes1(int n, int minProfit, int[] group, int[] profit) {
        this.n = n;
        this.minProfit = minProfit;
        this.group = group;
        this.profit = profit;
        dfs(0);
        return res;
    }

    int MOD = 1000000007;
    int n, minProfit;
    int[] group, profit;

    int partInGroupSum = 0, partInProfit = 0;
    int res = 0;
    public void dfs(int idx) {

        if (partInGroupSum > n) {
            return;
        }

        if (partInProfit >= minProfit) {
            res = (res + 1) % MOD;
        }

        for (int i = idx; i < group.length; i++) {
            partInGroupSum += group[i];
            partInProfit += profit[i];
            dfs(i + 1);
            partInGroupSum -= group[i];
            partInProfit -= profit[i];
        }
    }
}
