package com.dflong.algorithm.leetcode0;

import java.util.List;

public class _2824 {

    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        int size = nums.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    count ++;
                }
            }
        }
        return count;
    }
}
