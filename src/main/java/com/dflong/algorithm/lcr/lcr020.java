package com.dflong.algorithm.lcr;

public class lcr020 {

    public int countSubstrings(String s) {
        // i到j位置的回文串数量
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        // i,j = i + 1, j - 1;
        for (int l = s.length() - 1; l >= 0; l --) {
            for (int r = l; r < s.length(); r ++) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l < 2) {
                        dp[l][r] = true;
                        res ++;
                    } else if (dp[l + 1][r - 1]) {
                        dp[l][r] = true;
                        res ++;
                    }
                }
            }
        }
        return res;
    }
}
