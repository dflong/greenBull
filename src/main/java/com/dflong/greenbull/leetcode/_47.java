package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new int[nums.length];
        backTracking();
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] nums;
    int[] used;

    public void backTracking() {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }

            // 两个相等，前一个元素未选取【1, 1, 2】
            if (i > 0 && used[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = 1;
            backTracking();
            used[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
