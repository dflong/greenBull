package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _46 {

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dfs();
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] nums;
    int n;
    int[] used = new int[21];

    public void dfs() {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i ++) {
            if (used[i + 10] == 0) {
                list.add(nums[i]);
                used[i + 10] = 1;
                dfs();
                list.remove(list.size() - 1);
                used[i + 10] = 0;
            }
        }
    }
}
