package com.dflong.algorithm.leetcode0;

public class _27 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        removeElement(nums, 2);
    }

    /**
     * 移除元素
     * @param nums 4,2,0,2,2,1,4,4,1,4,3,2
     * @param val 4
     * @return [   2,2,0,2,2,1,3,1]
     */
    public static int removeElement(int[] nums, int val) {
        int j = 0; // 非删除的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
