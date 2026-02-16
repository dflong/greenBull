package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

public class lcr080 {

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTrack(1);

        return res;
    }

    int n, k;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrack(int idx) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (idx > n || n - idx + path.size() < k - 1) { // 截取后面不满足条件的
            return;
        }

        for (int i = idx; i <= n; i ++) {
            path.add(i);
            backTrack(i + 1);
            path.remove(path.size() - 1);
        }
    }
}
