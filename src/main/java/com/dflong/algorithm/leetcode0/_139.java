package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139 {

    public static void main(String[] args) {
        _139 v = new _139();
        boolean b = v.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}
