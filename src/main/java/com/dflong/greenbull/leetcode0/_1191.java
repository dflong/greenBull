package com.dflong.greenbull.leetcode0;

public class _1191 {

    public static void main(String[] args) {
        System.out.println((10000000000L) % 1000000007);
        System.out.println(new _1191().kConcatenationMaxSum(
                new int[]{1, 2}, 1));
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = 1000000007;
        int n = arr.length;

        int[] dp = new int[n * 2];
        dp[0] = arr[0];
        long max = Math.max(0, arr[0]), sum = arr[0];
        for (int i = 1; i < (k > 1 ? 2 * n : n); i ++) {
            dp[i] = Math.max(dp[i - 1] + arr[i % n], arr[i % n]);
            max = Math.max(dp[i], max);

            if (i < n) {
                sum += arr[i];
            }
        }

        if (k > 2 && sum > 0) return (int) ((max + sum * (k - 2)) % MOD);
        return (int) (max % MOD);
    }
}
