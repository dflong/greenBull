package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lcr082 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        backTrack(0);
        return res;
    }

    int[] candidates;
    int target, sum = 0;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrack(int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }

        // 每个数字只能用一次
        for (int i = idx; i < candidates.length; i ++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue; // 排序后去重
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTrack(i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
