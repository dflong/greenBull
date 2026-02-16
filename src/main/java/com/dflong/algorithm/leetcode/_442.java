package com.dflong.algorithm.leetcode;

import java.util.*;

public class _442 {

    public static void main(String[] args) {
        new _442().findDuplicates(new int[] {4,3,2,7,8,2,3,1});
    }

    // 4,3,2,7,8,2,3,1
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            int idx = (nums[i] - 1) % n;
            if (nums[idx] <= n) {
                // 标记出现了一次
                nums[idx] += n;
            } else {
                res.add(idx + 1);
            }
        }
        return res;
    }
}
