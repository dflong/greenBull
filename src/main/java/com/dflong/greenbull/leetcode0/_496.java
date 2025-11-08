package com.dflong.greenbull.leetcode0;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _496 {

    public static void main(String[] args) {
        _496 v = new _496();
        int[] ints = v.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = nums2[i];
            while (!queue.isEmpty() && nums2[queue.peek()] < num) {
                Integer poll = queue.poll();
                map.put(nums2[poll], nums2[i]);
            }
            queue.push(i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], - 1);
        }
        return res;
    }
}
