package com.dflong.greenbull.leetcode;

import java.util.Arrays;

public class _467 {

    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];

        int k = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                k ++; // 连续
            } else {
                k = 1;
            }
            dp[s.charAt(i) - 'a'] = Math.max(dp[s.charAt(i) - 'a'], k);
        }

        return Arrays.stream(dp).sum();
    }
}
