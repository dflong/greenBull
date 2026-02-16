package com.dflong.algorithm.leetcode;

public class _395 {

    public static void main(String[] args) {
        new _395().longestSubstring("aaabb", 3);
    }

    // 字符出现个数 < k 一定不是结果，做为分割点
    public int longestSubstring(String s, int k) {
        return dfs(s, k);
    }

    private int dfs(String s, int k) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            chars[s.charAt(i) - 'a'] ++;
        }

        String spilt = "";
        for (int i = 0; i < 26; i ++) {
            int cnt = chars[i];
            if (cnt > 0 && cnt < k) {
                spilt = String.valueOf((char) ('a' + i));
                break;
            }
        }

        if (spilt.isEmpty()) return s.length();

        int max = 0;
        String[] split = s.split(spilt);
        for (String str : split) {
            int subCnt = dfs(str, k);
            max = Math.max(max, subCnt);
        }

        return max;
    }
}
