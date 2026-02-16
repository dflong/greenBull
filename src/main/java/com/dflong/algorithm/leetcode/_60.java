package com.dflong.algorithm.leetcode;

public class _60 {

    public static void main(String[] args) {
        _60 v = new _60();
        String permutation = v.getPermutation(4, 9);
        System.out.println();
    }

    // 6 720
    // 5 120
    // 4 24 k = 9,  9 / 6 = 1 nums[0] = 2, 9 % 6 = 3 , 第一个数2， 3， 1 4
    // 3 6  K = 3, 3 / 2 = 1, nums[0] = 2, 3 % 2 = 1, nums[1] = 1
    // 2 2
    // 1 1
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        backtracking();
        return res;
    }

    // 回溯超时
    String res = "";
    int cnt = 0, n, k;
    StringBuilder sb = new StringBuilder();
    boolean[] used = new boolean[10];
    public void backtracking() {
        if (sb.length() == n) {
            cnt ++;
            if (cnt == k) {
                res = sb.toString();
                return;
            }
            return;
        }

        for (int i = 1; i <= n; i ++) {
            if (!used[i]) {
                sb.append(i);
                used[i] = true;
                backtracking();
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }
}
