package com.dflong.greenbull.leetcode0;

public class _45 {

    public int jump(int[] nums) {
        int res = 0, cur = 0, next = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            next = Math.max(next, i + nums[i]);
            if (i == cur) { // 表示跳了一步
                cur = next; // 更新到跳到达的位置
                res ++;
            }
        }
        return res;
    }

}
