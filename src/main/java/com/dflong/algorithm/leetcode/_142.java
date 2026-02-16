package com.dflong.algorithm.leetcode;

public class _142 {

    public ListNode detectCycle(ListNode head) {
        // 先找有没有环
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 判断环的起点
                ListNode start = head; // 从头和相遇的点一起跑，相遇就是起点
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }
}
