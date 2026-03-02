package com.dflong.algorithm.lcr;

import java.util.Arrays;

public class lcr016 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] nums = new int[128];
        Arrays.fill(nums, -1);
        int max = 1;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i);
            if (nums[idx] != -1) {
                // 发现重复就计算
                begin = Math.max(nums[idx] + 1, begin);
            }
            max = Math.max(max, i - begin + 1);
            nums[idx] = i;
        }
        max = Math.max(max, s.length() - begin);
        return max;
    }
}
