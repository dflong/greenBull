package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _78 {

    public static void main(String[] args) {
        _78 v = new _78();
        List<List<Integer>> subsets = v.subsets(new int[]{1, 2, 3});
        System.out.println();
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] nums;
    int n = 0;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dfs(0);
        return res;
    }

    public void dfs(int idx) {
        res.add(new ArrayList<>(list));
        if (idx == n) return;
        for (int i = idx; i < n; i ++) {
            list.add(nums[i]);
            dfs(i + 1);
            list.remove(list.size() - 1);
        }
    }
}
