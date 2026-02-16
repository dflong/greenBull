package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _350 {

    List<Integer> list = new ArrayList<>();
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i ++;
                j ++;
            }
            else if (nums1[i] < nums2[j]) {
                i ++;
            } else {
                j ++;
            }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}
