package com.dflong.algorithm.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class _352 {

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new _352().new SummaryRanges();
        summaryRanges.addNum(3);
        summaryRanges.addNum(1);
        summaryRanges.addNum(4);
    }

    class SummaryRanges {
        TreeMap<Integer, Integer> treeMap; // k,v -> l, r

        public SummaryRanges() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int value) {
            Integer l = treeMap.floorKey(value); // 左区间左端点
            if (l != null && l <= value && value <= treeMap.get(l)) {
                return;
            }

            Integer r = treeMap.ceilingKey(value); // 右区间左端点
            if (r != null && r - 1 == value) { // value 在左端点 - 1
                treeMap.put(value, treeMap.get(r));
                treeMap.remove(r);
            } else {
                treeMap.put(value, value); // 比当前区间小的、大的都插入
            }

            if (l != null && treeMap.get(l) + 1 == value) { // value在左区间右端点 + 1
                treeMap.put(l, treeMap.get(value));
                treeMap.remove(value);
            }
        }

        public int[][] getIntervals() {
            int[][] ans = new int[treeMap.size()][2];
            int idx = 0;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                ans[idx][0] = entry.getKey();
                ans[idx++][1] = entry.getValue();
            }
            return ans;
        }


    }
}
