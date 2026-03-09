package com.dflong.algorithm.leetcode;

import java.util.*;

public class _902 {

    private String[] digits;
    private char s[];
    private int dp[];

    // 从digits选数字，得到结果<=n的个数
    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length];
        Arrays.fill(dp, -1); // dp[i] = -1 表示 i 这个状态还没被计算出来
        return dfs(0, true, false);
    }


    // idx当前位 isLimit前一位是否受到上界限制 isNum前一位是否选择
    int dfs(int idx, boolean preIsLimit, boolean preIsNum) {
        if (idx == s.length) return preIsNum ? 1 : 0; // 到底了而且前一位选了是一种方案

        if (!preIsLimit && preIsNum && dp[idx] != -1) return dp[idx]; // 初始相反条件

        int res = 0;

        if (!preIsNum) {
            // 前一位不选择，当前位置也可以不选择
            res += dfs(idx + 1, false, false);
        }

        char up = preIsLimit ? s[idx] : '9';
        for (String digit : digits) {
            // 超过上界
            if (digit.charAt(0) > up) continue;

            // idx - 2, idx - 1都受到上界限制
            res += dfs(idx + 1, preIsLimit && up == digit.charAt(0), true);
        }

        if (!preIsLimit && preIsNum) {
            dp[idx] = res;
        }

        return res;
    }
}
