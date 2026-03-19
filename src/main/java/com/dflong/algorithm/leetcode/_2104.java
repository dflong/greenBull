package com.dflong.algorithm.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _2104 {

    public long subArrayRanges(int[] nums) {
        // 当前元素做为最大值、最小值的出现在子数组的次数
        long maxSum = getSum(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = - nums[i];
        }
        // 取反后再次算最大值就是最小值
        long minSum = getSum(nums);
        return maxSum + minSum;
    }

    private long getSum(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left, - 1);
        Arrays.fill(right, nums.length);
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 求右侧第一个比当前元素大的
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                right[stack.pollLast()] = i; // 执行后只剩余比nums[i]大的元素
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peekLast();
            }
            stack.addLast(i); // 加入的都是比当前元素小的
        }

        long res = 0;
        // 当前元素做为最大值、最小值的出现在子数组的次数
        for (int i = 0; i < nums.length; i++) {
            res += (long) (i - left[i]) * (right[i] - i) * nums[i];
        }

        return res;
    }
}
