package com.dflong.algorithm.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _2606 {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }

        int[] sNums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sNums[i] = map.getOrDefault(s.charAt(i), s.charAt(i) - 'a' + 1);
        }

        int[] dp = new int[s.length()];
        dp[0] = sNums[0];
        int max = sNums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + sNums[i], sNums[i]);
            max = Math.max(max, dp[i]);
        }

        return Math.max(0, max);
    }
}
