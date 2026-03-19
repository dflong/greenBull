package com.dflong.algorithm.leetcode0;

import java.util.Random;

public class _528 {

    class Solution {

        int[] preSum;
        int total;

        public Solution(int[] w) {
            preSum = new int[w.length];
            preSum[0] = w[0];
            for (int i = 1; i < w.length; i ++) {
                preSum[i] = preSum[i - 1] + w[i];
            }
            total = preSum[w.length - 1];
        }

        public int pickIndex() {
            // preSum = {1, 4};
            int idx = new Random().nextInt(total);
            int l = 0, r = preSum.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (preSum[mid] > idx) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
