package com.dflong.algorithm.leetcode0;

public class _328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow.next = fast.next;
            slow = slow.next;
            fast.next = slow.next;
            fast = fast.next;
        }
        slow.next = newHead;
        return head;
    }
}
