package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lcr074 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = list.get(list.size() - 1);
            int[] cur = intervals[i]; // 开始位置在已有数组内部，合并
            if (cur[0] <= ints[1]) {
                list.remove(list.size() - 1);
                list.add(new int[]{ints[0], Math.max(cur[1], ints[1])});
            } else {
                list.add(cur);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
