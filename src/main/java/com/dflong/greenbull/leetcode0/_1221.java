package com.dflong.greenbull.leetcode0;

public class _1221 {

    public int balancedStringSplit(String s) {
        int res = 0;
        int Lcount = 0, Rcount = 0;
        if (s.charAt(0) == 'L') {
            Lcount ++;
        } else {
            Rcount ++;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                Lcount ++;
            } else {
                Rcount ++;
            }
            if (Lcount == Rcount) {
                res ++;
            }
        }

        return res;
    }
}
