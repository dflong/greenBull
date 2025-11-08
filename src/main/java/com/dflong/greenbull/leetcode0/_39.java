package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _39 {

    public static void main(String[] args) {
        _39 v = new _39();
        v.combinationSum(new int[]{2,3,6,7}, 7);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] candidates;
    int target, sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        dfs(0);
        return res;
    }

    public void dfs(int index) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) return;

        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            list.add(candidates[i]);
            dfs(i);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
