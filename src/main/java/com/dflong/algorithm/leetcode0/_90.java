package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.n = nums.length;
        this.nums = nums;
        dfs(0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int n;
    int[] nums;

    public void dfs(int idx) {
        res.add(new ArrayList<>(list));
        if (idx == n) return;

        for (int i = idx; i < n; i ++) {
            if (i > idx && nums[i] == nums[i - 1]) continue; //  同47去重，不同写法
            list.add(nums[i]);
            dfs(i + 1);
            list.remove(list.size() - 1);
        }
    }
}
