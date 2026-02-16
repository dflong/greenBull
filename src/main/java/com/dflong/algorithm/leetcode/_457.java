package com.dflong.algorithm.leetcode;

public class _457 {

    // https://leetcode.cn/problems/poor-pigs/solutions/15770/hua-jie-suan-fa-458-ke-lian-de-xiao-zhu-by-guanpen/?envType=problem-list-v2&envId=XZ2Ltuen
    public boolean circularArrayLoop(int[] nums) {
        int offSet = 10011;
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            int cur = i, tag = offSet + i;
            while (nums[cur] < offSet) {
                int next = ((cur + nums[cur]) % n + n) % n; // 下一个点
                if (next == cur) break; // 自我循环
                if (nums[next] == tag) return true; // 存在循环
                if (nums[cur] * nums[next] < 0) break; // 不同向

                nums[cur] = tag; // 更新，为判断循环做准备
                cur = next;
            }
        }

        return false;
    }
}
