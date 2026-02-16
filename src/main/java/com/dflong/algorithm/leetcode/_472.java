package com.dflong.algorithm.leetcode;

import java.util.*;

public class _472 {

    public static void main(String[] args) {
        _472 v = new _472();
        List<String> allConcatenatedWordsInADict = v.findAllConcatenatedWordsInADict(new String[]{
                "cat","dog","catdog"
        });
        System.out.println();
    }

    Set<String> set = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(word)) {
                res.add(word);
            }
        }
        return res;
    }

    boolean check(String word) {
        int n = word.length();
        // dp[i] 可由单词组成的数量
        int[] dp = new int[n + 1];

        // 递推公式 dp[j] = Math.max(dp[j], dp[i] + 1)

        // 初始化
        Arrays.fill(dp, - 1);
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (int j = i + 1; j <= n; j++) {
                String str = word.substring(i, j);
                if (set.contains(str)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }

            if (dp[n] > 1) {
                return true;
            }
        }

        return false;
    }
}
