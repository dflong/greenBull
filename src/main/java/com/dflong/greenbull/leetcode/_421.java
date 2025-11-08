package com.dflong.greenbull.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _421 {

    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = 30; k >= 0; k --) { // 从最高位开始
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                set.add(num >> k);
            }

            int xN = 2 * x + 1;
            boolean found = false;
            for (int num : nums) {
                if (set.contains(xN ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xN; // 说明当前位是1
            } else {
                // 否则就是0
                x = xN - 1;
            }
        }
        return x;
    }
}
