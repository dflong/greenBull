package com.dflong.algorithm.leetcode0;

import java.util.Scanner;

public class kaMa_057 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int solve = solve(n, m);
        System.out.println(solve);
    }

    public static int solve(int n, int m) {
        int[] dp = new int[n];
        dp[1] = 1;

        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}
