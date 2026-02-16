package com.dflong.algorithm.leetcode0;

public class _2730 {

    public int longestSemiRepetitiveSubstring(String s) {
        int length = s.length();
        int[] nums = new int[length];
        for (int i = 0; i < length - 1; i++) {
            nums[i] = s.charAt(i) == s.charAt(i + 1) ? 1 : 0;
        }
        int l = 0, r = 0;
        int count = 0, max = 0;
        while (r < length) {
            if (nums[r] == 1) {
                count ++;
                while (count > 1) {
                    max = Math.max(max, r - l + 1);
                    if (nums[l] == 1) {
                        count --;
                    }
                    l ++;
                }
            }
            r ++;
        }
        return Math.max(max, r - l);
    }
}
