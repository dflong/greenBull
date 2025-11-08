package com.dflong.greenbull.leetcode0;

public class _80 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j < 2) {
                i ++;
            } else if (nums[j] > nums[i - 2]) {
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }

//    public static int removeDuplicates(int[] nums) {
//        if (nums == null || nums.length <= 2) {
//            return nums.length;
//        }
//        int index = nums[0];
//        int size = 1;
//        int x = 0;
//        for (int i = 1; i < nums.length - x;i ++) {
//            if (nums[i] == index) {
//                size ++;
//                if (size > 2) {
//                    for (int j = i; j < nums.length - 1 - x; j ++) {
//                        int temp = nums[j];
//                        nums[j] = nums[j + 1];
//                        nums[j + 1] = temp;
//                    }
//                    i --;
//                    x ++;
//                }
//            } else {
//                index = nums[i];
//                size = 1;
//            }
//        }
//        return nums.length - x;
//    }
}
