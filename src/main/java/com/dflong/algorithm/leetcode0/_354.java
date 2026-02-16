package com.dflong.algorithm.leetcode0;

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
                // 这里去找第一个比他大的位置更新
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

    // [[15,8],[2,20],[2,14],[4,17],[8,19],[8,9],[5,7],[11,19],[8,11],[13,11],[2,13],[11,19],[8,11],[13,11],[2,13],[11,19],[16,1],[18,13],[14,17],[18,19]]
    public static void main(String[] args) {
        new _354().maxEnvelopes1(new int[][]{
                {15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}
        });
    }
}
