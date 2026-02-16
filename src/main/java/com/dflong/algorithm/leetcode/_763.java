package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _763 {

    public List<Integer> partitionLabels(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a'] = i; // 记录最后出现的位置
        }

        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            r = Math.max(r, nums[s.charAt(i) - 'a']);
            if (i == r) { // 相等时，就是最大出现的位置
                res.add(r - l + 1);
                l = r + 1;
            }
        }

        return res;
    }
}
