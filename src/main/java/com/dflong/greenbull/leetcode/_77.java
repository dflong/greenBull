package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _77 {

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTracking(1);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int n, k;

    public void backTracking(int idx) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i <= n; i++) {
            list.add(i);
            backTracking(i + 1);
            list.remove(list.size() - 1);
        }
    }
}
