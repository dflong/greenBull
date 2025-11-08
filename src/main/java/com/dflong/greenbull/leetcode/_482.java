package com.dflong.greenbull.leetcode;

public class _482 {

    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        int l = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        int size = 0;
        while (l >= 0) {
            if (s.charAt(l) == '-') {
                l --;
                continue;
            }
            if (size == k) {
                sb.append("-");
                size = 0;
            }

            sb.append(s.charAt(l));
            size ++;
            l --;
        }
        return sb.reverse().toString();
    }
}
