package com.dflong.greenbull.leetcode;

import java.util.Arrays;

public class _473 {

    public static void main(String[] args) {
        _473 v = new _473();
        v.makesquare(new int[] {1,1,2,2,2});
    }

    int sum  = 0, t = 0;
    public boolean makesquare(int[] matchsticks) {
        for (int i : matchsticks) {
            sum += i;
        }

        t = sum / 4;
        if (t * 4 != sum) return false;

        Arrays.sort(matchsticks);

        return dfs(matchsticks, matchsticks.length - 1, new int[4]);
    }

    boolean dfs(int[] matchsticks, int idx, int[] b) {
        if (idx == - 1) return true;
        out: for (int i = 0; i < 4; i ++) {
             for (int j = i + 1; j < 4; j ++) {
                if (b[i] == b[j]) { continue out;}
             }
             int u = matchsticks[idx];
             if (b[i] + u > t) continue out;

             b[i] += u;
             if (dfs(matchsticks, idx - 1, b)) return true;
             b[i] -= u;
        }

        return false;
    }
}
