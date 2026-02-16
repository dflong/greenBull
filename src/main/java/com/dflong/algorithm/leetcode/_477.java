package com.dflong.algorithm.leetcode;

public class _477 {

    public int totalHammingDistance(int[] nums) {
        // 统计所有元素n相同位置1的个数c，则这个位置汉明距离c*(n-c)
        int total = 0, n = nums.length;
        for (int j = 0; j < 31; j ++) {
            int c = 0;
            for (int i = 0; i < n; i++ ) {
                c += (nums[i] >> j) & 1;
            }
            total += c * (n - c);
        }
        return total;
    }
}
