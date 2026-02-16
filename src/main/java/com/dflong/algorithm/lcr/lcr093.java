package com.dflong.algorithm.lcr;

import com.sun.javafx.collections.MappingChange;

import java.util.Arrays;
import java.util.HashMap;

public class lcr093 {

    public int lenLongestFibSubseq(int[] arr) {
        // k < j < i， 以j，i位置的dp[j][i]的最长子序列
        int[][] dp = new int[arr.length][arr.length];
        // arr[k]对应的位置idx
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int res = 0;
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j --) {
                // 存在arr[k]
                int k = map.getOrDefault(arr[i] - arr[j], - 1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3); // 最小为3
                }
                res = Math.max(res, dp[j][i]);
            }
        }
        return res;
    }
}
