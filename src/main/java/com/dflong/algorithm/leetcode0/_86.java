package com.dflong.algorithm.leetcode0;

public class _86 {

    public ListNode partition(ListNode head, int x) {
        ListNode slow = new ListNode(0), fast = new ListNode(0);
        ListNode slowHead = slow, fastHead = fast;
        while (head != null) {
            if (head.val < x) {
                slow.next = head;
                slow = slow.next;
            } else {
                fast.next = head;
                fast = fast.next;
            }
            head = head.next;
        }
        slow.next = fastHead.next;
        fast.next = null;
        return slowHead.next;
    }
}
