package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int m = g.length;
        int index = s.length - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (index>= 0 && g[i] <= s[index]) {
                res ++;
                index --;
            }
        }

        return res;
    }
}
