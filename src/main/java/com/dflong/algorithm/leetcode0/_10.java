package com.dflong.algorithm.leetcode0;

public class _10 {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean [][] dp = new boolean[m + 1][n + 1];
        // 初始化
        dp[0][0] = true;
        for(int j = 2; j < n + 1; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // dp[i][j - 2]： 即将字符组合 p[j - 2] * 看作出现 0 次时，能否匹配。
                    //dp[i - 1][j] 且 s[i - 1] = p[j - 2]: 即让字符 p[j - 2] 多出现 1 次时，能否匹配。
                    //dp[i - 1][j] 且 p[j - 2] = '.': 即让字符 '.' 多出现 1 次时，能否匹配。
                    dp[i][j] =  dp[i][j - 2] || // 倒数第一、二位不看
                            dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'); // 看倒数第二位
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

}
