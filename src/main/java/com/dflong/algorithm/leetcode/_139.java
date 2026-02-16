package com.dflong.algorithm.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        // n长度的字符串s能否由wordDict组成
        boolean[] dp = new boolean[s.length() + 1];

        // 递推公式 dp[i] = dp[j] && set.contains(i - j)

        // 初始化
        dp[0] = true;

        // 遍历顺序
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
