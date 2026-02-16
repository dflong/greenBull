package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2841 {

    public static void main(String[] args) {
        _2841 v = new _2841();
        v.maxSum(Arrays.asList(1,2,2), 2, 2);
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        long res = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            sum += nums.get(i);
        }
        if (map.size() >= m) {
            res = sum;
        }

        for (int i = k; i < nums.size(); i++) {
            map.put(nums.get(i - k), map.getOrDefault(nums.get(i - k), 0) - 1);
            if (map.get(nums.get(i - k)) <= 0) {
                map.remove(nums.get(i - k));
            }
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            sum -= nums.get(i - k);
            sum += nums.get(i);
            if (map.size() >= m) {
                res = Math.max(res, sum);
            }
        }

        return res;
    }

}
