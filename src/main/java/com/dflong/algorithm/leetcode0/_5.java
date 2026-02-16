package com.dflong.algorithm.leetcode0;

public class _5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int max = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i ++) {
            int j = i;
            while (j >= 0) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j > max) {
                        max = i - j;
                        l = j;
                        r = i;
                    }
                }
                j --;
            }
        }

        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        _5 v = new _5();
        String s = v.longestPalindrome("babad");
    }

    // 对外扩散  cbbd
    public String longestPalindrome1(String s) {
        int maxLen = 1;
        int begin = 0, end = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > maxLen) {
                        maxLen = Math.max(r - l + 1, maxLen);
                        begin = l;
                        end = r;
                    }
                    l --;
                    r ++;
                } else {
                    break;
                }
            }

            l = i; r = i + 1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > maxLen) {
                        maxLen = Math.max(r - l + 1, maxLen);
                        begin = l;
                        end = r;
                    }
                    l --;
                    r ++;
                } else {
                    break;
                }
            }
        }
        return s.substring(begin, end + 1);
    }

}
