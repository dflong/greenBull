package com.dflong.greenbull.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class _2958 {

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int max = 0, n = nums.length;
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.get(nums[r]) > k) {
                max = Math.max(max, r - l);
                int num = nums[l];
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
                l ++;
            }

            r ++;
        }
        return Math.max(max, r - l);
    }
}
