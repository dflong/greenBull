package com.dflong.greenbull.leetcode0;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _349 {

    public static void main(String[] args) {
        new _349().intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }

        int[] res = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }
}
