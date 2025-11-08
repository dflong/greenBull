package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _39 {

    public static void main(String[] args) {
        new _39().combinationSum(new int[] {2, 3, 5}, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backTracking(0, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int [] candidates;
    int target;

    public void backTracking(int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTracking(candidates[i] + sum, i); // sum的回溯
            list.remove(list.size() - 1);
        }
    }
}
