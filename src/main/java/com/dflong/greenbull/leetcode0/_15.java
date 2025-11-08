package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(new ArrayList<>());

        if (nums[0] + nums[1] + nums[2] > 0) {
            return res;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;  // 去重
                    while (l < r && nums[r] == nums[r - 1]) r--;  // 去重
                    l ++;
                    r --;
                } else if (sum < 0) {
                    l ++;
                } else {
                    r --;
                }
            }
        }
        return res;
    }
}
