package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40 {

    public static void main(String[] args) {
        new _40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    int[] candidates;
    int target, sum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            list.add(candidates[i]);
            dfs(i + 1);

            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
