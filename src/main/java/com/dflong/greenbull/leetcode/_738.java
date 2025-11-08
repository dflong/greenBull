package com.dflong.greenbull.leetcode;

public class _738 {

    public int monotoneIncreasingDigits(int n) {
        String[] s = String.valueOf(n).split("");
        int idx = s.length;

        for (int i = s.length - 2; i >= 0; i--) {
            if (Integer.parseInt(s[i]) > Integer.parseInt(s[i + 1])) {
                idx = i + 1;
                s[i] = Integer.parseInt(s[i]) - 1 + "";
            }
        }

        for (int i = idx; i < s.length; i++) {
            s[i] = "9";
        }

        return Integer.parseInt(String.join("", s));
    }
}
