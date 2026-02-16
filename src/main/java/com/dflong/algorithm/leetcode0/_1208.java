package com.dflong.algorithm.leetcode0;

public class _1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int l = 0, r = 0, sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum > maxCost) {
                res = Math.max(res, r - l);
                sum -= nums[l];
                l ++;
            }
            r ++;
        }

        return Math.max(res, r - l);
    }
}
