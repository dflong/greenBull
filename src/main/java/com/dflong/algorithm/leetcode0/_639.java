package com.dflong.algorithm.leetcode0;

public class _639 {

    public static void main(String[] args) {
        new _639().numDecodings("***");
    }

    int MOD = 1000000007;
    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') return 0;
        if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else {
            dp[1] = 1;
        }

        for (int i = 1; i < n; i ++) {
            int one = oneChar(s.charAt(i));
            int two = twoChar(s.charAt(i - 1), s.charAt(i));
            dp[i + 1] = (dp[i - 1] * two + dp[i] * one) % MOD;
        }
        return (int) dp[n];
    }

    public int oneChar(char x) {
        if (x == '*') return 9;
        if (x == '0') return 0;
        return 1;
    }

    public int twoChar(char x, char y) {
        if (x == '0' || (x >= '3' && x <= '9')) return 0;
        if (x == '1') return y == '*' ? 9: 1;
        if (x == '2') {
            if (y == '*') return 6;
            if(y >= '0' && y <= '6') return 1;
            return 0;
        }
        if (x == '*') {
            if (y == '*') return 15;
            if (y >= '0' && y <= '6') return 2;
        }
        return 1;
    }
}
