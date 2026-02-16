package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        list.add(newInterval);

        int[][] intervals1 = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            intervals1[i] = list.get(i);
        }
        return merge(intervals1);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();
        int beginNum = intervals[0][0];
        int endNum = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] > endNum) {
                int[] newInterval = new int[2];
                newInterval[0] = beginNum;
                newInterval[1] = endNum;
                res.add(newInterval);
                // 更新到新位置
                beginNum = interval[0];
                endNum = interval[1];
            } else if (interval[0] == endNum) {
                endNum = interval[1];
            } else {
                endNum = Math.max(endNum, interval[1]);
            }
        }

        int[] newInterval = new int[2];
        newInterval[0] = beginNum;
        newInterval[1] = endNum;
        res.add(newInterval);

        int[][] merge = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            merge[i] = res.get(i);
        }
        return merge;
    }
}
