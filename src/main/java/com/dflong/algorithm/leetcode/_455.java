package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int idx = 0, child = 0;
        int res = 0;
        while (idx < s.length && child < g.length) {
            if (s[idx] >= g[child]) {
                res ++;
                child ++;
            }
            idx ++;
        }

        return res;
    }
}
