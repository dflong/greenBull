package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _763 {
    public List<Integer> partitionLabels(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a'] = i;
        }

        int l = 0, r = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            r = Math.max(r, nums[s.charAt(i) - 'a']);
            if (r == i) {
                res.add(r - l + 1);
                l = r + 1;
            }
        }
        return res;
    }


}
