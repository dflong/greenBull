package com.dflong.greenbull.leetcode0;

public class _2904 {

    public static void main(String[] args) {
        new _2904().shortestBeautifulSubstring("100011001", 3);
    }

    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length();
        int l = 0;
        String res = s + "1";
        for (int r = 0; r < len; r++) {
            char c = s.charAt(r);
            if (c == '1') {
                k --;
            }
            while (s.charAt(l) == '0' && l < len - 1) {
                l ++;
            }
            while (k <= 0) {
                String substring = s.substring(l, r + 1);
                if (substring.length() < res.length()) {
                    res = substring;
                } else if (substring.length() == res.length() && substring.compareTo(res) < 0) {
                    res = substring;
                }
                if (s.charAt(l) == '1') {
                    k ++;
                }
                l ++;
            }
        }
        return res.length() > len ? "" : res;
    }
}
