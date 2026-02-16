package com.dflong.algorithm.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _1207 {

    public static void main(String[] args) {
        new _1207().uniqueOccurrences(new int[]{1,2});
    }

    public boolean uniqueOccurrences(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int[] res = new int[max + 1 - min];
        for (int i = 0; i < arr.length; i++) {
            res[arr[i] - min]++;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0 && set.contains(res[i])) {
                return false;
            }
            set.add(res[i]);
        }

        return true;
    }
}
