package com.dflong.greenbull.leetcode;

import java.util.Arrays;

public class _324 {

    public static void main(String[] args) {
        new _324().wiggleSort(new int[]{1,1,2,1,2,2,1});
    }

    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int mid = (nums.length + 1) / 2, slow = mid - 1, fast = nums.length - 1;
        for (int i = 0; i < nums.length; i ++) {
            nums[i ++] = clone[slow --];
            if (fast >= mid) {
                nums[i] = clone[fast --];
            }
        }
    }
}
