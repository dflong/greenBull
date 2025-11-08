package com.dflong.greenbull.leetcode;

import java.util.Random;

public class _384 {

    public static void main(String[] args) {
        Solution solution = new _384().new Solution(new int[]{-6, 10, 184});
        int[] shuffle = solution.shuffle();
        int[] reset = solution.reset();
    }

    class Solution {

        int[] nums, orginal;
        Random rand = new Random();
        public Solution(int[] nums) {
            this.nums = nums;
            System.arraycopy(nums, 0, orginal = new int[nums.length], 0, nums.length);
        }

        public int[] reset() {
            System.arraycopy(orginal, 0, nums, 0, nums.length);
            return nums;
        }

        public int[] shuffle() {
            for (int i = 0; i < nums.length; i ++) {
                int j = rand.nextInt(i + 1);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return nums;
        }
    }
}
