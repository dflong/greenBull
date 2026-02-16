package com.dflong.algorithm.lcr;

import com.dflong.algorithm.leetcode._39;

import java.util.ArrayList;
import java.util.List;

public class lcr081 {

    public static void main(String[] args) {
        new lcr081().combinationSum(new int[] {2, 3, 6, 7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backTrack(0);
        return res;
    }

    int[] candidates;
    int target, sum = 0;
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public void backTrack(int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i ++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTrack(i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
