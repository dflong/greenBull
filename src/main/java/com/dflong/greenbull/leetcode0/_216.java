package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _216 {

    public static void main(String[] args) {
        new _216().combinationSum3(3, 7);
    }

    List<List<Integer>> res = new ArrayList<>();
    int sum = 0, n, k;
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
       this.k = k;
       this.n = n;
       dfs(1);
       return res;
    }

    public void dfs(int index) {
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i <= 9; i++) {
            list.add(i);
            sum += i;
            dfs(i + 1);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}
