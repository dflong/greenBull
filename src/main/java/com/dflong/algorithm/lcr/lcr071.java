package com.dflong.algorithm.lcr;

import java.util.Random;

public class lcr071 {

    public static void main(String[] args) {

    }

    class Solution {
        // 生成前缀和
        int[] preSum;
        int sum = 0;
        public Solution(int[] w) {
            preSum = new int[w.length];
            preSum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                preSum[i] = preSum[i - 1] + w[i];
            }
            sum = preSum[preSum.length - 1];
        }

        // 二分查找落在哪个位置
        public int pickIndex() {
            Random random = new Random();
            int midSum = random.nextInt(sum) + 1;
            int l = 0, r = preSum.length - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (midSum <= preSum[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }
    }
}
