package com.dflong.greenbull.leetcode0;

public class _75 {

    public static void main(String[] args) {
        new _75().sortColors(new int[]{1, 2,1});
    }

    public void sortColors(int[] nums) {
        int index_0 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                index_0 = i;
                break;
            }
        }

        for (int i = index_0 + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tep = nums[index_0];
                nums[index_0] = nums[i];
                nums[i] = tep;
                index_0 ++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[i] != 1) {
                index_0 = i;
                break;
            }
        }

        for (int i = index_0 + 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tep = nums[index_0];
                nums[index_0] = nums[i];
                nums[i] = tep;
                index_0 ++;
            }
        }
    }
}
