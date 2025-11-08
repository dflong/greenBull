package com.dflong.greenbull.leetcode0;

public class _55 {

    public static void main(String[] args) {
        boolean b = canJump(new int[]{0});
        System.out.println(b);
    }

    // 2,3,1,1,4
    public static boolean canJump(int[] nums) {
        int res = 0;
        for (int i = 0; i <= res; i++) {
            res = Math.max(res, i + nums[i]);
            if (res >= nums.length - 1) return true;
        }
        return false;
    }

    // 倒推
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        int step = 1; // 从0位置可以跳的最远距离
        for (int i = n - 2; i >= 0; i --) {
            if (nums[i] >= step) {
                step = 1;
            } else {
                step ++; // 如果不可达，则上一个位置需要更大的跳跃位置
            }
        }
        return step == 1;
    }
}
