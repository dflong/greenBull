package com.dflong.algorithm.leetcode0;

public class _2095 {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return null;
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode slow = hair, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return hair.next;
    }
}
