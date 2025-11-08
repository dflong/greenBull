package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18 {

    public static void main(String[] args) {
        new _18().fourSum(new int[] {1000000000,1000000000,1000000000,1000000000}, -294967296);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1, r = nums.length - 1;
                if (j >  i + 1 && nums[j] == nums[j - 1]) continue;  // 去重
                while (l < r) {
                    long sum = nums[i] % Long.MAX_VALUE + nums[j] % Long.MAX_VALUE +
                            nums[l] % Long.MAX_VALUE + nums[r] % Long.MAX_VALUE;
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l ++;  // 去重
                        while (l < r && nums[r] == nums[r - 1]) r --;  // 去重
                        l ++;
                    } else if (sum > target) {
                        r --;
                    } else {
                        l ++;
                    }
                }
            }
        }
        return res;
    }

}
