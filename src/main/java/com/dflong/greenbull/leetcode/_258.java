package com.dflong.greenbull.leetcode;

public class _258 {

    public int addDigits(int num) {
        String s = Integer.toString(num);

        if (s.length() == 1) {
            return num;
        }

        int res = 0;
        for (int i = 0; i < s.length(); i ++) {
            res += (s.charAt(i) - '0');
        }

        return addDigits(res);
    }
}
