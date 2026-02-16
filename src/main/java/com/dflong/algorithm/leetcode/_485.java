package com.dflong.algorithm.leetcode;

public class _485 {

    public static void main(String[] args) {
        new _485().findMaxConsecutiveOnes(new int[] { 1,0,1,1,0,1 });
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int l = - 1, r = 0;
        while (r < nums.length) {
            if (nums[r] == 1) {
                r ++;
            } else {
                max = Math.max(max, r - l - 1);
                l = r;
                r ++;
            }
        }
        max = Math.max(max, r - l - 1);
        return max;
    }
}
