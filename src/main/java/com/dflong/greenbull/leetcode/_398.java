package com.dflong.greenbull.leetcode;

import java.util.Random;

public class _398 {

    class Solution {

        int[] nums;
        Random rand = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int res = 0;
            int cnt = 0;
            for (int i = 0; i < nums.length; i ++) {
                if (nums[i] == target) {
                    cnt ++;
                    if (rand.nextInt(cnt) == 0) {
                        res = i;
                    }
                }
            }
            return res;
        }
    }
}
