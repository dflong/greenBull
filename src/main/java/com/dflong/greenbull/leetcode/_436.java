package com.dflong.greenbull.leetcode;

import java.util.TreeMap;

public class _436 {

    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = intervals.length - 1; i >= 0; i --) {
            map.put(intervals[i][0], i);
        }

        int[] result = new int[intervals.length];
        for (int i = 0 ; i < intervals.length ; i ++) {
            int end = intervals[i][1];
            if (map.containsKey(end)) {
                result[i] = map.get(end);
            } else {
                Integer ceilingKey = map.ceilingKey(end);
                if (ceilingKey != null) {
                    result[i] = map.get(ceilingKey);
                } else {
                    result[i] = - 1;
                }
            }
        }

        return result;
    }
}
