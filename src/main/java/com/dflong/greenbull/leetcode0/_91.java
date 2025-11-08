package com.dflong.greenbull.leetcode0;

public class _91 {

    public static void main(String[] args) {
        new _91().numDecodings("12");
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    // 超时
//    public int numDecodings(String s) {
//        this.s = s;
//        this.n = s.length();
//        dfs(0);
//        return sum;
//    }
//
//    int n, sum = 0;
//    String s;
//
//    public void dfs(int idx) {
//        if (idx == n) {
//            sum ++;
//            return;
//        }
//
//        for (int i = idx; i < n; i ++) {
//            int size = i + 1 - idx;
//            char idxChar = s.charAt(idx);
//            char iChar = s.charAt(i);
//            if (size > 2 || idxChar == '0') return;
//            if (size == 1) {
//                dfs(i + 1);
//            } else if (idxChar == '1' || (idxChar == '2' && iChar < '7')) {
//                dfs(i + 1);
//            }
//        }
//    }
}
