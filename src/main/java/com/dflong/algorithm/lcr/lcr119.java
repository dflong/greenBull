package com.dflong.algorithm.lcr;

import java.util.HashSet;

public class lcr119 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 1;

        for (Integer num : set) {
            // 如果包含了前一个数字，则距离会更长，则从前一个数字开始
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;

                while (set.contains(curNum + 1)) {
                    curNum = curNum + 1;
                    curLen ++;
                }

                res = Math.max(res, curLen);
            }
        }

        return res;
    }
}
