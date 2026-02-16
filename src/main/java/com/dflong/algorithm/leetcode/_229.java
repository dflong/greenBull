package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _229 {

    public static void main(String[] args) {
        new _229().majorityElement(new int[]{2,1,1,3,1,4,5,6});
    }

    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0;
        int aCnt = 0, bCnt = 0;

        for (int num : nums) {
            if (aCnt > 0 && num == a) {
                aCnt ++;
            } else if (bCnt > 0 && num == b) {
                bCnt ++;
            } else if (bCnt == 0) {
                b = num;
                bCnt = 1;
            } else if (aCnt == 0) {
                a = num;
                aCnt = 1;
            }  else {
                aCnt --;
                bCnt --;
            }
        }

        aCnt = 0; bCnt = 0;
        for (int num : nums) {
            if (num == a) {
                aCnt ++;
            } else if (num == b) {
                bCnt ++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (aCnt > nums.length / 3) {
            res.add(a);
        }

        if (bCnt > nums.length / 3) {
            res.add(b);
        }

        return res;
    }
}
