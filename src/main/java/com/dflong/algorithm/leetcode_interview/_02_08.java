package com.dflong.algorithm.leetcode_interview;

public class _02_08 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 相遇，说明有环
                fast = head; // 从头节点开始
                while (fast != slow) { // 同时移动 entry 和 slow，直到相遇
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast; // 返回入口节点
            }
        }
        return null; // 没有环
    }
}
