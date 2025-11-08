package com.dflong.greenbull.leetcode0;

import java.util.HashMap;

public class _169 {

    public static void main(String[] args) {
        int[] nums = {2,2,1,3,1,2,2};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {

        int count = 0;
        int key = 0;
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.containsKey(nums[i])) {
                set.put(nums[i], set.get(nums[i]) + 1);
            } else {
                set.put(nums[i], 1);
            }
        }

        for (Integer integer : set.keySet()) {
            Integer count1 = set.get(integer);
            if (count1 > count) {
                count = count1;
                key = integer;
            }
        }
        return key;
    }
}
