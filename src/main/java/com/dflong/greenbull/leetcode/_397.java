package com.dflong.greenbull.leetcode;

public class _397 {

    public static void main(String[] args) {
        int dfs = new _397().integerReplacement(7);
        System.out.println(dfs);
    }

    public int integerReplacement(int n) {
        return dfs(n) - 1;
    }

    public int dfs(int n) {
        if (n == 1) return 1;
        if (n % 2 == 0) return dfs(n / 2) + 1;
        return Math.min(dfs(n + 1), dfs(n - 1)) + 1;
    }
}
