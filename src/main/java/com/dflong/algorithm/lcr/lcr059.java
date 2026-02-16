package com.dflong.algorithm.lcr;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lcr059 {

    class KthLargest {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Comparator.comparingInt(o -> o));
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
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
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }

            return pq.peek();
        }
    }
}
