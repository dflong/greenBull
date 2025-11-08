package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _373 {

    public static void main(String[] args) {
        _373 v = new _373();
        List<List<Integer>> lists = v.kSmallestPairs(new int[]{1, 2, 4, 5, 6}, new int[]{3, 5, 7, 9}, 3);
        System.out.println();
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (!pq.isEmpty() && k-- > 0) {
            int[] poll = pq.poll();
            res.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));

            if (poll[1] + 1 < nums2.length) {
                // 放入的是数组下标
                pq.offer(new int[]{poll[0], poll[1] + 1});
            }
        }

        return res;
    }

}

class Pa {
    int sum;
    int[] nums;
}
