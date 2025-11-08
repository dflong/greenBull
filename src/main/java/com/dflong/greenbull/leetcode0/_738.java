package com.dflong.greenbull.leetcode0;

public class _738 {

    // 从后往前
    public int monotoneIncreasingDigits(int n) {
        String[] nums = String.valueOf(n).split("");

        int start = nums.length;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (Integer.parseInt(nums[i]) > Integer.parseInt(nums[i + 1])) {
                nums[i] = (Integer.parseInt(nums[i]) - 1) + "";
                nums[i + 1] = "9";
                start = i + 1;
            }
        }

        for (int i = start; i < nums.length; i++) {
            nums[i] = "9";
        }

        return Integer.parseInt(String.join("",nums));
    }

    // 从前往后
}
