package com.dflong.algorithm.leetcode;

import java.util.*;

public class _2454 {

    public int[] secondGreaterElement(int[] nums) {
        // 求右侧第二大的   2, 4, 0,  9,  6
        //               9, 6, 6, -1, -1
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, - 1);

        Deque<Integer> fir = new LinkedList<>();
        Deque<Integer> sec = new LinkedList<>();
        List<Integer> temp = new ArrayList<>(n);

        for (int i = 0; i < nums.length; i++) {
            while (!sec.isEmpty() && nums[sec.peekLast()] < nums[i]) {
                res[sec.pollLast()] = nums[i];
            }

            // 先加入fir 单调递减
            while (!fir.isEmpty() && nums[fir.peekLast()] < nums[i]) {
                temp.add(fir.pollLast());
            }

            // 后加入sec，单调递减
            for (int j = temp.size() - 1; j >= 0; j--) {
                sec.addLast(temp.get(j));
            }
            temp.clear();

            fir.addLast(i);
        }

        return res;
    }
}
