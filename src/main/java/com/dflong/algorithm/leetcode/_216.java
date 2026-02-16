package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        this.k = k;
        backTracking(1);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int k, n;

    public void backTracking(int idx) {

        if (list.size() == k) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = idx; i <= 9; i++) {
            list.add(i);
            backTracking(i + 1);
            list.remove(list.size() - 1);
        }
    }
}
