package com.dflong.algorithm.lcr;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lcr076 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i ++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            } else {
                Integer peek = pq.peek();
                if (peek < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
