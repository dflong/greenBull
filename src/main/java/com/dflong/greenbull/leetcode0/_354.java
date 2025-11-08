package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _354 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxEnvelopes1(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int n = envelopes.length;
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);

        for (int i = 1; i < n; i ++) {
            int num = envelopes[i][1];
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int idx = binary(list, num);
                list.set(idx, num);
            }
        }

        return list.size();
    }

    public int binary(List<Integer> list, int tar) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (tar > list.get(m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        new _354().maxEnvelopes1(new int[][]{
                {2,4},{6,4},{6,7},{2,3}
        });
    }
}
