package com.dflong.greenbull.leetcode;

public class _424 {

    public static void main(String[] args) {
        new _424().characterReplacement("AABABBA", 1);
    }

    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int l = 0, r = 0;
        int maxLen = 0;
        while (r < s.length()) {
            int num = ++ cnt[s.charAt(r) - 'A'];
            maxLen = Math.max(maxLen, num);
            if (r - l + 1 > k + maxLen) { // 字符串长度超过了最大长度 + 可变换数量
                cnt[s.charAt(l) - 'A'] --;
                l ++;
            }
            r ++;
        }
        return r - l;
    }
}
