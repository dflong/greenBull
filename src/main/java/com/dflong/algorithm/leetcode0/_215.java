package com.dflong.algorithm.leetcode0;

import java.util.PriorityQueue;

public class _215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        while (k > 1) {
            pq.poll();
            k --;
        }
        return pq.peek();
    }
}
