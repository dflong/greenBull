package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1365 {

    public static void main(String[] args) {
        new _1365().smallerNumbersThanCurrent(new int[] {8,1,2,2,3});
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // 记录数字 nums[i] 有多少个比它小的数字
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            if (!map.containsKey(res[i])) {
                map.put(res[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }
}
