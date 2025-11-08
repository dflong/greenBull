package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _46 {

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.used = new int[nums.length];
        backTracking();
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] used;
    int[] nums;

    public void backTracking() {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
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
