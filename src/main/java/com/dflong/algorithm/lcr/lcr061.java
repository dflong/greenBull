package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class lcr061 {

    public static void main(String[] args) {
        lcr061 lcr061 = new lcr061();
        lcr061.kSmallestPairs(new int[]{1,2}, new int[]{3}, 3);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.get(0) + a.get(1) - b.get(0) - b.get(1);
        });
        for(int x : nums1){
            for(int y : nums2){
                pq.offer(Arrays.asList(x, y));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while(!pq.isEmpty() && k-- > 0){
            res.add(pq.poll());
        }
        return res;
    }
}
