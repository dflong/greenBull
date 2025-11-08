package com.dflong.greenbull.leetcode;

public class _287 {

    public int findDuplicate(int[] nums) {
        // 转换为环形链表找环形开始点
        int slow = nums[0], fast = nums[nums[0]];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
