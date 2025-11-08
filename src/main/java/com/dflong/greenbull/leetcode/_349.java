package com.dflong.greenbull.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> list = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
