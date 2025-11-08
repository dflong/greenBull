package com.dflong.greenbull.leetcode;

import java.util.Arrays;

public class _453 {

    public int minMoves(int[] nums) {
        // 让所有数字变成最小值的步数
        int min = Arrays.stream(nums).min().orElse(0);
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }

        return res;
    }
}
