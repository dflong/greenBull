package com.dflong.algorithm.leetcode;

public class _440 {

    // 1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9
    // k = 2 -> 10
    // 本质是一个十叉树
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k --;

        while (cur <= n) {
            int cnt = getCnt(n, cur); // 获取当前层下有多少
            if (cnt <= k) {
                // 当前层数量不够，往右边走
                k -= cnt;
                cur ++;
            } else {
                // 就在当前层，往下走
                cur *= 10;
                k --;
            }
        }

        return (int) cur;
    }

    private int getCnt(int n, long cur) {
        long next = cur + 1;

        long cnt = 0;
        while (cur <= n) {
            cnt += Math.min(n - cur + 1, next - cur); // 在cur层，在右侧层
            cur *= 10;
            next *= 10;
        }

        return (int) cnt;
    }
}
