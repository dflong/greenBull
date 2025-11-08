package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dfs(0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] nums;
    int n;
    public void dfs(int idx) {
        if (isSort(list)) res.add(new ArrayList<>(list));
        if (idx == n) return;
//        Set<Integer> set = new HashSet<>();
        int[] used = new int[201];
        for (int i = idx; i < n; i ++) {
            if (used[nums[i] + 100] == 1) continue; // 同层去重
            list.add(nums[i]);
//            set.add(nums[i]);
            used[nums[i] + 100] = 1;
            dfs(i + 1);
            list.remove(list.size() - 1);
        }
    }

    public boolean isSort(List<Integer> list) {
        if (list.size() < 2) return false;
        for (int i = 1; i < list.size(); i ++) {
            if (list.get(i - 1) > list.get(i)) return false;
        }
        return true;
    }
}
