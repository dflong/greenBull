package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _128 {

    public static void main(String[] args) {
        _128 v = new _128();
        int i = v.longestConsecutive(new int[]{100,4,200,1,3,2});
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int cur = nums[0];
        int max = 0;
        int step = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {

            } else if (nums[i] == cur + 1) {
                step ++;
            } else {
                step = 1;
            }
            cur = nums[i];
            max = Math.max(max, step);
        }

        return max;
    }

//    public int longestConsecutive(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        int max = 0;
//        int step = 0;
//        for (int num : nums) {
//            if (!set.contains(num - 1)) {
//                step += 1;
//                while (set.contains(num + 1)) {
//                    step += 1;
//                    num += 1;
//                }
//                max = Math.max(max, step);
//            }
//            step = 0;
//        }
//        return max;
//    }
}
