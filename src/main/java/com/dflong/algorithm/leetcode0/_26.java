package com.dflong.algorithm.leetcode0;

public class _26 {

    public static void main(String[] args) {
        removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
    }

    /**
     * 删除有序数组重复项
     * @param nums 0,0,1,1,1,2,2,3,3,4
     * @return 0,1,2,3,4
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}

        int res = 1, l = 0; // 有效位置
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[l]) continue;
            nums[++ l] = nums[i];
            res ++;
        }
        return res;
    }
}
