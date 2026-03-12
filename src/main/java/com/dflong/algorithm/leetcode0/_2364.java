package com.dflong.algorithm.leetcode0;
import java.util.*;

public class _2364 {

    public long countBadPairs(int[] nums) {
        // nums[i] - i == nums[j] - j
        long res = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long key = nums[i] - i;
            res += i - map.getOrDefault(key, 0L); // 减去非坏数对

            map.put(key, map.getOrDefault(key, 0L) + 1);
        }

        return res;
    }
}
