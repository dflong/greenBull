package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _179 {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return - s1.compareTo(s2);
        });

        int i = 0;
        while (i < strs.length - 1 && strs[i].equals("0")) {
            i ++;
        }

        StringBuilder sb = new StringBuilder();
        for (; i < strs.length; i++) {
            sb.append(strs[i]);
        }

        return sb.toString();
    }
}
