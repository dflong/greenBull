package com.dflong.algorithm.leetcode0;

import java.util.HashSet;
import java.util.Set;

public class _532 {

    public static void main(String[] args) {
        new _532().findPairs(new int[]{3, 1, 4, 1, 5}, 2);
    }

    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num - k)) {
                set2.add(num - k);
            }
            if (set.contains(num + k)) {
                set2.add(num);
            }
            set.add(num);
        }
        return set2.size();
    }
}
