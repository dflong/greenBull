package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78 {

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backTracking(0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] nums;

    public void backTracking(int idx) {
        res.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            backTracking(i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        new _78().subsets(new int[]{0});
    }
}
