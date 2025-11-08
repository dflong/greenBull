package com.dflong.greenbull.leetcode0;

public class _977 {

    public static void main(String[] args) {
        new _977().sortedSquares(new int[] {-1,2,2});
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int minIndex = 0; // 最小索引
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i]) < Math.abs(nums[minIndex])) {
                minIndex = i;
            }
        }

        int l = minIndex, r = l + 1, resIndex = 0;
        while (l >= 0 && r < n) {
            if (Math.abs(nums[l]) < Math.abs(nums[r])) {
                res[resIndex++] = nums[l] * nums[l];
                l --;
            } else {
                res[resIndex++] = nums[r] * nums[r];
                r ++;
            }
        }
        while (l >= 0 ) {
            res[resIndex++] = nums[l] * nums[l];
            l --;
        }
        while (r < n) {
            res[resIndex++] = nums[r] * nums[r];
            r ++;
        }

        return res;
    }
}
