package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _228 {

    public List<String> summaryRanges(int[] nums) {

        List<String> res= new ArrayList<>();
        int begin = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == end + 1) {
                end = num;
            } else {
                if (begin == end) {
                    res.add(begin + "");
                } else {
                    res.add(begin + "->" + end);
                }
                begin = num;
                end = num;
            }
        }
        res.add(begin + "->" + end);
        return res;
    }
}
