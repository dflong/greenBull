package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

public class lcr079 {

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backTrack(0);
        return res;
    }


    int[] nums;
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public void backTrack(int idx) {
        res.add(new ArrayList<>(path));
        if (idx == nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i ++) {
            path.add(nums[i]);
            backTrack(i + 1);
            path.remove(path.size() - 1);
        }
    }
}
