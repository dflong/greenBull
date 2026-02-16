package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            int idx = (nums[i] - 1) % n;
            if (nums[idx] <= n) {
                nums[idx] = nums[i] + n;
            }
        }

        for (int i = 0; i < n; i ++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
